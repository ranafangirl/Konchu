package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Konchu.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KonchuSpawning {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerBiomes(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.FOREST) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(KonchuEntityType.SNAIL.get(), 15, 1, 2));
        }
    }
}