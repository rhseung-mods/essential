package com.rhseung.essential.torcharrow

import com.rhseung.essential.init.ModEntityTypes
import com.rhseung.essential.init.ModItems
import net.minecraft.block.Blocks
import net.minecraft.block.TorchBlock
import net.minecraft.block.WallTorchBlock
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.ArrowEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.Direction
import net.minecraft.world.World

class TorchArrowEntity : PersistentProjectileEntity {
    constructor(entityType: EntityType<out TorchArrowEntity>, world: World)
        : super(entityType, world);

    constructor(world: World, x: Double, y: Double, z: Double, stack: ItemStack, shotFrom: ItemStack?)
        : super(ModEntityTypes.TORCH_ARROW, x, y, z, world, stack, shotFrom);

    constructor(world: World, owner: LivingEntity, stack: ItemStack, shotFrom: ItemStack?)
        : super(ModEntityTypes.TORCH_ARROW, owner, world, stack, shotFrom);

    override fun onBlockHit(blockHitResult: BlockHitResult) {
        super.onBlockHit(blockHitResult);

        if (blockHitResult.side == Direction.DOWN)
            return;

        val pos = blockHitResult.blockPos.offset(blockHitResult.side);
        val block = world.getBlockState(pos).block;
        if (block is TorchBlock)
            return;

        if (blockHitResult.side == Direction.UP)
            world.setBlockState(pos, Blocks.TORCH.defaultState);
        else
            world.setBlockState(pos, Blocks.WALL_TORCH.defaultState.with(WallTorchBlock.FACING, blockHitResult.side));

        this.remove(RemovalReason.DISCARDED);
    }

    override fun getDefaultItemStack(): ItemStack {
        return ItemStack(ModItems.TORCH_ARROW);
    }
}