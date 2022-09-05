package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("rawtypes")
public class KonchuRegistry {
	public static final DeferredRegister<Block> 			BLOCKS			= DeferredRegister.create(ForgeRegistries.BLOCKS,			Konchu.MOD_ID);
	public static final DeferredRegister<Item> 				ITEMS			= DeferredRegister.create(ForgeRegistries.ITEMS,			Konchu.MOD_ID);
	public static final DeferredRegister<SoundEvent> 		SOUNDS			= DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,		Konchu.MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES	= DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,	Konchu.MOD_ID);
	public static final DeferredRegister<EntityType<?>> 	ENTITIES		= DeferredRegister.create(ForgeRegistries.ENTITIES, 		Konchu.MOD_ID);
	public static final DeferredRegister<Biome> 			BIOMES			= DeferredRegister.create(ForgeRegistries.BIOMES,			Konchu.MOD_ID);
    public static final DeferredRegister<Feature<?>>		FEATURES		= DeferredRegister.create(ForgeRegistries.FEATURES,			Konchu.MOD_ID);
	public static KonchuBlocks			Blocks;
	public static KonchuItems			Items;
	public static KonchuSoundEvents		Sounds;
	public static KonchuTileEntityType	TileEntityType;
	public static KonchuEntityType		Entities;
	public static KonchuBiomes			Biomes;
	public static KonchuFeatures		Features;
	
	public static void init() {
		Blocks					= new KonchuBlocks();
		Items					= new KonchuItems();
		Sounds					= new KonchuSoundEvents();
		TileEntityType			= new KonchuTileEntityType();
		Entities				= new KonchuEntityType();
		Biomes					= new KonchuBiomes();
		Features				= new KonchuFeatures();
		BLOCKS.register			(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register			(FMLJavaModLoadingContext.get().getModEventBus());
		SOUNDS.register			(FMLJavaModLoadingContext.get().getModEventBus());
		TILE_ENTITIES.register	(FMLJavaModLoadingContext.get().getModEventBus());
		ENTITIES.register		(FMLJavaModLoadingContext.get().getModEventBus());
		BIOMES.register			(FMLJavaModLoadingContext.get().getModEventBus());
		FEATURES.register		(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
