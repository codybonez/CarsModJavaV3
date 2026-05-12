package production.carsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityRendererRegistryImpl;
import net.minecraft.client.renderer.entity.EntityRenderers;
import production.carsmod.entities.CarEntity;
import production.carsmod.entities.CarModel;
import production.carsmod.entities.CarRenderer;
import production.carsmod.entities.CarTypes;

public class CarsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        EntityRendererRegistry.register(CarTypes.Car, CarRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CarsModModelLayers.CAR, CarModel::getTexturedModelData);
        EntityRendererRegistryImpl.register(CarTypes.Car, CarRenderer::new);

        CarsMod.LOGGER.info("CarsMod Initialized!");
    }


}
