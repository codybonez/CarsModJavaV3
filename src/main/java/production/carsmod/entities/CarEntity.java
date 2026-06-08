package production.carsmod.entities;

import com.google.common.collect.Lists;
import com.mojang.realmsclient.dto.PlayerInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Input;
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
import production.carsmod.items.CarItem;

import java.util.List;

public class CarEntity extends VehicleEntity{


    private boolean inputLeft;
    private boolean inputRight;
    private boolean inputUp;
    private boolean inputDown;
    private float deltaRotation;

    public CarEntity(EntityType<? extends CarEntity> entityType, Level level) {
        super(entityType, level);

    }


    @Override
    protected Item getDropItem() {
        return CarItem.CAR_SPAWN_EGG;
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
//        this.move(MoverType.SELF, this.getDeltaMovement());
//
//        this.controlBoat();

//        this.move(MoverType.SELF, this.getDeltaMovement());
    }

//    private void controlBoat() {
//        if (this.isVehicle()) {
//            float f = 0.0F;
//            if (this.inputLeft) {
//                this.deltaRotation--;
//            }
//
//            if (this.inputRight) {
//                this.deltaRotation++;
//            }
//
//            if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
//                f += 0.005F;
//            }
//
//            this.setYRot(this.getYRot() + this.deltaRotation);
//
//            if (this.inputUp) {
//                f += 0.04F;
//            }
//
//            if (this.inputDown) {
//                f -= 0.005F;
//            }
//
//            this.setDeltaMovement(
//                    this.getDeltaMovement().add(Mth.sin(-this.getYRot() * (float) (Math.PI / 180.0)) * f, 0.0, Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)) * f)
//            );
//
//        }
//    }
//    public void setInput(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
//        this.inputLeft = bl;
//        this.inputRight = bl2;
//        this.inputUp = bl3;
//        this.inputDown = bl4;
//    }
//    }
    @Override
    public boolean startRiding(Entity entity, boolean bl, boolean bl2) {

        return true;
    }

    @Override
    public void move(MoverType moverType, Vec3 vec3) {

        super.move(moverType, vec3);
    }
    protected void clampRotation(Entity entity) {
        entity.setYBodyRot(0);
        float f = Mth.wrapDegrees(entity.getYRot() - this.getYRot());
        float g = Mth.clamp(f, -360.0F, 360.0F);
        entity.yRotO += g - f;
        entity.setYRot(entity.getYRot() + g - f);
        entity.setYHeadRot(entity.getYRot());
    }
    @Override
    protected void positionRider(Entity entity, MoveFunction moveFunction) {
        super.positionRider(entity, moveFunction);
//        if (entity instanceof LivingEntity) {
//            ((LivingEntity)entity).yBodyRot = this.yRotO;
//        }
        entity.setYRot(entity.getYRot() + this.deltaRotation);
        entity.setYHeadRot(entity.getYHeadRot() + this.deltaRotation);
        this.clampRotation(entity);
        if (entity instanceof Animal) {
            int i = entity.getId() % 2 == 0 ? 90 : 270;
            entity.setYBodyRot(((Animal) entity).yBodyRot + i);
            entity.setYHeadRot(entity.getYHeadRot() + i);
        }
    }
        @Override
        public boolean isPickable () {
            return true;
        }

        @Override
        public LivingEntity getControllingPassenger () {
            return this.getFirstPassenger() instanceof Player player ? player : super.getControllingPassenger();

        }

        @Override
        public InteractionResult interact (Player player, InteractionHand hand){
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
    }
