package com.rhseung.essential

import com.rhseung.essential.init.ModEntityTypes
import com.rhseung.essential.init.ModItems
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object Essential : ModInitializer {
	const val MOD_ID = "essential";
    private val logger = LoggerFactory.getLogger(MOD_ID);

	fun id(path: String): Identifier {
		return Identifier.of(MOD_ID, path);
	}

	override fun onInitialize() {
		ModEntityTypes.initialize();
		ModItems.initialize();
	}
}