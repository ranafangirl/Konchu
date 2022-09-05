package com.ranafangirl.konchu.init;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class KonchuTileEntityType<T extends TileEntity> extends net.minecraftforge.registries.ForgeRegistryEntry<TileEntityType<?>> {
	public static final RegistryObject<TileEntityType<SignTileEntity>> SIGN = KonchuRegistry.TILE_ENTITIES.register("sign", () -> TileEntityType.Builder.of(SignTileEntity::new, KonchuBlocks.DRIFT_SIGN.get()).build(null));
}
