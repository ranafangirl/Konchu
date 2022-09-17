package com.ranafangirl.konchu.client.render.model;

import com.ranafangirl.konchu.Konchu;
import com.ranafangirl.konchu.entity.Snail;

import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnailModel extends AnimatedGeoModel<Snail> {
	protected static final ResourceLocation GREEN_SNAIL_LOCATION	= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/green_snail.png");
	protected static final ResourceLocation ORANGE_SNAIL_LOCATION	= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/orange_snail.png");
	protected static final ResourceLocation BROWN_SNAIL_LOCATION	= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/brown_snail.png");
	protected static final ResourceLocation GRAY_SNAIL_LOCATION		= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/gray_snail.png");
	protected static final ResourceLocation PINK_SNAIL_LOCATION		= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/pink_snail.png");
	protected static final ResourceLocation BLACK_SNAIL_LOCATION	= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/black_snail.png");	
	protected static final ResourceLocation GOLDEN_SNAIL_LOCATION	= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/golden_snail.png");		
	protected static final ResourceLocation GARY_SNAIL_LOCATION		= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/gary.png");
	protected static final ResourceLocation SHELDON_SNAIL_LOCATION	= new ResourceLocation(Konchu.MOD_ID, "textures/entity/snail/sheldon.png");

	@Override
	public ResourceLocation getTextureLocation(Snail entity) {
		String name = ChatFormatting.stripFormatting(entity.getName().getString());
		switch(name) { 
		case "Gary": return GARY_SNAIL_LOCATION;
		case "Sheldon": return SHELDON_SNAIL_LOCATION;
		default:
			switch(entity.getSnailType()) {
			case 0: return GREEN_SNAIL_LOCATION;
			case 1: return ORANGE_SNAIL_LOCATION;
			case 2: return BROWN_SNAIL_LOCATION;
			case 3: return GRAY_SNAIL_LOCATION;
			case 4: return PINK_SNAIL_LOCATION;
			case 5: return BLACK_SNAIL_LOCATION;
			case 6: return GOLDEN_SNAIL_LOCATION;
			default: return GREEN_SNAIL_LOCATION;
			}
		}
	}

	@Override
	public ResourceLocation getModelLocation(Snail object) {
		return new ResourceLocation(Konchu.MOD_ID, "geo/snail.geo.json");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(Snail object) {
		return new ResourceLocation(Konchu.MOD_ID, "animations/snail.json");
	}
}
