package ru.vanilla.nextbots.utilities;

import net.minecraft.client.render.*;

public final class RenderUtility {

    public static BufferBuilder builder(VertexFormat.DrawMode mode, VertexFormat format) {
        return Tessellator.getInstance().begin(mode, format);
    }

    public static void endBuild(BufferBuilder builder) {
        BuiltBuffer buffer = builder.endNullable();
        if (buffer != null) BufferRenderer.drawWithGlobalProgram(buffer);
    }
}