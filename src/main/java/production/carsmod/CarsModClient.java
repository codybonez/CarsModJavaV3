package production.carsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityRendererRegistryImpl;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.renderer.entity.EntityRenderers;
import production.carsmod.entities.CarEntity;
import production.carsmod.entities.CarModel;
import production.carsmod.entities.CarRenderer;
import production.carsmod.entities.CarTypes;

import javax.swing.text.JTextComponent;

public class CarsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        CarsModModelLayers.registerModelLayers();

        EntityRendererRegistryImpl.register(CarTypes.Car, CarRenderer::new);
        JTextComponent.KeyBinding CarInput = KeyBindingHelper.registerKeyBinding(new KeyMapping(

        ))
        CarsMod.LOGGER.info("CarsMod Initialized!");
    }


}
