package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;
import com.ranafangirl.konchu.client.render.entity.SnailRenderer;
import com.ranafangirl.konchu.entity.Snail;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Konchu.MOD_ID, bus = Bus.MOD)
public class KonchuEntityType {	
	public static final RegistryObject<EntityType<Snail>>	SNAIL		= KonchuRegistry.ENTITIES.register("snail", 		() -> EntityType.Builder.<Snail>of(Snail::new,	MobCategory.CREATURE)	.sized(0.562F,  0.562F).build(new ResourceLocation(Konchu.MOD_ID, "snail"		).toString()));
	public static final RegistryObject<EntityType<Boat>>	DRIFT_BOAT	= KonchuRegistry.ENTITIES.register("drift_boat",	() -> EntityType.Builder.<Boat>of(Boat::new,	MobCategory.MISC)		.sized(1.375F, 0.5625F).build(new ResourceLocation(Konchu.MOD_ID, "drift_boat"	).toString()));

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent	
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(KonchuEntityType.SNAIL.get(), SnailRenderer::new);
	}

	@SubscribeEvent	
	public static void registerSpawnPlacement(FMLCommonSetupEvent event) {
		SpawnPlacements.register(KonchuEntityType.SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Snail::canSpawn);
	}

	@SubscribeEvent	
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(KonchuEntityType.SNAIL.get(), Snail.createAttributes().build());
	}
}
