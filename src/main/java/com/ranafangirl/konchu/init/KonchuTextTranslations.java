package com.ranafangirl.konchu.init;

import net.minecraft.network.chat.TranslatableComponent;

public class KonchuTextTranslations {
    public static TranslatableComponent NET_MISSED		= register("item.konchu.net.missed");
    public static TranslatableComponent NET_FULL 		= register("item.konchu.net.is_full");
    public static TranslatableComponent NET_DISALLOW	= register("item.konchu.net.cannot_catch");

    private static TranslatableComponent register(final String translation) {
        return new TranslatableComponent(translation);
    }
}