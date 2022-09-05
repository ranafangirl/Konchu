package com.ranafangirl.konchu.init;

import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraftforge.fml.RegistryObject;

public class KonchuFeatures {
	public static final RegistryObject<Feature<BaseTreeFeatureConfig>>
	WHITE_CHERRY 	= KonchuRegistry.FEATURES.register("white_cherry",		()-> new TreeFeature(BaseTreeFeatureConfig.CODEC)),
	PINK_CHERRY 	= KonchuRegistry.FEATURES.register("pink_cherry", 		()-> new TreeFeature(BaseTreeFeatureConfig.CODEC)),
	MAGENTA_CHERRY 	= KonchuRegistry.FEATURES.register("magenta_cherry",	()-> new TreeFeature(BaseTreeFeatureConfig.CODEC));
}
    
