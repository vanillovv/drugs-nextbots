package ru.vanilla.nextbots.utilities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;

@Environment(EnvType.CLIENT)
public final class RenderUtility {

    public static BufferBuilder builder(VertexFormat.DrawMode mode, VertexFormat format) {
        return Tessellator.getInstance().begin(mode, format);
    }

    public static void endBuild(BufferBuilder builder) {
        BuiltBuffer buffer = builder.endNullable();
        if (buffer != null) BufferRenderer.drawWithGlobalProgram(buffer);
    }
}