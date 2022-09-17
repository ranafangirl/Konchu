package com.ranafangirl.konchu.item;

import java.util.List;

import javax.annotation.Nullable;

import com.ranafangirl.konchu.util.KonchuItemUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ProxyBlockItem extends BlockItem {
    public String description = "";
    public ProxyBlockItem(Block blockIn, CreativeModeTab group) {
        super(blockIn, new Item.Properties().tab(group));
    }        
        
    public void addInformation(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flag) {
        if(!description.equals("")) {
        	KonchuItemUtils.addText(tooltip, description, ChatFormatting.GREEN);
        }
    }
}
