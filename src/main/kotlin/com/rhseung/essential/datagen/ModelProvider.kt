package com.rhseung.essential.datagen

import com.rhseung.essential.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockModel: BlockStateModelGenerator) {
    }

    override fun generateItemModels(itemModel: ItemModelGenerator) {
        itemModel.register(ModItems.TORCH_ARROW, Models.GENERATED);
    }
}