package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.item.MagnifierItem;
import com.ranafangirl.konchu.item.NetItem;
import com.ranafangirl.konchu.item.ProxyBlockItem;
import com.ranafangirl.konchu.item.ProxySpawnEggItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
	
public class KonchuItems {
	public static final RegistryObject<Item>
	NET									= KonchuRegistry.ITEMS.register("net", 							() -> new NetItem		(30, ItemTier.STONE, 		 ItemGroup.TAB_TOOLS)),
	GOLDEN_NET							= KonchuRegistry.ITEMS.register("golden_net", 					() -> new NetItem		(80, ItemTier.GOLD, 		 ItemGroup.TAB_TOOLS)),
	MAGNIFIER							= KonchuRegistry.ITEMS.register("magnifier", 					() -> new MagnifierItem	(new Item.Properties(), 	 ItemGroup.TAB_TOOLS)),
	LICHEN_CLUMP 						= KonchuRegistry.ITEMS.register("lichen_clump", 				() -> new Item			(new Item.Properties()	.tab(ItemGroup.TAB_MISC))),
	MOSS_CLUMP 							= KonchuRegistry.ITEMS.register("moss_clump", 					() -> new Item			(new Item.Properties()	.tab(ItemGroup.TAB_MISC).stacksTo(16))),
	ROTTEN_BARK 						= KonchuRegistry.ITEMS.register("rotten_bark", 					() -> new Item			(new Item.Properties()	.tab(ItemGroup.TAB_MISC))),
	CRAB_SHELL 							= KonchuRegistry.ITEMS.register("crab_shell",					() -> new Item			(new Item.Properties()	.tab(ItemGroup.TAB_MISC).stacksTo(16))),
    MUSIC_DISC_HELIX					= KonchuRegistry.ITEMS.register("music_disc_helix", 			() -> new MusicDiscItem		(5, KonchuSoundEvents.MUSIC_DISC_HELIX, 		 new Item.Properties().rarity(Rarity.RARE)	.tab(ItemGroup.TAB_MISC).stacksTo(1))),
    MUSIC_DISC_SUBURBAN					= KonchuRegistry.ITEMS.register("music_disc_suburban",			() -> new MusicDiscItem		(5, KonchuSoundEvents.MUSIC_DISC_SUBURBAN,		 new Item.Properties().rarity(Rarity.RARE)	.tab(ItemGroup.TAB_MISC).stacksTo(1))),
    SNAIL_SPAWN_EGG						= KonchuRegistry.ITEMS.register("snail_spawn_egg", 				() -> new ProxySpawnEggItem	(KonchuEntityType.SNAIL, 0xAF8C6B, 0xA8C68F,	(new Item.Properties())						.tab(ItemGroup.TAB_MISC))),
    LICHEN_GROWTH_ITEM					= KonchuRegistry.ITEMS.register("lichen_growth", 				() -> new ProxyBlockItem(KonchuBlocks.LICHEN_GROWTH.get(),					ItemGroup.TAB_DECORATIONS)),
    LICHEN_BLOCK_ITEM 					= KonchuRegistry.ITEMS.register("lichen_block", 				() -> new ProxyBlockItem(KonchuBlocks.LICHEN_BLOCK.get(),					ItemGroup.TAB_DECORATIONS)),
    KAOLINITE_ITEM 						= KonchuRegistry.ITEMS.register("kaolinite", 					() -> new ProxyBlockItem(KonchuBlocks.KAOLINITE.get(),						ItemGroup.TAB_DECORATIONS)),
    STRIPPED_INFESTED_DRIFT_LOG_ITEM 	= KonchuRegistry.ITEMS.register("stripped_infested_drift_log", 	() -> new ProxyBlockItem(KonchuBlocks.STRIPPED_INFESTED_DRIFT_LOG.get(), 	ItemGroup.TAB_BUILDING_BLOCKS)),
    STRIPPED_INFESTED_DRIFT_WOOD_ITEM	= KonchuRegistry.ITEMS.register("stripped_infested_drift_wood", () -> new ProxyBlockItem(KonchuBlocks.STRIPPED_INFESTED_DRIFT_WOOD.get(),	ItemGroup.TAB_BUILDING_BLOCKS)),
    INFESTED_DRIFT_LOG_ITEM 			= KonchuRegistry.ITEMS.register("infested_drift_log",			() -> new ProxyBlockItem(KonchuBlocks.INFESTED_DRIFT_LOG.get(), 			ItemGroup.TAB_BUILDING_BLOCKS)),
    INFESTED_DRIFT_WOOD_ITEM 			= KonchuRegistry.ITEMS.register("infested_drift_wood", 			() -> new ProxyBlockItem(KonchuBlocks.INFESTED_DRIFT_WOOD.get(), 			ItemGroup.TAB_BUILDING_BLOCKS)),   
    STRIPPED_DRIFT_LOG_ITEM 			= KonchuRegistry.ITEMS.register("stripped_drift_log", 			() -> new ProxyBlockItem(KonchuBlocks.STRIPPED_DRIFT_LOG.get(), 			ItemGroup.TAB_BUILDING_BLOCKS)),
    STRIPPED_DRIFT_WOOD_ITEM 			= KonchuRegistry.ITEMS.register("stripped_drift_wood", 			() -> new ProxyBlockItem(KonchuBlocks.STRIPPED_DRIFT_WOOD.get(), 			ItemGroup.TAB_BUILDING_BLOCKS)),
    DRIFT_LOG_ITEM 						= KonchuRegistry.ITEMS.register("drift_log", 					() -> new ProxyBlockItem(KonchuBlocks.DRIFT_LOG.get(), 						ItemGroup.TAB_BUILDING_BLOCKS)),
    DRIFT_WOOD_ITEM 					= KonchuRegistry.ITEMS.register("drift_wood", 					() -> new ProxyBlockItem(KonchuBlocks.DRIFT_WOOD.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    DRIFT_PLANKS_ITEM 					= KonchuRegistry.ITEMS.register("drift_planks", 				() -> new ProxyBlockItem(KonchuBlocks.DRIFT_PLANKS.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    DRIFT_STAIRS_ITEM 					= KonchuRegistry.ITEMS.register("drift_stairs", 				() -> new ProxyBlockItem(KonchuBlocks.DRIFT_STAIRS.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    DRIFT_SLAB_ITEM 					= KonchuRegistry.ITEMS.register("drift_slab", 					() -> new ProxyBlockItem(KonchuBlocks.DRIFT_SLAB.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    DRIFT_DOOR_ITEM						= KonchuRegistry.ITEMS.register("drift_door", 					() -> new ProxyBlockItem(KonchuBlocks.DRIFT_DOOR.get(), 					ItemGroup.TAB_REDSTONE)),
    DRIFT_TRAPDOOR 						= KonchuRegistry.ITEMS.register("drift_trapdoor", 				() -> new ProxyBlockItem(KonchuBlocks.DRIFT_TRAPDOOR.get(), 				ItemGroup.TAB_REDSTONE)),
    DRIFT_FENCE_ITEM 					= KonchuRegistry.ITEMS.register("drift_fence", 					() -> new ProxyBlockItem(KonchuBlocks.DRIFT_FENCE.get(), 					ItemGroup.TAB_DECORATIONS)),
    DRIFT_FENCE_GATE_ITEM 				= KonchuRegistry.ITEMS.register("drift_fence_gate", 			() -> new ProxyBlockItem(KonchuBlocks.DRIFT_FENCE_GATE.get(), 				ItemGroup.TAB_REDSTONE)),
    DRIFT_BUTTON_ITEM 					= KonchuRegistry.ITEMS.register("drift_button", 				() -> new ProxyBlockItem(KonchuBlocks.DRIFT_BUTTON.get(), 					ItemGroup.TAB_REDSTONE)),
    DRIFT_PRESSURE_PLATE_ITEM 			= KonchuRegistry.ITEMS.register("drift_pressure_plate",			() -> new ProxyBlockItem(KonchuBlocks.DRIFT_PRESSURE_PLATE.get(),			ItemGroup.TAB_REDSTONE)),
    DRIFT_SIGN_ITEM 					= KonchuRegistry.ITEMS.register("drift_sign", 					() -> new ProxyBlockItem(KonchuBlocks.DRIFT_SIGN.get(), 					ItemGroup.TAB_DECORATIONS)),
    STRIPPED_CHERRY_LOG_ITEM 			= KonchuRegistry.ITEMS.register("stripped_cherry_log", 			() -> new ProxyBlockItem(KonchuBlocks.STRIPPED_CHERRY_LOG.get(), 			ItemGroup.TAB_BUILDING_BLOCKS)),
    STRIPPED_CHERRY_WOOD_ITEM 			= KonchuRegistry.ITEMS.register("stripped_cherry_wood", 		() -> new ProxyBlockItem(KonchuBlocks.STRIPPED_CHERRY_WOOD.get(),			ItemGroup.TAB_BUILDING_BLOCKS)),
    CHERRY_LOG_ITEM 					= KonchuRegistry.ITEMS.register("cherry_log", 					() -> new ProxyBlockItem(KonchuBlocks.CHERRY_LOG.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    CHERRY_WOOD_ITEM 					= KonchuRegistry.ITEMS.register("cherry_wood", 					() -> new ProxyBlockItem(KonchuBlocks.CHERRY_WOOD.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    CHERRY_PLANKS_ITEM 					= KonchuRegistry.ITEMS.register("cherry_planks", 				() -> new ProxyBlockItem(KonchuBlocks.CHERRY_PLANKS.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    CHERRY_STAIRS_ITEM 					= KonchuRegistry.ITEMS.register("cherry_stairs", 				() -> new ProxyBlockItem(KonchuBlocks.CHERRY_STAIRS.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    CHERRY_SLAB_ITEM 					= KonchuRegistry.ITEMS.register("cherry_slab", 					() -> new ProxyBlockItem(KonchuBlocks.CHERRY_SLAB.get(), 					ItemGroup.TAB_BUILDING_BLOCKS)),
    CHERRY_DOOR_ITEM					= KonchuRegistry.ITEMS.register("cherry_door", 					() -> new ProxyBlockItem(KonchuBlocks.CHERRY_DOOR.get(), 					ItemGroup.TAB_REDSTONE)),
    CHERRY_TRAPDOOR 					= KonchuRegistry.ITEMS.register("cherry_trapdoor", 				() -> new ProxyBlockItem(KonchuBlocks.CHERRY_TRAPDOOR.get(), 				ItemGroup.TAB_REDSTONE)),
    CHERRY_FENCE_ITEM 					= KonchuRegistry.ITEMS.register("cherry_fence", 				() -> new ProxyBlockItem(KonchuBlocks.CHERRY_FENCE.get(), 					ItemGroup.TAB_DECORATIONS)),
    CHERRY_FENCE_GATE_ITEM 				= KonchuRegistry.ITEMS.register("cherry_fence_gate", 			() -> new ProxyBlockItem(KonchuBlocks.CHERRY_FENCE_GATE.get(), 				ItemGroup.TAB_REDSTONE)),
    CHERRY_BUTTON_ITEM 					= KonchuRegistry.ITEMS.register("cherry_button", 				() -> new ProxyBlockItem(KonchuBlocks.CHERRY_BUTTON.get(), 					ItemGroup.TAB_REDSTONE)),
    CHERRY_PRESSURE_PLATE_ITEM 			= KonchuRegistry.ITEMS.register("cherry_pressure_plate",		() -> new ProxyBlockItem(KonchuBlocks.CHERRY_PRESSURE_PLATE.get(), 			ItemGroup.TAB_REDSTONE)),
    WHITE_CHERRY_LEAVES 				= KonchuRegistry.ITEMS.register("white_cherry_leaves",			() -> new ProxyBlockItem(KonchuBlocks.WHITE_CHERRY_LEAVES.get(), 			ItemGroup.TAB_DECORATIONS)),
    PINK_CHERRY_LEAVES 					= KonchuRegistry.ITEMS.register("pink_cherry_leaves",			() -> new ProxyBlockItem(KonchuBlocks.PINK_CHERRY_LEAVES.get(), 			ItemGroup.TAB_DECORATIONS)),
    MAGENTA_CHERRY_LEAVES 				= KonchuRegistry.ITEMS.register("magenta_cherry_leaves",		() -> new ProxyBlockItem(KonchuBlocks.MAGENTA_CHERRY_LEAVES.get(), 			ItemGroup.TAB_DECORATIONS)),
    MARIMO_ITEM 						= KonchuRegistry.ITEMS.register("marimo", 						() -> new ProxyBlockItem(KonchuBlocks.MARIMO.get(), 						ItemGroup.TAB_DECORATIONS)),
    CRAB_BLOCK_ITEM 					= KonchuRegistry.ITEMS.register("crab_block", 					() -> new ProxyBlockItem(KonchuBlocks.CRAB_BLOCK.get(), 					ItemGroup.TAB_DECORATIONS));
}
