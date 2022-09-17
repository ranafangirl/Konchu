package com.ranafangirl.konchu.item;

import java.util.Random;

import com.ranafangirl.konchu.init.KonchuTextTranslations;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class NetItem extends TieredItem {
	private int CatchChance;
	private int Cooldown;

	public NetItem(int catchProbability, int cooldownTime, Tiers tier, Properties properties) {
		super(tier, properties);
		this.CatchChance = catchProbability;
		this.Cooldown = cooldownTime;
	} 

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		Level level = player.level;
		int randomNum = new Random().nextInt(100);
		if(entity instanceof LivingEntity) {
			if(randomNum <= this.CatchChance) {
				if(!level.isClientSide) {
					CompoundTag tag = new CompoundTag();
					entity.stopRiding();
					entity.ejectPassengers();
					entity.saveAsPassenger(tag);
					if(!stack.hasTag()) {
						stack.setTag(new CompoundTag());
					}
					if(!stack.getTag().contains("caught_data")) {
						stack.getTag().put("caught_data", tag);
						entity.discard();
						player.awardStat(Stats.ITEM_USED.get(this));
						player.getCooldowns().addCooldown(this, this.Cooldown);
						stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.getUsedItemHand()));
						player.playSound(SoundEvents.WOOL_HIT, 1.0F, 1.0F);
					}
				}
			} else {
				player.displayClientMessage(new TextComponent(ChatFormatting.RED + KonchuTextTranslations.NET_MISSED.getKey()), true);
			}
		} else {
			player.displayClientMessage(new TextComponent(ChatFormatting.RED + KonchuTextTranslations.NET_DISALLOW.getKey()), true);
		}
		return true; 
	}	

	@SuppressWarnings("resource")
	@Override 
	public InteractionResult useOn(UseOnContext context) {
		if(!context.getLevel().isClientSide) {
			ItemStack stack = context.getItemInHand();
			if(stack.hasTag() && stack.getTag().contains("caught_data")) {
				CompoundTag tag = (CompoundTag) stack.getTag().get("caught_data");
				if(tag != null) {
					BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
					Entity e = EntityType.loadEntityRecursive(tag, context.getLevel(), (entity) -> {
						entity.moveTo(pos.getX() + 0.5f, pos.getY(), pos.getZ() + 0.5f, entity.yRotO, entity.xRotO);
						return entity;
					});
					context.getLevel().addFreshEntity(e);
					stack.getTag().remove("caught_data");
				} else {
					context.getPlayer().displayClientMessage(new TextComponent(ChatFormatting.RED + KonchuTextTranslations.NET_FULL.getKey()), true);
				}
			}
		}
		return super.useOn(context);
	}

	public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
		return !player.isCreative();
	}
}