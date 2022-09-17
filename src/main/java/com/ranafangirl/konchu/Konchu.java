package com.ranafangirl.konchu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.eventbus.Subscribe;
import com.ranafangirl.konchu.init.KonchuBlockEntityType;
import com.ranafangirl.konchu.init.KonchuRegistry;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("konchu")
public class Konchu {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "konchu";

	public Konchu() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		KonchuRegistry.init();
		bus.addListener(this::registerClient);
	}

	private void registerClient(FMLClientSetupEvent event) {
	}
	
	@Subscribe
	public static void registerRenderers() {
		BlockEntityRenderers.register(KonchuBlockEntityType.SIGN.get(), SignRenderer::new);
	}

	/*
	public static void modelBakeEvent(ModelBakeEvent event) {
		Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
		for (ItemRenderInfo renderInfo : ModeledItemRenderer.getRenders()) {
			IBakedModel baseModel = modelRegistry.get(renderInfo.getBaseLocation());
			for (OtherModel otherModel : renderInfo.getTransforms().values()) {
				otherModel.setModel(modelRegistry.get(otherModel.getLocation()));
				modelRegistry.put(otherModel.getLocation(), otherModel.getModel());
			}

			IBakedModel bakedModel = new IForgeBakedModel() {
				@Override
				public IBakedModel handlePerspective(ItemTransforms.TransformType transformType, Matrix3f mat) {
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
	*/
}