package com.rhseung.essential.torcharrow

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.item.ArrowItem
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.ProjectileItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Position
import net.minecraft.world.World

class TorchArrowItem(val id: Identifier, settings: Settings)
    : ArrowItem(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, id))), ProjectileItem {

    init {
        Registry.register(Registries.ITEM, id, this);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register {
            it.add(this);
        }
    }

    override fun createArrow(
        world: World,
        stack: ItemStack,
        shooter: LivingEntity,
        shotFrom: ItemStack?
    ): PersistentProjectileEntity {
        return TorchArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }

    override fun createEntity(
        world: World,
        pos: Position,
        stack: ItemStack,
        direction: Direction
    ): ProjectileEntity {
        return TorchArrowEntity(world, pos.x, pos.y, pos.z, stack.copyWithCount(1), null);
    }
}