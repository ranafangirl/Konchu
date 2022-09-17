package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Konchu.MOD_ID, bus = Bus.MOD)
public class KonchuFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Konchu.MOD_ID);
	public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Konchu.MOD_ID);
	
	public static final RegistryObject<Feature<TreeConfiguration>>
	WHITE_CHERRY 	= KonchuRegistry.FEATURES.register("white_cherry",		()-> new TreeFeature(TreeConfiguration.CODEC)),
	PINK_CHERRY 	= KonchuRegistry.FEATURES.register("pink_cherry", 		()-> new TreeFeature(TreeConfiguration.CODEC)),
	MAGENTA_CHERRY 	= KonchuRegistry.FEATURES.register("magenta_cherry",	()-> new TreeFeature(TreeConfiguration.CODEC));
}

