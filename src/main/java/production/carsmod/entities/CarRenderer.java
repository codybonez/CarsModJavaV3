package production.carsmod.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import production.carsmod.CarsMod;
import production.carsmod.CarsModModelLayers;

public class CarRenderer extends EntityRenderer<Car, CarRenderState> {

//    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, "entities/car_texture.png");
    private final CarModel model;

    public CarRenderer(EntityRendererProvider.Context context) {
        super(context);
       this.model =  new CarModel(context.bakeLayer(CarsModModelLayers.CAR));
        System.out.println("Car rendered");

    }

//    @Override
//    public void extractRenderState(Car entity, CarRenderState entityRenderState, float f) {
//        super.extractRenderState(entity, entityRenderState, f);
//    }
//    public Identifier getTexture(CarRenderer state) {
//        return TEXTURE;
//    }
    @Override
    public CarRenderState createRenderState() {
        return new CarRenderState();
    }
}
