package production.carsmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.renderer.entity.EntityRenderers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import production.carsmod.entities.CarRenderer;
import production.carsmod.entities.CarTypes;

public class CarsMod implements ModInitializer {
	public static final String MOD_ID = "carsmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}