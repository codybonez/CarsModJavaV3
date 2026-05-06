package production.carsmod.entities;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import production.carsmod.CarsMod;

public  class CarTypes {
    public static final EntityType<Car> Car = register("Car", EntityType.Builder.<Car>of(production.carsmod.entities.Car::new, MobCategory.MISC).sized(10,10));

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(CarsMod.MOD_ID, name));
        return  Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
    public static void registerModEntityTypes(){
        CarsMod.LOGGER.info("Registering EntityTypes for "+ CarsMod.MOD_ID);
    }
}
