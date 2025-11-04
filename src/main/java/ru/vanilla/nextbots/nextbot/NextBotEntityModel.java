package ru.vanilla.nextbots.nextbot;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(EnvType.CLIENT)
public class NextBotEntityModel extends EntityModel<NextBotEntityRenderState> {

    protected NextBotEntityModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setAngles(NextBotEntityRenderState state) {
        super.setAngles(state);
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(new ModelData(), 16, 16);
    }
}