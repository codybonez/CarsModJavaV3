package production.carsmod.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CarRenderer extends EntityRenderer<Car, CarRenderState> {

    public CarRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public CarRenderState createRenderState() {
        return new CarRenderState();
    }
}
