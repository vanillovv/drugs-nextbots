package ru.vanilla.nextbots.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import ru.vanilla.nextbots.nextbot.NextbotEntity;
import ru.vanilla.nextbots.nextbot.NextbotEntityModel;
import ru.vanilla.nextbots.nextbot.NextbotEntityRenderer;

public class NextBotsClient implements ClientModInitializer {

    public final EntityType<NextbotEntity> NEXTBOT_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            id("nextbot"),
            EntityType.Builder.create(NextbotEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1f, 1f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, id("nextbot")))
    );
    public static final EntityModelLayer NEXTBOT_LAYER = new EntityModelLayer(id("nextbot"), "main");

    @Override
    public void onInitializeClient() {
        FabricDefaultAttributeRegistry.register(NEXTBOT_TYPE, NextbotEntity.createLivingAttributes());
        EntityModelLayerRegistry.registerModelLayer(NEXTBOT_LAYER, NextbotEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(NEXTBOT_TYPE, NextbotEntityRenderer::new);
    }

    public static Identifier id(String id) {
        return Identifier.of("nextbots", id);
    }
}