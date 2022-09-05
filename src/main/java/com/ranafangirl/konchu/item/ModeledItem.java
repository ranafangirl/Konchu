package com.ranafangirl.konchu.item;

import javax.annotation.Nullable;

import net.minecraft.item.Item;

public class ModeledItem extends Item{

	public ModeledItem(Properties properties) {
		super(properties);
	}

	public RenderDimension handRendering() {
		return RenderDimension.MODEL;
	}

	public RenderDimension inventoryRendering() {
		return RenderDimension.SPRITE;
	}

	public RenderDimension hatRendering() {
		return RenderDimension.SPRITE;
	}

	public RenderDimension itemEntityRendering() {
		return RenderDimension.SPRITE;
	}

	public RenderDimension itemFrameRendering() {
		return RenderDimension.SPRITE;
	}

	public enum RenderDimension { 
		SPRITE(null),
		MODEL("model"); 
		private String string;

		RenderDimension(@Nullable String string) {
			this.string = string;
		}

		public String toString() {
			if(string != null)
				return "_" + string;
			else return "";
		}
	};
}
