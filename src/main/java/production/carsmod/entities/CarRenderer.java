package production.carsmod.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import production.carsmod.CarsMod;
import production.carsmod.CarsModModelLayers;

public class CarRenderer extends EntityRenderer<Car, CarRenderState> {

    public CarRenderer(EntityRendererProvider.Context context) {
        super(context);
        new CarModel(context.bakeLayer(CarsModModelLayers.CAR));
    }

    @Override
    public CarRenderState createRenderState() {
        return new CarRenderState();
    }
}
