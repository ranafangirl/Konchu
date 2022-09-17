package com.ranafangirl.konchu.init;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.registries.RegistryObject;
	
public class KonchuBlockEntityType<T extends BlockEntity> extends net.minecraftforge.registries.ForgeRegistryEntry<BlockEntityType<?>> {
	public static final RegistryObject<BlockEntityType<SignBlockEntity>> SIGN = KonchuRegistry.BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SignBlockEntity::new, KonchuBlocks.DRIFT_SIGN.get()).build(null));
}
