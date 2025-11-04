package ru.vanilla.nextbots.nextbot;

import com.mojang.blaze3d.systems.RenderSystem;
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
import ru.vanilla.nextbots.client.NextBotsClient;
import ru.vanilla.nextbots.utilities.RenderUtility;
import ru.vanilla.nextbots.utilities.Wrapper;

public class NextbotEntityRenderer extends LivingEntityRenderer<NextbotEntity, NextbotEntityRenderState, NextbotEntityModel> implements Wrapper {

    public NextbotEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new NextbotEntityModel(ctx.getPart(NextBotsClient.NEXTBOT_LAYER)), 1f);
    }

    @Override
    public void updateRenderState(NextbotEntity livingEntity, NextbotEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
    }

    @Override
    public void render(NextbotEntityRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        RenderSystem.enableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();
        RenderSystem.setShaderTexture(0, NextBotsClient.id("nextbot.png"));
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
    protected Text getDisplayName(NextbotEntity entity) {
        return null;
    }

    @Override
    public Identifier getTexture(NextbotEntityRenderState state) {
        return NextBotsClient.id("empty.png");
    }

    @Override
    public NextbotEntityRenderState createRenderState() {
        return new NextbotEntityRenderState();
    }
}