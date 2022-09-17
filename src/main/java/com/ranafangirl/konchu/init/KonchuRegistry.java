package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("rawtypes")
public class KonchuRegistry {
	public static final DeferredRegister<Block> 				BLOCKS			= DeferredRegister.create(ForgeRegistries.BLOCKS,				Konchu.MOD_ID);
	public static final DeferredRegister<Item> 					ITEMS			= DeferredRegister.create(ForgeRegistries.ITEMS,				Konchu.MOD_ID);
	public static final DeferredRegister<SoundEvent> 			SOUNDS			= DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,			Konchu.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>>	BLOCK_ENTITIES	= DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,		Konchu.MOD_ID);
	public static final DeferredRegister<EntityType<?>> 		ENTITIES		= DeferredRegister.create(ForgeRegistries.ENTITIES, 			Konchu.MOD_ID);
	public static final DeferredRegister<Biome> 				BIOMES			= DeferredRegister.create(ForgeRegistries.BIOMES,				Konchu.MOD_ID);
    public static final DeferredRegister<Feature<?>>			FEATURES		= DeferredRegister.create(ForgeRegistries.FEATURES,				Konchu.MOD_ID);
    public static final DeferredRegister<TreeDecoratorType<?>>	TREE_DECORATORS	= DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES,	Konchu.MOD_ID);
	
    public static KonchuBlocks			Blocks;
	public static KonchuItems			Items;
	public static KonchuSoundEvents		Sounds;
	public static KonchuBlockEntityType	BlockEntityType;
	public static KonchuEntityType		Entities;
	public static KonchuBiomes			Biomes;
	public static KonchuFeatures		Features;
	public static KonchuFeatures		TreeDecorators;
	
	public static void init() {
		Blocks					= new KonchuBlocks();
		Items					= new KonchuItems();
		Sounds					= new KonchuSoundEvents();
		BlockEntityType			= new KonchuBlockEntityType();
		Entities				= new KonchuEntityType();
		Biomes					= new KonchuBiomes();
		Features				= new KonchuFeatures();
		TreeDecorators			= new KonchuFeatures();
		BLOCKS.register			(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register			(FMLJavaModLoadingContext.get().getModEventBus());
		SOUNDS.register			(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCK_ENTITIES.register	(FMLJavaModLoadingContext.get().getModEventBus());
		ENTITIES.register		(FMLJavaModLoadingContext.get().getModEventBus());
		BIOMES.register			(FMLJavaModLoadingContext.get().getModEventBus());
		FEATURES.register		(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
