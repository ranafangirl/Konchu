package com.ranafangirl.konchu.init;

import com.ranafangirl.konchu.Konchu;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class KonchuSoundEvents {	
	public static final RegistryObject<SoundEvent>
	MUSIC_DISC_HELIX	= buildSound(KonchuRegistry.SOUNDS, "music_disc.helix"),
	MUSIC_DISC_SUBURBAN	= buildSound(KonchuRegistry.SOUNDS, "music_disc.suburban");

	public static RegistryObject<SoundEvent> buildSound(DeferredRegister<SoundEvent> register, String registryName) {	
		RegistryObject<SoundEvent> SOUND = register.register(registryName,() -> new SoundEvent(new ResourceLocation(Konchu.MOD_ID,registryName)));
		return SOUND;
	}
}
