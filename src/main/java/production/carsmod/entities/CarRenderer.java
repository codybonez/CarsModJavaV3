package production.carsmod.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import production.carsmod.CarsMod;
import production.carsmod.CarsModModelLayers;


public class CarRenderer extends EntityRenderer<CarEntity, CarRenderState> {

    private  final Identifier texture = Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, "resources/assets/carsmod/textures/entity/car_texture.png");
    private final EntityModel<CarRenderState> model;
    private final RenderType renderType;

    public CarRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CarModel(context.bakeLayer(CarsModModelLayers.CAR));
        this.renderType = this.model.renderType(this.texture);
//
        CarsMod.LOGGER.info("Car rendered");

    }

    @Override
    public void submit(CarRenderState carRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        submitNodeCollector.submitModel(
                this.model(), carRenderState, poseStack, this.renderType(), carRenderState.lightCoords, OverlayTexture.NO_OVERLAY, carRenderState.outlineColor, null
        );

        poseStack.popPose();
        super.submit(carRenderState, poseStack, submitNodeCollector, cameraRenderState);
    }

    @Override
    public CarRenderState createRenderState() {
        return new CarRenderState();
    }

    protected EntityModel<CarRenderState> model() {
        return this.model;
    }

    protected RenderType renderType() {
        return this.model.renderType(this.texture);
    }
}


