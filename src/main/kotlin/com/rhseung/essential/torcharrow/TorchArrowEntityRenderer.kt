package com.rhseung.essential.torcharrow

import com.rhseung.essential.Essential
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.ProjectileEntityRenderer
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class TorchArrowEntityRenderer(context: EntityRendererFactory.Context) : ProjectileEntityRenderer<TorchArrowEntity, ProjectileEntityRenderState>(context) {
    val TEXTURE: Identifier = Essential.id("textures/entity/projectiles/torch_arrow.png");

    override fun getTexture(state: ProjectileEntityRenderState): Identifier {
        return TEXTURE;
    }

    override fun createRenderState(): ProjectileEntityRenderState {
        return ProjectileEntityRenderState();
    }
}