package com.rhseung.essential.datagen

import com.rhseung.essential.init.ModEntityTypes
import com.rhseung.essential.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.EntityTypeTags
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class EntityTypeTagProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.EntityTypeTagProvider(output, registriesFuture) {

    override fun configure(registryLookup: RegistryWrapper.WrapperLookup) {
        getOrCreateTagBuilder(EntityTypeTags.ARROWS)
            .add(ModEntityTypes.TORCH_ARROW);
    }
}