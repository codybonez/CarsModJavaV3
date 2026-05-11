package production.carsmod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Car extends VehicleEntity {
    public Car(EntityType<? extends Car> entityType, Level level) {
        super(entityType, level);
    }
    public  Car(Level level){
        this(CarTypes.Car, level);
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