package ru.vanilla.nextbots.nextbot;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class NextbotEntityModel extends EntityModel<NextbotEntityRenderState> {

    protected NextbotEntityModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setAngles(NextbotEntityRenderState state) {
        super.setAngles(state);
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(new ModelData(), 16, 16);
    }
}