package production.carsmod;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import production.carsmod.entities.CarModel;

public class CarsModModelLayers {
    public static final ModelLayerLocation CAR = createMain("Car");

    private static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, name), "main");
    }

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(CarsModModelLayers.CAR, CarModel::getTexturedModelData);
    }
}

