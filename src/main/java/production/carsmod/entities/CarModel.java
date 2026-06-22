package production.carsmod.entities;




import net.minecraft.client.model.EntityModel;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.entity.animal.Animal;
import org.intellij.lang.annotations.Identifier;


public class CarModel extends EntityModel<CarRenderState> {
//
	public final ModelPart Wheels;
	public final ModelPart Body;

	public CarModel(ModelPart root) {
        super(root);
        this.Wheels = root.getChild("Wheels");
		this.Body = root.getChild("Body");
	}


	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();




     // Remember to flip the y axis when creating models/textures
		PartDefinition Wheels = partdefinition.addOrReplaceChild("Wheels", CubeListBuilder.create().texOffs(44, 50).addBox(6.3F, -3.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 53).addBox(-8.8F, -3.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(12, 53).addBox(6.2F, -3.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 53).addBox(-8.8F, -3.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 23.2F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 27).addBox(-7.0F, -1.5F, -11.0F, 14.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-8.0F, -5.6F, -11.1F, 16.0F, 4.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(0, 50).addBox(-9.7F, -6.6F, -12.7F, 20.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 53).addBox(5.1F, -4.9F, 12.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(40, 53).addBox(-7.1F, -4.9F, 12.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 20.9F, 0.0F, 0.0F, 3.1416F, 0.0F));


		// Non flipped model
//		PartDefinition Wheels = partdefinition.addOrReplaceChild("Wheels", CubeListBuilder.create().texOffs(44, 50).addBox(6.3F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
//				.texOffs(0, 53).addBox(-8.8F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
//				.texOffs(12, 53).addBox(6.2F, -1.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
//				.texOffs(24, 53).addBox(-8.8F, -1.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, 0.8F, 0.0F));
//
//		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 27).addBox(-7.0F, 0.5F, -11.0F, 14.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
//				.texOffs(0, 0).addBox(-8.0F, 1.6F, -11.1F, 16.0F, 4.0F, 23.0F, new CubeDeformation(0.0F))
//				.texOffs(0, 50).addBox(-9.7F, 5.6F, -12.7F, 20.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
//				.texOffs(36, 53).addBox(5.1F, 2.9F, 12.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
//				.texOffs(40, 53).addBox(-7.1F, 2.9F, 12.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 3.1F, 0.0F, 0.0F, 3.1416F, 0.0F));


		return LayerDefinition.create(meshdefinition, 128, 128);

	}





}