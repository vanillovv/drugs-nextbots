package ru.vanilla.nextbots.nextbot;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.util.Collections;

public class NextBotEntity extends LivingEntity {

    public NextBotEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        if (getWorld().isClient) {

        } else {
            ServerWorld world = (ServerWorld) getWorld();
            for (ServerPlayerEntity entity : world.getPlayers()) {
                if (distanceTo(entity) > 3) continue;
                if (entity.isDisconnected() || entity.isCreative() || entity.isDead()) continue;
                if (entity.getBoundingBox().intersects(getBoundingBox())) entity.onKilledOther(world, this);
            }
        }

        super.tick();
    }

    @Override
    public boolean canHit() {
        return false;
    }

    @Override
    protected void pushOutOfBlocks(double x, double y, double z) {
    }

    @Override
    public void pushAwayFrom(Entity entity) {
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    protected void pushAway(Entity entity) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return Collections.emptyList();
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
    }

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }
}