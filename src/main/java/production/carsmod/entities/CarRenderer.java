package production.carsmod.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import production.carsmod.CarsMod;
import production.carsmod.CarsModModelLayers;

import java.util.function.UnaryOperator;

public class CarRenderer extends EntityRenderer<CarEntity, CarRenderState> {

    private  final Identifier TEXTURE;
    private final CarModel model;

    public CarRenderer(EntityRendererProvider.Context context) {
        super(context);

       this.model =  new CarModel<>(context.bakeLayer(CarsModModelLayers.CAR));
       this.TEXTURE = Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, "entities/textures/car_texture.png");
//        modelLayerLocation.model().withPath((UnaryOperator<String>)(string -> "entities/textures/" + string + ".png") );
        System.out.println("Car rendered");

    }

    @Override
    public void submit(CarRenderState entityRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        super.submit(entityRenderState, poseStack, submitNodeCollector, cameraRenderState);
    }


    @Override
    public CarRenderState createRenderState() {
        return new CarRenderState();
    }
}

