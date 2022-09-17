package com.ranafangirl.konchu.item;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
public class ProxySpawnEggItem extends SpawnEggItem {
	protected static final ArrayList<ProxySpawnEggItem> EGGS_TO_ADD = new ArrayList<ProxySpawnEggItem>();
	private final int color1;
	private final int color2;
	private final Lazy<? extends EntityType<?>> lazyEntity;

	public ProxySpawnEggItem(final RegistryObject<? extends EntityType<?>> entity, int color1, int color2, final Properties properties) {
		super(null, color1, color2, properties);
		this.color1 = 0;
		this.color2 = 0;
		this.lazyEntity = Lazy.of(entity::get);
		EGGS_TO_ADD.add(this);
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 1;
	}

	@OnlyIn(Dist.CLIENT)
	public int getColor(int color) {
		return color == 0 ? this.color1 : this.color2;
	}

	public static void initSpawnEggs() {
		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
		for (final SpawnEggItem item : EGGS_TO_ADD) {
			EGGS.put(item.getType(null), item);
		}
		EGGS_TO_ADD.clear();
	}

	@Override
	public EntityType<?> getType(CompoundTag nbt) {
		return this.lazyEntity.get();
	}

	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		if (!(world instanceof ServerLevel)) {
			return InteractionResult.SUCCESS;
		} else {
			ItemStack itemstack = context.getItemInHand();
			BlockPos blockpos = context.getClickedPos();
			Direction direction = context.getClickedFace();
			BlockState blockstate = world.getBlockState(blockpos);
			BlockPos blockpos1;
			if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
				blockpos1 = blockpos;
			} else {
				blockpos1 = blockpos.relative(direction);
			}
			EntityType<?> entitytype = this.getType(itemstack.getTag());
			CompoundTag NBT = new CompoundTag();
			if (itemstack.hasTag()) {
				NBT.merge(itemstack.getTag());
			}
			if (!NBT.contains("EntityTag")) {
				NBT.put("EntityTag", new CompoundTag());
			}
			Entity summonedEntity = entitytype.spawn((ServerLevel) world, NBT, null, context.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
			if (summonedEntity != null) {
				itemstack.shrink(1);
			}
			return InteractionResult.CONSUME;
		}
	}
}
