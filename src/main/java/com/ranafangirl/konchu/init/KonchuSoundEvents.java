package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class KonchuSoundEvents {	
	public static final RegistryObject<SoundEvent>
	MUSIC_DISC_HELIX	= buildSound(KonchuRegistry.SOUNDS, "music_disc.helix"),
	MUSIC_DISC_SUBURBAN	= buildSound(KonchuRegistry.SOUNDS, "music_disc.suburban");

	public static RegistryObject<SoundEvent> buildSound(DeferredRegister<SoundEvent> register, String registryName) {	
		RegistryObject<SoundEvent> SOUND = register.register(registryName,() -> new SoundEvent(new ResourceLocation(Konchu.MOD_ID,registryName)));
		return SOUND;
	}
}
