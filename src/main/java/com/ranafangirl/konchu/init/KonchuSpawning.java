package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Konchu.MOD_ID, bus = Bus.FORGE)
public class KonchuSpawning {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void biomeLoading(BiomeLoadingEvent event) {
		if (event.getName().equals(new ResourceLocation("minecraft:forest"))) {
			event.getSpawns().addSpawn(MobCategory.CREATURE,
					new SpawnerData(KonchuEntityType.SNAIL.get(), 5, 1, 7));
		}
	}
}