package production.carsmod.entities;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

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

        this.move(MoverType.SELF, this.getDeltaMovement());
    }


    @Override
    public void move(MoverType moverType, Vec3 vec3) {
        super.move(moverType, vec3);
    }







    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        InteractionResult superInteraction = super.interact(player, hand);
        if (superInteraction != InteractionResult.PASS) {

            return superInteraction;
        } else {

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