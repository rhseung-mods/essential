package com.rhseung.essential.init

import com.rhseung.blueprint.registration.IModInit
import com.rhseung.essential.torcharrow.TorchArrowEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModEntityTypes : IModInit {
    fun keyOf(name: String): RegistryKey<EntityType<*>> {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.ofVanilla(name));
    }

    fun <T : Entity> register(name: String, type: EntityType.Builder<T>): EntityType<T> {
        val key = keyOf(name);
        return Registry.register(Registries.ENTITY_TYPE, keyOf(name), type.build(key));
    }

    val TORCH_ARROW: EntityType<TorchArrowEntity> = register("torch_arrow",
        EntityType.Builder.create(::TorchArrowEntity, SpawnGroup.MISC)
            .dropsNothing()
            .dimensions(0.5F, 0.5F)
            .eyeHeight(0.13F)
            .maxTrackingRange(4)
            .trackingTickInterval(20)
    )

    override fun initialize() {}

    override fun initializeClient() {}
}