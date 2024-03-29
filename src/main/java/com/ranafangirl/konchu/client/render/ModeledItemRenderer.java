package com.ranafangirl.konchu.client.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ranafangirl.konchu.item.ModeledItem;

import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.ForgeModelBakery;

public class ModeledItemRenderer {
	private static List<ItemRenderInfo> renders = new ArrayList<>();

	public static void addItemRender(Item item) {
		if(item instanceof ModeledItem) {
			ItemRenderInfo renderInfo = new ItemRenderInfo((ModeledItem) item);
			renders.add(renderInfo);
		} else {
			new StackOverflowError(item.getRegistryName() + " is not a child of ModeledItem");
		}
	}

	public static List<ItemRenderInfo> getRenders() {
		return renders;
	}

	public static class ItemRenderInfo {
		private Map<TransformType, OtherModel> perspectives = new HashMap<>();
		private ResourceLocation baseLocation;
		private Item item;

		public ItemRenderInfo(ModeledItem modeledItem) {
			this.item = (Item) modeledItem;
			this.baseLocation = new ModelResourceLocation(modeledItem.getRegistryName(), "inventory");
			addTransformModel(modeledItem.handRendering()		.toString(), TransformType.FIRST_PERSON_LEFT_HAND);
			addTransformModel(modeledItem.handRendering()		.toString(), TransformType.FIRST_PERSON_RIGHT_HAND);
			addTransformModel(modeledItem.handRendering()		.toString(), TransformType.THIRD_PERSON_LEFT_HAND);
			addTransformModel(modeledItem.handRendering()		.toString(), TransformType.THIRD_PERSON_RIGHT_HAND);
			addTransformModel(modeledItem.inventoryRendering()	.toString(), TransformType.GUI);
			addTransformModel(modeledItem.itemFrameRendering()	.toString(), TransformType.FIXED);
			addTransformModel(modeledItem.itemEntityRendering()	.toString(), TransformType.GROUND);
			addTransformModel(modeledItem.hatRendering()		.toString(), TransformType.HEAD);
		}

		private void addTransformModel(String extention, TransformType type) {
			String location = item.getRegistryName() + extention;
			ForgeModelBakery.addSpecialModel(new ModelResourceLocation(location, "inventory"));
			perspectives.put(type, new OtherModel(this, location, type));
		}

		public Map<TransformType, OtherModel> getTransforms() {
			return perspectives;
		}

		public Item getItem() {
			return item;
		}

		public ResourceLocation getBaseLocation() {
			return baseLocation;
		}

		public static class OtherModel {
			private ResourceLocation location;
			private SimpleBakedModel model;

			public OtherModel(ItemRenderInfo renderInfo, String location, TransformType type) {
				this.location = new ModelResourceLocation(location, "inventory");
			}

			public ResourceLocation getLocation() {
				return location;
			}

			public void setModel(SimpleBakedModel model) {
				this.model = model;
			}

			public SimpleBakedModel getModel() {
				return model;
			}
		}
	}
}
