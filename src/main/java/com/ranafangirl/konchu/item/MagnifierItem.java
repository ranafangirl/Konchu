package com.ranafangirl.konchu.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MagnifierItem extends Item {

	public static final int USE_DURATION = 1200;
	public static final float ZOOM_FOV_MODIFIER = 0.2F;

	public MagnifierItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	public int getUseDuration(ItemStack p_151222_) {
		return 1200;
	}

	/*
	public Action<ItemStack> use(Level level, Player player, InteractionHand hand) {
		player.awardStat(Stats.ITEM_USED.get(this));
		return ItemUtils.startUsingInstantly(level, player, hand);
	}
	*/
}