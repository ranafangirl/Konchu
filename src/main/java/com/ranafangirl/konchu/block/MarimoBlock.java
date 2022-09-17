package com.ranafangirl.konchu.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MarimoBlock extends CropBlock implements BonemealableBlock, SimpleWaterloggedBlock {
	public static final int MAX_AGE = 9;
	//public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 9);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SMALL = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D);
	protected static final VoxelShape MEDIUM = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
	protected static final VoxelShape BIG = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
	protected static final VoxelShape FULL = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	protected static final VoxelShape FULL_SINGLE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	protected static final VoxelShape FULL_DOUBLE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	protected static final VoxelShape FULL_TRIPLE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	protected static final VoxelShape FULL_QUAD = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	protected static final VoxelShape FULL_PENTA = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);

	public MarimoBlock(BlockBehaviour.Properties properties) {
		super(properties); 
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(true)));
	}	

	//public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
	//if (true) {
	//int i = state.getValue(MOSS_BALL_SIZE);
	//if (i < 8 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, pos.random.nextInt(5) == 0)) {
	//level.setBlock(pos, state.setValue(MOSS_BALL_SIZE, Integer.valueOf(i + 1)), 8);
	//net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
	//}

	//}

	//}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
		if (blockstate.is(this)) {
			return blockstate.setValue(AGE, Integer.valueOf(Math.min(9, blockstate.getValue(AGE) + 1)));
		} else {
			FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
			boolean flag = fluidstate.getType() == Fluids.WATER;
			return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(flag));
		}
	}

	@Override
	public int getMaxAge() {
		return 9;
	}

	public static boolean isDead(BlockState state) {
		return !state.getValue(WATERLOGGED);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		BlockPos blockpos = pos.below();
		return this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
	}

	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(BlockState state, BlockPlaceContext itemUseContext) {
		if (state.getValue(AGE) > 8 ) {
			return itemUseContext.getItemInHand().getItem() == this.asItem() && state.getValue(AGE) < 9 ? true : super.canBeReplaced(state, itemUseContext);
		} else {
			return (state.getValue(AGE) != 9);
		}
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
		switch(state.getValue(AGE)) {
		case 1: default: return SMALL;
		case 2: return MEDIUM;
		case 3: return BIG;
		case 4: return FULL;
		case 5: return FULL_SINGLE;
		case 6: return FULL_DOUBLE;
		case 7: return FULL_TRIPLE;
		case 8: return FULL_QUAD;
		case 9: return FULL_PENTA;
		}
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
		state.add(AGE, WATERLOGGED);
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter reader, BlockPos pos, BlockState state, boolean type) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState state) {
		return false;
	}

	@Override
	public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state) {
		level.setBlock(pos, state.setValue(AGE, Integer.valueOf(9)), 2);
	}
}
