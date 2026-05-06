package production.carsmod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Car extends VehicleEntity {
    public Car(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected Item getDropItem() {
        return null;
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {

    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {

    }

//    public AttributeSupplier.Builder CreateAttributes() {
//    return
//
//    }
}