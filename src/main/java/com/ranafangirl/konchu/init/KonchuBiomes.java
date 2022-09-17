package com.ranafangirl.konchu.init;

import com.google.common.base.Supplier;
import com.ranafangirl.konchu.Konchu;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = Konchu.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class KonchuBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Konchu.MOD_ID);

    static {
        createBiome("cherry_forest", OverworldBiomes::theVoid);
    }

    public static ResourceKey<Biome> CHERRY_FOREST = registerBiome("cherry_forest");

    public static ResourceKey<Biome> registerBiome(String biomeName) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Konchu.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }

	public static void registerBiomes() {    	
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(CHERRY_FOREST, 2));
		BiomeDictionary.addTypes(CHERRY_FOREST, Type.FOREST, Type.OVERWORLD);	
    }
}
