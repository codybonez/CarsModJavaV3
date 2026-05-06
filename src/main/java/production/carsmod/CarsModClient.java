package production.carsmod;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import production.carsmod.entities.CarRenderer;
import production.carsmod.entities.CarTypes;

public class CarsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register(CarTypes.Car, CarRenderer::new);
        CarsModModelLayers.registerModelLayers();
        CarsMod.LOGGER.info("CarsMod Initialized!");
    }
    public class CarsModCustomEnitityClient implements  ClientModInitializer{
        @Override
        public void onInitializeClient(){

        }
    }
}
