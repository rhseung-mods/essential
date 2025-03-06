package com.rhseung.essential

import com.rhseung.essential.datagen.EntityTypeTagProvider
import com.rhseung.essential.datagen.ItemTagProvider
import com.rhseung.essential.datagen.LanguageProvider
import com.rhseung.essential.datagen.ModelProvider
import com.rhseung.essential.datagen.RecipeProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object EssentialDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack();

		pack.addProvider(::EntityTypeTagProvider);
		pack.addProvider(::ItemTagProvider);
		pack.addProvider(::LanguageProvider);
		pack.addProvider(::ModelProvider);
		pack.addProvider(::RecipeProvider);
	}
}