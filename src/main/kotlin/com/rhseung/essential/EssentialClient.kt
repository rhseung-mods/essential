package com.rhseung.essential

import com.rhseung.essential.init.ModEntityTypes
import com.rhseung.essential.init.ModItems
import com.rhseung.essential.torcharrow.TorchArrowEntityRenderer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry

object EssentialClient : ClientModInitializer {
    override fun onInitializeClient() {
        ModEntityTypes.initializeClient();
        ModItems.initializeClient();

        EntityRendererRegistry.register(ModEntityTypes.TORCH_ARROW, ::TorchArrowEntityRenderer);
    }
}