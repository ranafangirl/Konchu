package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.block.LogBlock;
import com.ranafangirl.konchu.block.MarimoBlock;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

public class KonchuBlocks {
	public static RegistryObject<Block>
	LICHEN_GROWTH					= KonchuRegistry.BLOCKS.register("lichen_growth", 				() -> new VineBlock 		(BlockBehaviour.Properties.of(Material.PLANT,		MaterialColor.COLOR_LIGHT_GREEN).strength( 0.3F,	0.3F).sound(SoundType.CROP).requiresCorrectToolForDrops().noCollission())),
	LICHEN_BLOCK					= KonchuRegistry.BLOCKS.register("lichen_block", 				() -> new Block				(BlockBehaviour.Properties.of(Material.PLANT,		MaterialColor.COLOR_LIGHT_GREEN).strength( 0.3F,	0.3F).sound(SoundType.CROP).requiresCorrectToolForDrops())),
	STRIPPED_INFESTED_DRIFT_LOG		= KonchuRegistry.BLOCKS.register("stripped_infested_drift_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD))),
	STRIPPED_INFESTED_DRIFT_WOOD	= KonchuRegistry.BLOCKS.register("stripped_infested_drift_wood",() -> new Block				(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD))),
	INFESTED_DRIFT_LOG				= KonchuRegistry.BLOCKS.register("infested_drift_log", 			() -> new LogBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD), STRIPPED_INFESTED_DRIFT_LOG)),
	INFESTED_DRIFT_WOOD				= KonchuRegistry.BLOCKS.register("infested_drift_wood", 		() -> new Block				(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.2F,	1.0F).sound(SoundType.WOOD))),
	STRIPPED_DRIFT_LOG				= KonchuRegistry.BLOCKS.register("stripped_drift_log", 			() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD))),
	STRIPPED_DRIFT_WOOD				= KonchuRegistry.BLOCKS.register("stripped_drift_wood", 		() -> new Block				(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD))),
	DRIFT_LOG						= KonchuRegistry.BLOCKS.register("drift_log", 					() -> new LogBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD), STRIPPED_DRIFT_LOG)),
	DRIFT_WOOD						= KonchuRegistry.BLOCKS.register("drift_wood", 					() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_LIGHT_GRAY)	.strength( 1.6F,	2.0F).sound(SoundType.WOOD))),
	DRIFT_PLANKS					= KonchuRegistry.BLOCKS.register("drift_planks",				() -> new Block				(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 1.8F,	2.3F).sound(SoundType.WOOD))),
	DRIFT_STAIRS					= KonchuRegistry.BLOCKS.register("drift_stairs",				() -> new StairBlock		(() -> DRIFT_PLANKS.get().defaultBlockState(),		BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).strength(1.8F, 2.3F).sound(SoundType.WOOD))),
	DRIFT_SLAB  					= KonchuRegistry.BLOCKS.register("drift_slab", 					() -> new SlabBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 1.8F,	2.3F).sound(SoundType.WOOD))),
	DRIFT_DOOR						= KonchuRegistry.BLOCKS.register("drift_door",					() -> new DoorBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength(     		3.0F).sound(SoundType.WOOD).noOcclusion())),
	DRIFT_TRAPDOOR 					= KonchuRegistry.BLOCKS.register("drift_trapdoor", 				() -> new TrapDoorBlock 	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength(      	5.0F).sound(SoundType.WOOD).noOcclusion())),
	DRIFT_FENCE						= KonchuRegistry.BLOCKS.register("drift_fence",					() -> new FenceBlock		(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 2.0F, 	3.0F).sound(SoundType.WOOD))),
	DRIFT_FENCE_GATE				= KonchuRegistry.BLOCKS.register("drift_fence_gate", 			() -> new FenceGateBlock	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength( 2.0F, 	3.0F).sound(SoundType.WOOD))),
	DRIFT_SIGN						= KonchuRegistry.BLOCKS.register("drift_sign", 					() -> new StandingSignBlock	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength(      	1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	DRIFT_WALL_SIGN					= KonchuRegistry.BLOCKS.register("drift_wall_sign", 			() -> new WallSignBlock		(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength(      	1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	DRIFT_BUTTON					= KonchuRegistry.BLOCKS.register("drift_button", 				() -> new WoodButtonBlock	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BLACK)	.strength(      	0.5F).sound(SoundType.WOOD).noCollission())),
	DRIFT_PRESSURE_PLATE			= KonchuRegistry.BLOCKS.register("drift_pressure_plate", 		() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,			BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).strength(0.5F).sound(SoundType.WOOD).noCollission())),
	STRIPPED_CHERRY_LOG				= KonchuRegistry.BLOCKS.register("stripped_cherry_log", 		() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BROWN)	.strength( 1.6F, 	2.0F).sound(SoundType.WOOD))),
	STRIPPED_CHERRY_WOOD			= KonchuRegistry.BLOCKS.register("stripped_cherry_wood",		() -> new Block				(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.TERRACOTTA_BROWN)	.strength( 1.6F, 	2.0F).sound(SoundType.WOOD))),
	CHERRY_LOG						= KonchuRegistry.BLOCKS.register("cherry_log", 					() -> new LogBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength( 1.6F, 	2.0F).sound(SoundType.WOOD), STRIPPED_CHERRY_LOG)),
	CHERRY_WOOD						= KonchuRegistry.BLOCKS.register("cherry_wood", 				() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength( 1.6F, 	2.0F).sound(SoundType.WOOD))),
	CHERRY_PLANKS 					= KonchuRegistry.BLOCKS.register("cherry_planks",				() -> new Block				(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength( 1.8F, 	2.3F).sound(SoundType.WOOD))),
	CHERRY_STAIRS 					= KonchuRegistry.BLOCKS.register("cherry_stairs",				() -> new StairBlock		(() -> CHERRY_PLANKS.get().defaultBlockState(), 	BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(1.8F, 2.3F).sound(SoundType.WOOD))),
	CHERRY_SLAB  					= KonchuRegistry.BLOCKS.register("cherry_slab", 				() -> new SlabBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength( 1.8F, 	2.3F).sound(SoundType.WOOD))),
	CHERRY_DOOR						= KonchuRegistry.BLOCKS.register("cherry_door",					() -> new DoorBlock			(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength(      	3.0F).sound(SoundType.WOOD).noOcclusion())),
	CHERRY_TRAPDOOR					= KonchuRegistry.BLOCKS.register("cherry_trapdoor", 			() -> new TrapDoorBlock 	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength(      	5.0F).sound(SoundType.WOOD).noOcclusion())),
	CHERRY_FENCE					= KonchuRegistry.BLOCKS.register("cherry_fence",				() -> new FenceBlock		(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength( 2.0F,	3.0F).sound(SoundType.WOOD))),
	CHERRY_FENCE_GATE				= KonchuRegistry.BLOCKS.register("cherry_fence_gate", 			() -> new FenceGateBlock	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength( 2.0F, 	3.0F).sound(SoundType.WOOD))),
	CHERRY_SIGN						= KonchuRegistry.BLOCKS.register("cherry_sign", 				() -> new StandingSignBlock	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength(			1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	CHERRY_WALL_SIGN				= KonchuRegistry.BLOCKS.register("cherry_wall_sign", 			() -> new WallSignBlock		(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength(			1.0F).sound(SoundType.WOOD), WoodType.OAK)),
	CHERRY_BUTTON					= KonchuRegistry.BLOCKS.register("cherry_button", 				() -> new WoodButtonBlock	(BlockBehaviour.Properties.of(Material.WOOD,		MaterialColor.COLOR_PINK)		.strength(			0.5F).sound(SoundType.WOOD).noCollission())),
	CHERRY_PRESSURE_PLATE			= KonchuRegistry.BLOCKS.register("cherry_pressure_plate", 		() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,			BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOD).noCollission())),
  //CHERRY_SAPLING					= KonchuRegistry.BLOCKS.register("cherry_sapling", 				() -> new SaplingBlock		(new CherryTree(), BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.SNOW).sound(SoundType.GRASS).noOcclusion().randomTicks().instabreak()));
	WHITE_CHERRY_LEAVES				= KonchuRegistry.BLOCKS.register("white_cherry_leaves", 		() -> new LeavesBlock		(BlockBehaviour.Properties.of(Material.LEAVES, 		MaterialColor.SNOW)				.strength( 0.2F,	0.2F).sound(SoundType.GRASS).noOcclusion())),
	PINK_CHERRY_LEAVES				= KonchuRegistry.BLOCKS.register("pink_cherry_leaves", 			() -> new LeavesBlock		(BlockBehaviour.Properties.of(Material.LEAVES, 		MaterialColor.COLOR_PINK)		.strength( 0.2F,	0.2F).sound(SoundType.GRASS).noOcclusion())),
	MAGENTA_CHERRY_LEAVES			= KonchuRegistry.BLOCKS.register("magenta_cherry_leaves", 		() -> new LeavesBlock		(BlockBehaviour.Properties.of(Material.LEAVES, 		MaterialColor.COLOR_MAGENTA)	.strength( 0.2F,	0.2F).sound(SoundType.GRASS).noOcclusion())),
	MARIMO							= KonchuRegistry.BLOCKS.register("marimo", 						() -> new MarimoBlock		(BlockBehaviour.Properties.of(Material.VEGETABLE,	MaterialColor.TERRACOTTA_GREEN)	.strength( 1.0F,	1.0F).sound(SoundType.WET_GRASS))),
	CRAB_BLOCK						= KonchuRegistry.BLOCKS.register("crab_block",					() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE,		MaterialColor.COLOR_RED)		.strength(25.0F,   99.0F).sound(SoundType.NETHERRACK).requiresCorrectToolForDrops()));

	public static void registerRenderType() {
	renderType(LICHEN_GROWTH.get(), 		RenderType.cutoutMipped());
	renderType(CHERRY_DOOR.get(), 			RenderType.cutoutMipped());
	renderType(CHERRY_TRAPDOOR.get(), 		RenderType.cutoutMipped());
	renderType(WHITE_CHERRY_LEAVES.get(), 	RenderType.translucent());
	renderType(PINK_CHERRY_LEAVES.get(), 	RenderType.translucent());
	renderType(MAGENTA_CHERRY_LEAVES.get(), RenderType.translucent());
	}
	
	public static void renderType(Block block, RenderType renderType) {
		ItemBlockRenderTypes.setRenderLayer(block, renderType);
	}
}






