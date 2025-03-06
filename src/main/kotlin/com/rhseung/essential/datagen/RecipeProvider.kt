package com.rhseung.essential.datagen

import com.rhseung.essential.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeGenerator
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class RecipeProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricRecipeProvider(output, registriesFuture) {

    override fun getRecipeGenerator(
        registryLookupWrapper: RegistryWrapper.WrapperLookup,
        exporter: RecipeExporter
    ): RecipeGenerator {
        return object : RecipeGenerator(registryLookupWrapper, exporter) {
            override fun generate() {
                this.createShapeless(RecipeCategory.TOOLS, ModItems.TORCH_ARROW, 2)
                    .input(Items.ARROW)
                    .input(Items.TORCH)
                    .criterion(hasItem(Items.ARROW), this.conditionsFromItem(Items.ARROW))
                    .offerTo(exporter);
            }
        }
    }

    override fun getName(): String {
        return "Essential Recipe Provider";
    }
}