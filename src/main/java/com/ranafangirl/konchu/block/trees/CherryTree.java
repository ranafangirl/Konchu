package com.ranafangirl.konchu.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.ranafangirl.konchu.init.KonchuFeatures;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.registries.RegistryObject;

public class CherryTree {
	@Nullable
	protected RegistryObject<Feature<TreeConfiguration>> getConfiguredFeature(Random rand, boolean b) {
		if (rand.nextInt(7) == 0) {
			return b ? KonchuFeatures.PINK_CHERRY : KonchuFeatures.MAGENTA_CHERRY;
		} else {
			return KonchuFeatures.WHITE_CHERRY;
		}
	}
}
