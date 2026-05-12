package production.carsmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.renderer.entity.EntityRenderers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import production.carsmod.entities.CarRenderer;
import production.carsmod.entities.CarTypes;

public class CarsMod implements ModInitializer {
	public static final String MOD_ID = "carsmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}