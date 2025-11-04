package ru.vanilla.nextbots;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import ru.vanilla.nextbots.nextbot.NextBotEntity;

public class NextBots implements ModInitializer {

    public static EntityType<NextBotEntity> NEXTBOT_TYPE = Registry.register(
            Registries.ENTITY_TYPE, id("nextbot"),
            EntityType.Builder.create(NextBotEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1f, 1f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, id("nextbot")))
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(NEXTBOT_TYPE, NextBotEntity.createLivingAttributes());
    }

    public static Identifier id(String id) {
        return Identifier.of("nextbots", id);
    }
}