package production.carsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import production.carsmod.entities.CarModel;
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
