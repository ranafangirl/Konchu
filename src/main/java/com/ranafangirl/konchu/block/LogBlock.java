package com.ranafangirl.konchu.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class LogBlock extends RotatedPillarBlock {
	@SuppressWarnings("unused")
	private RegistryObject<Block> stripped;
	
	public LogBlock(Properties properties, RegistryObject<Block> block) {
		super(properties);
		stripped = block; 
	}
	
	@SuppressWarnings("unused")
	private BlockState getLogState(RegistryObject<Block> block) {
		return block.get().defaultBlockState();
	} 

}
