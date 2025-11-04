package ru.vanilla.nextbots.utilities.traits;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public interface Wrapper {
    MinecraftClient mc = MinecraftClient.getInstance();
}