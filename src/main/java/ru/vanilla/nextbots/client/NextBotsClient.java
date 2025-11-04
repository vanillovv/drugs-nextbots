package ru.vanilla.nextbots.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import ru.vanilla.nextbots.NextBots;
import ru.vanilla.nextbots.nextbot.NextBotEntityModel;
import ru.vanilla.nextbots.nextbot.NextBotEntityRenderer;
import ru.vanilla.nextbots.utilities.ClientConstants;

public class NextBotsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ClientConstants.NEXTBOT_LAYER, NextBotEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(NextBots.NEXTBOT_TYPE, NextBotEntityRenderer::new);
    }
}