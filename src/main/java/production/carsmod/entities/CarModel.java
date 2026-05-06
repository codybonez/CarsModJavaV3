// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package production.carsmod.entities;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.vehicle.VehicleEntity;

;

public class CarModel extends EntityModel<CarRenderState> {
	private final ModelPart Wheels;
	private final ModelPart Body;
	public CarModel(ModelPart root) {
		super(root);
        this.Wheels = root.getChild("Wheels");
		this.Body = root.getChild("Body");
	}
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		 PartDefinition modelPartData = modelData.getRoot();
		PartDefinition Wheels = modelPartData.addOrReplaceChild("Wheels", CubeListBuilder.create().addBox(2.1F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F)
				.addBox(-4.1F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F)
				.addBox(1.8F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F)
				.addBox(-4.1F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0,0,0));


//		(0, 0).cuboid(-4.1F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
//		.uv(0, 0).cuboid(1.8F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
//		.uv(0, 0).cuboid(-4.1F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
//
//		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(-13, -11).cuboid(-3.0F, -3.2F, -7.0F, 6.0F, 1.0F, 13.0F, new Dilation(0.0F))
//		.uv(-12, -10).cuboid(-3.0F, -4.2F, -6.0F, 6.0F, 1.0F, 12.0F, new Dilation(0.0F))
//		.uv(-11, -10).cuboid(-2.0F, -2.1F, -6.0F, 4.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(modelData, 16, 16);
	}
//	@Override
//	public void setAngles(VehicleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//	}
//	@Override
//	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
//		Wheels.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
//		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
//	}
}