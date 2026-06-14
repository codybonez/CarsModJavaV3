package production.carsmod.entities;




import net.minecraft.client.model.EntityModel;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.animal.Animal;
import org.intellij.lang.annotations.Identifier;


public class CarModel<T extends Animal> extends EntityModel<CarRenderState> {
//
	public final ModelPart Wheels;
	public final ModelPart Body;

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




		PartDefinition Wheels = partdefinition.addOrReplaceChild("Wheels", CubeListBuilder.create().texOffs(72, 52)
				.addBox(6.3F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(72, 60).addBox(-8.8F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F)
				.texOffs(0, 75).addBox(6.2F, -1.0F, 5.0F, 2.0F, 4.0F, 4.0F)
				.texOffs(72, 68).addBox(-8.8F, -1.0F, 5.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(0.2F, 0.8F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-7.6F, 1.7F, -11.1F, 16.0F, 6.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-7.6F, 7.7F, -11.0F, 16.0F, 1.0F, 22.0F)
				.texOffs(0, 52).addBox(-6.6F, 0.6F, -11.0F, 14.0F, 1.0F, 22.0F), PartPose.offset(-0.5F, 3.0F, 0.0F));


		return LayerDefinition.create(meshdefinition, 128, 128);


	}




}