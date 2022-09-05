package com.ranafangirl.konchu;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.ranafangirl.konchu.client.render.ModeledItemRenderer;
import com.ranafangirl.konchu.client.render.ModeledItemRenderer.ItemRenderInfo;
import com.ranafangirl.konchu.client.render.ModeledItemRenderer.ItemRenderInfo.OtherModel;
import com.ranafangirl.konchu.client.render.entity.SnailRenderer;
import com.ranafangirl.konchu.entity.SnailEntity;
import com.ranafangirl.konchu.init.KonchuBiomes;
import com.ranafangirl.konchu.init.KonchuBlocks;
import com.ranafangirl.konchu.init.KonchuEntityType;
import com.ranafangirl.konchu.init.KonchuRegistry;
import com.ranafangirl.konchu.init.KonchuTileEntityType;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("deprecation")
@Mod("konchu")
public class Konchu {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "konchu";

	public Konchu() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		KonchuRegistry.init();
		MinecraftForge.EVENT_BUS.register(this);
		bus.addListener(this::registerRendering);
		bus.addListener(this::registerEntityAttributes);
		Konchu.registerBiomes();
	}

	private void registerRendering(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(KonchuEntityType.SNAIL				.get(), SnailRenderer::new);
		RenderTypeLookup.setRenderLayer					(KonchuBlocks.LICHEN_GROWTH			.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer					(KonchuBlocks.CHERRY_DOOR			.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer					(KonchuBlocks.CHERRY_TRAPDOOR		.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer					(KonchuBlocks.WHITE_CHERRY_LEAVES	.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer					(KonchuBlocks.PINK_CHERRY_LEAVES	.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer					(KonchuBlocks.MAGENTA_CHERRY_LEAVES	.get(), RenderType.translucent());
	}

	public static void registerTileEntityRendering() {
	    ClientRegistry.bindTileEntityRenderer(KonchuTileEntityType.SIGN.get(), SignTileEntityRenderer::new);
	}

	public void registerEntityAttributes(final EntityAttributeCreationEvent event) {
		GlobalEntityTypeAttributes.put(KonchuEntityType.SNAIL.get(), SnailEntity.setCustomAttributes().build());
	}
	
	public static void registerBiomes() {
    	BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(KonchuBiomes.CHERRY_FOREST, 1));
		BiomeDictionary.addTypes(KonchuBiomes.CHERRY_FOREST, Type.FOREST, Type.OVERWORLD);	
	}
	
	public static void modelBakeEvent(ModelBakeEvent event) {
		Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
		for (ItemRenderInfo renderInfo : ModeledItemRenderer.getRenders()) {
			IBakedModel baseModel = modelRegistry.get(renderInfo.getBaseLocation());
			for (OtherModel otherModel : renderInfo.getTransforms().values()) {
				otherModel.setModel(modelRegistry.get(otherModel.getLocation()));
				modelRegistry.put(otherModel.getLocation(), otherModel.getModel());
			}

			IBakedModel bakedModel = new IBakedModel() {
				@Override
				public IBakedModel handlePerspective(ItemCameraTransforms.TransformType transformType, MatrixStack mat) {
					IBakedModel model = renderInfo.getTransforms().get(transformType).getModel();
					if(model == null) model = baseModel;
					return ForgeHooksClient.handlePerspective(model, transformType, mat);
				}

				@Override
				public List<BakedQuad> getQuads(BlockState state, Direction side, Random rand) {
					return baseModel.getQuads(state, side, rand);
				}

				@Override
				public boolean useAmbientOcclusion() {
					return baseModel.useAmbientOcclusion();
				}

				@Override
				public boolean isGui3d() {
					return baseModel.isGui3d();
				}
				@Override
				public boolean isCustomRenderer() {
					return baseModel.isCustomRenderer();
				}

				@Override
				public TextureAtlasSprite getParticleIcon() {
					return baseModel.getParticleIcon();
				}

				@Override
				public ItemOverrideList getOverrides() {
					return baseModel.getOverrides();
				}

				@Override
				public boolean usesBlockLight() {
					return false;
				}
			};
			modelRegistry.put(renderInfo.getBaseLocation(), bakedModel);
		}
	}
}