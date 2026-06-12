package production.carsmod.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import production.carsmod.CarsMod;
import production.carsmod.entities.CarEntity;
import production.carsmod.entities.CarTypes;

import java.util.function.Function;

public class CarItem extends Item {
    private final EntityType<? extends CarEntity> entityType;
    public CarItem(Properties properties, EntityType<? extends CarEntity> entityType) {
        super(properties);
        this.entityType = entityType;
    }
    public CarItem(EntityType<? extends CarEntity> entityType, Item.Properties properties) {
        super(properties);
        this.entityType = entityType;

    }
    public static <T extends Item> T register(String name, Function<Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    @Nullable
    private CarEntity getCar(Level level, HitResult hitResult, ItemStack itemStack, Player player) {
        CarEntity car = this.entityType.create(level, EntitySpawnReason.SPAWN_ITEM_USE);
        if (car != null) {
            Vec3 vec3 = hitResult.getLocation();
            car.setInitialPos(vec3.x, vec3.y, vec3.z);
            if (level instanceof ServerLevel serverLevel) {
                EntityType.createDefaultStackConfig(serverLevel, itemStack, player).accept(car);
            }
        }

        return car;
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.accept(CarItem.CAR_SPAWN_EGG));
    }
    public static final Item CAR_SPAWN_EGG = register("car", SpawnEggItem::new, new Item.Properties().spawnEgg(CarTypes.Car));


}
