package com.ranafangirl.konchu.util;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class KonchuItemUtils {
    public static List<Component> addText(List<Component> tooltip, String text, ChatFormatting color) {
        tooltip.add(new TextComponent(color + text));
        return tooltip;
    }
}


