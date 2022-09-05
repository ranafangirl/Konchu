package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;
import com.ranafangirl.konchu.entity.SnailEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class KonchuEntityType {	
	public static final RegistryObject<EntityType<SnailEntity>> SNAIL		= KonchuRegistry.ENTITIES.register("snail", 		() -> EntityType.Builder.<SnailEntity>of(SnailEntity::new, EntityClassification.CREATURE)	.sized(0.562F,  0.562F).build(new ResourceLocation(Konchu.MOD_ID, "snail"		).toString()));
	public static final RegistryObject<EntityType<BoatEntity>> 	DRIFT_BOAT	= KonchuRegistry.ENTITIES.register("drift_boat",	() -> EntityType.Builder.<BoatEntity>of	(BoatEntity	::new, EntityClassification.MISC)		.sized(1.375F, 0.5625F).build(new ResourceLocation(Konchu.MOD_ID, "drift_boat"	).toString()));
}
