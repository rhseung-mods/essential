package com.rhseung.essential.init

import com.rhseung.blueprint.registration.IModInit
import com.rhseung.essential.Essential
import com.rhseung.essential.torcharrow.TorchArrowItem
import net.minecraft.item.Item

object ModItems : IModInit {
    val TORCH_ARROW = TorchArrowItem(Essential.id("torch_arrow"), Item.Settings());

    override fun initialize() {}

    override fun initializeClient() {}
}