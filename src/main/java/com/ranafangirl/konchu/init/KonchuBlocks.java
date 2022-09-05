package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.block.LogBlock;
import com.ranafangirl.konchu.block.MarimoBlock;
import com.ranafangirl.konchu.block.RotatedBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;

public class KonchuBlocks {
	public static RegistryObject<Block>
	LICHEN_GROWTH					= KonchuRegistry.BLOCKS.register("lichen_growth", 				() -> new VineBlock 		(AbstractBlock.Properties.of(Material.PLANT,		MaterialColor.COLOR_LIGHT_GREEN).strength( 0.3F,	0.3F).sound(SoundType.CROP).harvestLevel(0).noCollission())),
	LICHEN_BLOCK					= KonchuRegistry.BLOCKS.register("lichen_block", 				() -> new Block				(AbstractBlock.Properties.of(Material.PLANT,		MaterialColor.COLOR_LIGHT_GREEN).strength( 0.3F,	0.3F).sound(SoundType.CROP).harvestLevel(0))),
	KAOLINITE						= KonchuRegistry.BLOCKS.register("kaolinite", 					() -> new Block				(AbstractBlock.Properties.of(Material.PLANT,		MaterialColor.COLOR_LIGHT_GRAY)	.strength( 0.8F,	0.2F).sound(SoundType.GRAVEL).harvestLevel(0))),
	STRIPPED_INFESTED_DRIFT_LOG		= KonchuRegistry.BLOCKS.register("stripped_infested_drift_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD))),
	STRIPPED_INFESTED_DRIFT_WOOD	= KonchuRegistry.BLOCKS.register("stripped_infested_drift_wood",() -> new Block				(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD))),
	INFESTED_DRIFT_LOG				= KonchuRegistry.BLOCKS.register("infested_drift_log", 			() -> new LogBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD), STRIPPED_INFESTED_DRIFT_LOG)),
	INFESTED_DRIFT_WOOD				= KonchuRegistry.BLOCKS.register("infested_drift_wood", 		() -> new Block				(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD))),
	STRIPPED_DRIFT_LOG				= KonchuRegistry.BLOCKS.register("stripped_drift_log", 			() -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD))),
	STRIPPED_DRIFT_WOOD				= KonchuRegistry.BLOCKS.register("stripped_drift_wood", 		() -> new Block				(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD))),
	DRIFT_LOG						= KonchuRegistry.BLOCKS.register("drift_log", 					() -> new LogBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD), STRIPPED_DRIFT_LOG)),
	DRIFT_WOOD						= KonchuRegistry.BLOCKS.register("drift_wood", 					() -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD))),
	DRIFT_PLANKS					= KonchuRegistry.BLOCKS.register("drift_planks",				() -> new Block				(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 1.8F,	2.3F).sound(SoundType.WOOD))),
	DRIFT_STAIRS					= KonchuRegistry.BLOCKS.register("drift_stairs",				() -> new StairsBlock		(() -> DRIFT_PLANKS.get().defaultBlockState(),		AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).strength(1.8F, 2.3F).sound(SoundType.WOOD))),
	DRIFT_SLAB  					= KonchuRegistry.BLOCKS.register("drift_slab", 					() -> new SlabBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 1.8F,	2.3F).sound(SoundType.WOOD))),
	DRIFT_DOOR						= KonchuRegistry.BLOCKS.register("drift_door",					() -> new DoorBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength(     		3.0F).sound(SoundType.WOOD).noOcclusion())),
	DRIFT_TRAPDOOR 					= KonchuRegistry.BLOCKS.register("drift_trapdoor", 				() -> new TrapDoorBlock 	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength(      	5.0F).sound(SoundType.WOOD).noOcclusion())),
	DRIFT_FENCE						= KonchuRegistry.BLOCKS.register("drift_fence",					() -> new FenceBlock		(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 2.0F, 	3.0F).sound(SoundType.WOOD))),
	DRIFT_FENCE_GATE				= KonchuRegistry.BLOCKS.register("drift_fence_gate", 			() -> new FenceGateBlock	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength( 2.0F, 	3.0F).sound(SoundType.WOOD))),
	DRIFT_SIGN						= KonchuRegistry.BLOCKS.register("drift_sign", 					() -> new StandingSignBlock	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength(      	1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	DRIFT_WALL_SIGN					= KonchuRegistry.BLOCKS.register("drift_wall_sign", 			() -> new WallSignBlock		(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength(      	1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	DRIFT_BUTTON					= KonchuRegistry.BLOCKS.register("drift_button", 				() -> new WoodButtonBlock	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BLACK)	.strength(      	0.5F).sound(SoundType.WOOD).noCollission())),
	DRIFT_PRESSURE_PLATE			= KonchuRegistry.BLOCKS.register("drift_pressure_plate", 		() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,			AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).strength(0.5F).sound(SoundType.WOOD).noCollission())),
	STRIPPED_CHERRY_LOG				= KonchuRegistry.BLOCKS.register("stripped_cherry_log", 		() -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BROWN)	.strength( 1.6F, 	2.0F).sound(SoundType.WOOD))),
	STRIPPED_CHERRY_WOOD			= KonchuRegistry.BLOCKS.register("stripped_cherry_wood",		() -> new Block				(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.TERRACOTTA_BROWN)	.strength( 1.6F, 	2.0F).sound(SoundType.WOOD))),
	CHERRY_LOG						= KonchuRegistry.BLOCKS.register("cherry_log", 					() -> new LogBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength( 1.6F, 	2.0F).sound(SoundType.WOOD), STRIPPED_CHERRY_LOG)),
	CHERRY_WOOD						= KonchuRegistry.BLOCKS.register("cherry_wood", 				() -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength( 1.6F, 	2.0F).sound(SoundType.WOOD))),
	CHERRY_PLANKS 					= KonchuRegistry.BLOCKS.register("cherry_planks",				() -> new Block				(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength( 1.8F, 	2.3F).sound(SoundType.WOOD))),
	CHERRY_STAIRS 					= KonchuRegistry.BLOCKS.register("cherry_stairs",				() -> new StairsBlock		(() -> CHERRY_PLANKS.get().defaultBlockState(), 	AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(1.8F, 2.3F).sound(SoundType.WOOD))),
	CHERRY_SLAB  					= KonchuRegistry.BLOCKS.register("cherry_slab", 				() -> new SlabBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength( 1.8F, 	2.3F).sound(SoundType.WOOD))),
	CHERRY_DOOR						= KonchuRegistry.BLOCKS.register("cherry_door",					() -> new DoorBlock			(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength(      	3.0F).sound(SoundType.WOOD).noOcclusion())),
	CHERRY_TRAPDOOR					= KonchuRegistry.BLOCKS.register("cherry_trapdoor", 			() -> new TrapDoorBlock 	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength(      	5.0F).sound(SoundType.WOOD).noOcclusion())),
	CHERRY_FENCE					= KonchuRegistry.BLOCKS.register("cherry_fence",				() -> new FenceBlock		(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength( 2.0F,	3.0F).sound(SoundType.WOOD))),
	CHERRY_FENCE_GATE				= KonchuRegistry.BLOCKS.register("cherry_fence_gate", 			() -> new FenceGateBlock	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength( 2.0F, 	3.0F).sound(SoundType.WOOD))),
	CHERRY_SIGN						= KonchuRegistry.BLOCKS.register("cherry_sign", 				() -> new StandingSignBlock	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength(			1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	CHERRY_WALL_SIGN				= KonchuRegistry.BLOCKS.register("cherry_wall_sign", 			() -> new WallSignBlock		(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength(			1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	CHERRY_BUTTON					= KonchuRegistry.BLOCKS.register("cherry_button", 				() -> new WoodButtonBlock	(AbstractBlock.Properties.of(Material.WOOD,			MaterialColor.COLOR_PINK)		.strength(			0.5F).sound(SoundType.WOOD).noCollission())),
	CHERRY_PRESSURE_PLATE			= KonchuRegistry.BLOCKS.register("cherry_pressure_plate", 		() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,			AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOD).noCollission())),
	//CHERRY_SAPLING			= KonchuRegistry.BLOCKS.register("cherry_sapling", 			() -> new SaplingBlock	(new CherryTree(), AbstractBlock.Properties.of(Material.PLANT, MaterialColor.SNOW).sound(SoundType.GRASS).noOcclusion().randomTicks().instabreak()));
	WHITE_CHERRY_LEAVES				= KonchuRegistry.BLOCKS.register("white_cherry_leaves", 		() -> new LeavesBlock		(AbstractBlock.Properties.of(Material.LEAVES, 		MaterialColor.SNOW)				.strength( 0.2F,	0.2F).sound(SoundType.GRASS).noOcclusion())),
	PINK_CHERRY_LEAVES				= KonchuRegistry.BLOCKS.register("pink_cherry_leaves", 			() -> new LeavesBlock		(AbstractBlock.Properties.of(Material.LEAVES, 		MaterialColor.COLOR_PINK)		.strength( 0.2F,	0.2F).sound(SoundType.GRASS).noOcclusion())),
	MAGENTA_CHERRY_LEAVES			= KonchuRegistry.BLOCKS.register("magenta_cherry_leaves", 		() -> new LeavesBlock		(AbstractBlock.Properties.of(Material.LEAVES, 		MaterialColor.COLOR_MAGENTA)	.strength( 0.2F,	0.2F).sound(SoundType.GRASS).noOcclusion())),
	MARIMO							= KonchuRegistry.BLOCKS.register("marimo", 						() -> new MarimoBlock		(AbstractBlock.Properties.of(Material.VEGETABLE,	MaterialColor.TERRACOTTA_GREEN)	.strength( 1.0F,	1.0F).sound(SoundType.WET_GRASS))),
	CRAB_BLOCK						= KonchuRegistry.BLOCKS.register("crab_block",					() -> new RotatedBlock		(AbstractBlock.Properties.of(Material.STONE,		MaterialColor.COLOR_RED)		.strength(25.0F,   99.0F).sound(SoundType.NETHERRACK).harvestLevel(1)));
}





