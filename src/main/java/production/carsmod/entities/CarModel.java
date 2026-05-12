package production.carsmod.entities;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.vehicle.VehicleEntity;

public class CarModel<T extends VehicleEntity> extends EntityModel<CarRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "carmodel"), "main");
	private final ModelPart Wheels;
	private final ModelPart Body;

	public CarModel(ModelPart root) {
        super(root);
        this.Wheels = root.getChild("Wheels");
		this.Body = root.getChild("Body");
	}

	@Override
	public void setupAnim(CarRenderState object) {
		super.setupAnim(object);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Wheels = partdefinition.addOrReplaceChild("Wheels", CubeListBuilder.create().texOffs(-1, -2).addBox(6.3F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(-3, -2).addBox(-8.8F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, -2).addBox(6.2F, -1.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(-3, -2).addBox(-8.8F, -1.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2F, 0.8F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(-23, -21).addBox(-7.6F, 1.7F, -11.1F, 16.0F, 6.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(-22, -20).addBox(-7.6F, 7.7F, -11.0F, 16.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(-21, -20).addBox(-6.6F, 0.6F, -11.0F, 14.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 16, 16);


	}


//		PartDefinition Wheels = partdefinition.addOrReplaceChild("Wheels", CubeListBuilder.create().texOffs(0, 0).addBox(2.1F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 0).addBox(-4.1F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 0).addBox(1.8F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 0).addBox(-4.1F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(-13, -11).addBox(-3.0F, 2.2F, -7.0F, 6.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
//		.texOffs(-12, -10).addBox( -3.0F, 3.2F, -6.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
//		.texOffs(-11, -10).addBox(-2.0F, 1.1F, -6.0F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));
//
//		return LayerDefinition.create(meshdefinition, 16, 16);



//	public void setupAnim(VehicleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//
//	}
//
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		Wheels.render(poseStack, vertexConsumer, packedLight, packedOverlay);
//		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay);
//	}
}