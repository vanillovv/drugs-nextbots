package ru.vanilla.nextbots.utilities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import ru.vanilla.nextbots.NextBots;

@Environment(EnvType.CLIENT)
public final class ClientConstants {
    public static EntityModelLayer NEXTBOT_LAYER = new EntityModelLayer(NextBots.id("nextbot"), "main");
}