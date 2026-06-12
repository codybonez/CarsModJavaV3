package production.carsmod.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import production.carsmod.CarsMod;
import production.carsmod.CarsModModelLayers;


public class CarRenderer extends EntityRenderer<CarEntity, CarRenderState> {

    private  final Identifier texture = Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, "/textures/entity/car_texture.png");
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


        poseStack.translate(0.0F, 0.375F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - carRenderState.yRot));
//        poseStack.mulPose(Axis.YP.rotation(30));

        poseStack.scale(-1.0F, -1.0F, 1.0F);

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

    public void extractRenderState(CarEntity entity, CarRenderState renderState, float f) {
        super.extractRenderState(entity, renderState, f);
        renderState.yRot = entity.getYRot(f);


}
}


