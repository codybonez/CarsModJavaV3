package production.carsmod.entities;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class CarEntity extends VehicleEntity  {
    public CarEntity(EntityType<? extends CarEntity> entityType, Level level) {
        super(entityType, level);

    }
    public CarEntity(Level level){
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

    @Override
    public void tick() {
        super.tick();

    }



    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        InteractionResult superInteraction = super.interact(player, hand);
        if (superInteraction != InteractionResult.PASS) {
            System.out.println("Interaction failed");
            return superInteraction;
        } else {
            System.out.println("Interaction is good");
            return (player.isSecondaryUseActive()

                    || !this.level().isClientSide() && !player.startRiding(this)
                    ? InteractionResult.PASS
                    : InteractionResult.SUCCESS);
        }
    }
//    public AttributeSupplier.Builder CreateAttributes() {
//    return
//
//    }
}