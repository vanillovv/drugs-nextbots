package ru.vanilla.nextbots.nextbot;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import ru.vanilla.nextbots.NextBots;
import ru.vanilla.nextbots.utilities.ClientConstants;
import ru.vanilla.nextbots.utilities.RenderUtility;
import ru.vanilla.nextbots.utilities.traits.Wrapper;

@Environment(EnvType.CLIENT)
public class NextBotEntityRenderer extends LivingEntityRenderer<NextBotEntity, NextBotEntityRenderState, NextBotEntityModel> implements Wrapper {

    public NextBotEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new NextBotEntityModel(ctx.getPart(ClientConstants.NEXTBOT_LAYER)), 1f);
    }

    @Override
    public void updateRenderState(NextBotEntity livingEntity, NextBotEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
    }

    @Override
    public void render(NextBotEntityRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        RenderSystem.enableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();
        RenderSystem.setShaderTexture(0, NextBots.id("nextbot.png"));
        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
        BufferBuilder builder = RenderUtility.builder(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

        float size = 3f;
        Vec3d pos = new Vec3d(livingEntityRenderState.x, livingEntityRenderState.y + 3f, livingEntityRenderState.z).subtract(mc.gameRenderer.getCamera().getPos());

        matrixStack.push();
        matrixStack.translate(pos.getX(), pos.getY(), pos.getZ());
        matrixStack.multiply(dispatcher.getRotation());
        builder.vertex(matrixStack.peek().getPositionMatrix(), -size, -size, 0).texture(0f, 1f).color(-1);
        builder.vertex(matrixStack.peek().getPositionMatrix(), -size, size, 0).texture(0f, 0f).color(-1);
        builder.vertex(matrixStack.peek().getPositionMatrix(), size, size, 0).texture(1f, 0f).color(-1);
        builder.vertex(matrixStack.peek().getPositionMatrix(), size, -size, 0).texture(1f, 1f).color(-1);
        matrixStack.pop();

        RenderUtility.endBuild(builder);
        RenderSystem.enableCull();
        RenderSystem.depthMask(false);
        RenderSystem.disableBlend();

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    protected Text getDisplayName(NextBotEntity entity) {
        return null;
    }

    @Override
    public Identifier getTexture(NextBotEntityRenderState state) {
        return NextBots.id("empty.png");
    }

    @Override
    public NextBotEntityRenderState createRenderState() {
        return new NextBotEntityRenderState();
    }
}