package production.carsmod.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import production.carsmod.CarsMod;
import production.carsmod.entities.CarTypes;

import java.util.function.Function;

public class CarItem extends Item {
    public CarItem(Properties properties) {
        super(properties);
    }
    public static <T extends Item> T register(String name, Function<Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.accept(CarItem.CAR_SPAWN_EGG));
    }
    public static final Item CAR_SPAWN_EGG = register("car", SpawnEggItem::new, new Item.Properties().spawnEgg(CarTypes.Car));


}
