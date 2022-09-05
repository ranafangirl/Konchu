package com.ranafangirl.konchu.init;

import com.google.common.base.Supplier;
import com.ranafangirl.konchu.Konchu;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;

public class KonchuBiomes {
	public static RegistryKey<Biome>
	CHERRY_FOREST = registerBiome("cherry_forest");

	static {
		createBiome("cherry_forest", BiomeMaker::theVoidBiome);
	}
	
	public static RegistryKey<Biome> registerBiome(String biomeName) {
		return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Konchu.MOD_ID, biomeName));
	}
	
	public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
		return KonchuRegistry.BIOMES.register(biomeName, biome);
	}
}

