package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;
import com.ranafangirl.konchu.client.render.entity.SnailRenderer;
import com.ranafangirl.konchu.entity.SnailEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Konchu.MOD_ID, bus = Bus.MOD)
public class KonchuEntityType {	
	public static final RegistryObject<EntityType<SnailEntity>> SNAIL		= KonchuRegistry.ENTITIES.register("snail", 		() -> EntityType.Builder.<SnailEntity>of(SnailEntity::new, EntityClassification.CREATURE)	.sized(0.562F,  0.562F).build(new ResourceLocation(Konchu.MOD_ID, "snail"		).toString()));
	public static final RegistryObject<EntityType<BoatEntity>> 	DRIFT_BOAT	= KonchuRegistry.ENTITIES.register("drift_boat",	() -> EntityType.Builder.<BoatEntity>of	(BoatEntity	::new, EntityClassification.MISC)		.sized(1.375F, 0.5625F).build(new ResourceLocation(Konchu.MOD_ID, "drift_boat"	).toString()));

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent	
	public static void registerClient(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(KonchuEntityType.SNAIL.get(), SnailRenderer::new);
	}

	@SubscribeEvent	
	public static void registerSpawnPlacement(FMLCommonSetupEvent event) {
		EntitySpawnPlacementRegistry.register(KonchuEntityType.SNAIL.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
	}

	@SubscribeEvent	
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(KonchuEntityType.SNAIL.get(), SnailEntity.setCustomAttributes().build());
	}
}
