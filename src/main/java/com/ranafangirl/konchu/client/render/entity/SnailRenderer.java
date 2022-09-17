package com.ranafangirl.konchu.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.ranafangirl.konchu.client.render.model.SnailModel;
import com.ranafangirl.konchu.entity.Snail;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SnailRenderer extends GeoEntityRenderer<Snail> {
	public SnailRenderer(EntityRendererProvider.Context renderManager) { 
		super(renderManager, new SnailModel());
	}

	public void render(Snail entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {		
		if (entity.isClimbing()) {
			int rotation = getRotation(entity);
			switch (rotation) {
				case 0: default: {
					stack.mulPose(Vector3f.XP.rotationDegrees(90));
					break;
				}
				case 1: {
					stack.mulPose(Vector3f.ZP.rotationDegrees(90));
					break;
				}
				case 2: {
					stack.mulPose(Vector3f.XP.rotationDegrees(-90));
					break;
				}
				case 3: {
					stack.mulPose(Vector3f.ZP.rotationDegrees(-90));
					break;			
				}
			}
			stack.translate(0, -4 / 16D, 0);
		}
		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}

	public static int getRotation(Snail entity) {
		if(entity == null || entity.level == null) return 0;
		float rotation = (entity.yBodyRot + 180);
		Level level = entity.level;
		BlockPos pos = new BlockPos(entity.position());
		if (rotation > (0 + 45) && rotation < (90 + 45) && !level.isEmptyBlock(pos.east())) return 1;		// EAST
		if (rotation > (90 + 45) && rotation < (180 + 45) && !level.isEmptyBlock(pos.south())) return 2;	// SOUTH
		if (rotation > (180 + 45) && rotation < (270 + 45) && !level.isEmptyBlock(pos.west())) return 3;	// WEST
		else if(!level.isEmptyBlock(pos.north())) return 0;
		return getRotationFromBlock(pos, level);															// NORTH
	}
	
	public static int getRotationFromBlock(BlockPos pos, Level level) {
		if(level == null) return 0;
		if(!level.isEmptyBlock(pos.north())) return 0;	// NORTH
		if(!level.isEmptyBlock(pos.east() )) return 1; 	// EAST
		if(!level.isEmptyBlock(pos.south())) return 2;	// SOUTH
		return 3;										// WEST
	}
}