package com.ranafangirl.konchu.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.ranafangirl.konchu.client.render.entity.SnailRenderer;
import com.ranafangirl.konchu.init.KonchuEntityType;
import com.ranafangirl.konchu.util.goals.HideFromEntityGoal;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.easing.EasingType;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class Snail extends Animal implements IAnimatable {
	public static final EntityDataAccessor<Integer> SNAIL_TYPE = SynchedEntityData.defineId(Snail.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> HIDING = SynchedEntityData.defineId(Snail.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MOVING = SynchedEntityData.defineId(Snail.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TRUSTING = SynchedEntityData.defineId(Snail.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Snail.class, EntityDataSerializers.BYTE);
	//private static final EntitySelector SNAIL_AFRAID_TARGET = (new EntitySelector()).range(5.0D).allowSameTeam();
	private static final Ingredient DIET = Ingredient.of(Items.RED_MUSHROOM);
	private Snail.SnailAvoidEntityGoal<Player> snailAvoidPlayersGoal;
	private AnimationFactory factory = new AnimationFactory(this);
	private int afraid;
	private int mostAfraid = 30;
	private int shakeIntensity;
	private int moreShakeIntensity;
	private boolean ignoreFrustumCheck;
	
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new HideFromEntityGoal(this, 0));
		this.goalSelector.addGoal(8, new BreedGoal(this, 0.8D));
	}

	public Snail(EntityType<? extends Animal> type, Level level) {
		super(type, level);
		this.ignoreFrustumCheck = true;
		this.goalSelector.addGoal(5, new HideFromEntityGoal(this, 0));
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new BreedGoal(this, 0.8D));
		this.reassessTrustingGoals();
	}
	
    public static boolean canSpawn(EntityType<Snail> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, Random random) {
        return checkAnimalSpawnRules(entity, levelAccess, spawnType, pos, random) && pos.getY() > 70;
    }

	protected PathNavigation createNavigation(Level level) {
		return new WallClimberNavigation(this, level);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions dimensions) {
		return dimensions.height * 0.4F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, (double) 0.1F)
				.add(Attributes.MAX_HEALTH, 3.0D)
				.add(Attributes.FOLLOW_RANGE, 6.0D)
				.add(Attributes.JUMP_STRENGTH, 0.2D)
				.add(Attributes.FOLLOW_RANGE, 2.0D);
	}

	public boolean isFood(ItemStack itemStack) {
		return DIET.test(itemStack);
	}

	public void addAdditionalSaveData(CompoundTag nbt) {
		super.addAdditionalSaveData(nbt);
		nbt.putBoolean("Trusting", this.isTrusting());
		if (this.entityData != null) {
			nbt.putInt("SnailType", this.entityData.get(SNAIL_TYPE));
		}
		nbt.putBoolean("Hiding", isHiding());
	}

	public void readAdditionalSaveData(CompoundTag nbt) {
		super.readAdditionalSaveData(nbt);
		this.setTrusting(nbt.getBoolean("Trusting"));
		if (nbt.contains("SnailType")) {
			this.setSnailType(nbt.getInt("SnailType"));
		} else {
			this.setSnailType(this.random.nextInt(6));
		}
		if(nbt.contains("Hiding")){
			this.setHiding(nbt.getBoolean("Hiding"));
		}else{
			this.setHiding(false);
		}
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(SNAIL_TYPE, random.nextInt(6));
		this.entityData.define(HIDING, false);
		this.entityData.define(MOVING, false);
		this.entityData.define(TRUSTING, false);
		this.entityData.define(DATA_FLAGS_ID, (byte)0);
	}

	public int getSnailType() {
		return this.entityData.get(SNAIL_TYPE).intValue();
	}

	public void setSnailType(int mate) {
		if (mate < 0 || mate >= 6) {
			mate = this.random.nextInt(5);
		}
		if (this.entityData != null) {
			this.entityData.set(SNAIL_TYPE, mate);
		}
	}

	@Override
	public boolean removeWhenFarAway(double d) {
		return !this.isTrusting() && this.tickCount > 2;
	}

	boolean isTrusting() {
		return this.entityData.get(TRUSTING);
	}

	private void setTrusting(boolean b) {
		this.setHiding(false);
		this.entityData.set(TRUSTING, b);
		this.reassessTrustingGoals();
	}

	protected void reassessTrustingGoals() {
		if (this.snailAvoidPlayersGoal == null) {
			setHiding(false);
			//this.snailAvoidPlayersGoal = new Snail.SnailAvoidEntityGoal<>(this, PlayerEntity.class, 16.0F, 0.8D, 1.33D);
		}
		this.goalSelector.removeGoal(this.snailAvoidPlayersGoal);

		if (!this.isTrusting()) {
			this.goalSelector.addGoal(4, this.snailAvoidPlayersGoal);
		}
	}

	public boolean isSteppingCarefully() {
		return this.getPose() == Pose.CROUCHING || super.isSteppingCarefully(); 
	}  

	@Override
	public void tick() {
		if (this.getDeltaMovement().x != 0) {
			if (!this.getEntityData().get(MOVING)) {
				this.getEntityData().set(MOVING, true);
			}
		} else {
			if (this.getEntityData().get(MOVING)) {
				this.getEntityData().set(MOVING, false);
			}
		}
		if (!this.level.isClientSide) {
			this.setClimbing(this.horizontalCollision);
		}
		super.tick();
		if(this.isClimbing()) this.setYBodyRot(SnailRenderer.getRotation(this) * 90F - 180);
	}

	protected void customServerAiStep() {
		super.customServerAiStep();
		if (!this.isHiding()) {
			//if (this.level.getNearestPlayer(SNAIL_AFRAID_TARGET, this) != null) {
				//this.setHiding(true);
			//}
		}
	}

	private int getRotation(int rotation) {
		if (rotation > (  0 + 45) && rotation < ( 90 + 45)) return 1; // E
		if (rotation > ( 90 + 45) && rotation < (180 + 45)) return 2; // S
		if (rotation > (180 + 45) && rotation < (270 + 45)) return 3; // W
		return 0; 													  // N
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob entity) {
		Snail snailentity = new Snail(KonchuEntityType.SNAIL.get(), level);
		if (entity instanceof Snail) {
			if (this.random.nextBoolean()) {
				snailentity.setSnailType(this.getSnailType());
			} else {
				snailentity.setSnailType(((Snail)entity).getSnailType());
			}
		}
		return snailentity;
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevel level, DifficultyInstance instance, MobSpawnType spawnType, @Nullable SpawnGroupData data, @Nullable CompoundTag nbt) {
		data = super.finalizeSpawn(level, instance, spawnType, data, nbt);
		return data;
	}

	public void setHiding(boolean state) {
		this.getEntityData().set(HIDING, state);
		if (state) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(35.0);
			this.goalSelector.removeGoal(new SnailTemptGoal(this, 2.0D, DIET, false));
			this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
			this.jumping = false;
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(3.0);
			this.goalSelector.addGoal(3, new SnailTemptGoal(this, 2.0D, DIET, false));
			this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
			this.jumping = true;
		}
	}

	public boolean isHiding() {
		return this.getEntityData().get(HIDING);
	}

	public boolean isMoving(){
		return this.getEntityData().get(MOVING);
	}

	public boolean isClimbing() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	public boolean onClimbable() {
		return this.isClimbing();
	}

	public void setClimbing(boolean bool) {
		byte b0 = this.entityData.get(DATA_FLAGS_ID);
		if (bool) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}
		this.entityData.set(DATA_FLAGS_ID, b0);
	}

	/*
	@Override
	public boolean hurt(DamageSource damage, float f) {
		setHiding(true);
		this.reassessTrustingGoals();
		return super.hurt(damage, f);
	}
	 */

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			Entity entity = source.getDirectEntity();
			if (this.isHiding() && entity instanceof Projectile) {
				return false;
			} else if (source == DamageSource.CACTUS || source == DamageSource.SWEET_BERRY_BUSH) {
				return false;
			}
			return super.hurt(source, amount);
		}	
	}

	@OnlyIn(Dist.CLIENT)
	public float getShakeAmount(float partialTicks) {
		return Mth.lerp(partialTicks, this.moreShakeIntensity, this.shakeIntensity) / 20.0F; 
	}

	public void knockback(float f, double d1, double d2) {
		if (this.isHiding()) {
			return;
		}
		super.knockback(f, d1, d2);
	}

	public boolean causeFallDamage(float f1, float f2) {
		boolean flag = super.causeFallDamage(f1, f2, getLastDamageSource());
		this.afraid = (int)((float)this.afraid + f1 * 1.5F);
		if (this.afraid > this.mostAfraid - 5) {
			this.afraid = this.mostAfraid - 5;
		}
		return flag;
	}

	static class SnailAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
		private final Snail snail;
		public SnailAvoidEntityGoal(Snail snail, Class<T> classObj, float f, double d1, double d2) {
			super(snail, classObj, f, d1, d2, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
			this.snail = snail;
		}
		public boolean canUse() {
			return !this.snail.isTrusting() && super.canUse();
		}
		public boolean canContinueToUse() {
			return !this.snail.isTrusting() && super.canContinueToUse();
		}
	}

	static class SnailTemptGoal extends TemptGoal {
		private final Snail snail;
		public SnailTemptGoal(Snail snail, double d, Ingredient ingredient, boolean b) {
			super(snail, d, ingredient, b);
			this.snail = snail;
		}
		protected boolean canScare() {
			return super.canScare() && !this.snail.isTrusting();
		}
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!this.isHiding()) {
			if (this.isMoving()) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("snail_move", true));
			} else {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("snail_idle", true));       	
			}
		} else {

			if (this.isHiding()) {			
				event.getController().easingType = EasingType.EaseInOutBounce;
				event.getController().setAnimation(new AnimationBuilder().addAnimation("snail_hide", false));
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("snail_hiding", true));
		}
		return PlayState.CONTINUE;
	}

	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	public AnimationFactory getFactory() {
		return this.factory;
	}
}