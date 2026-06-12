package production.carsmod.entities;

import com.google.common.collect.Lists;
import com.mojang.realmsclient.dto.PlayerInfo;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.happyghast.HappyGhast;
import net.minecraft.world.entity.animal.pig.PigVariants;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.variant.VariantUtils;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;
import production.carsmod.items.CarItem;

import java.util.List;

public class CarEntity extends Animal implements ItemSteerable{
    private static final float SIDEWAYS_MOVE_SPEED_FACTOR = 0.5F;
    private static final EntityDataAccessor<Integer> DATA_BOOST_TIME = SynchedEntityData.defineId(CarEntity.class, EntityDataSerializers.INT);
    private final ItemBasedSteering steering = new ItemBasedSteering(this.entityData, DATA_BOOST_TIME);
    private float deltaRotation;

    public CarEntity(EntityType<? extends CarEntity> entityType, Level level) {
        super(entityType, level);

    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        if (DATA_BOOST_TIME.equals(entityDataAccessor) && this.level().isClientSide()) {
            this.steering.onSynced();
        }

        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_BOOST_TIME, 0);

    }


    @Override
    protected MovementEmission getMovementEmission(){
        return Entity.MovementEmission.EVENTS;
    }


    protected Item getDropItem() {
        return CarItem.CAR_SPAWN_EGG;
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {

    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {

    }

    @Override
    public void tick() {
        super.tick();

//


    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 2.0F);

    }

    @Override
    protected SoundEvent getDeathSound() {
        return  SoundEvents.VINDICATOR_CELEBRATE;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.TOTEM_USE;
    }



    public static AttributeSupplier.Builder createAttributes() {
    return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 1000.0).add(Attributes.MOVEMENT_SPEED, 2)
            .add(Attributes.KNOCKBACK_RESISTANCE, 100);
}

    @Override
    public boolean startRiding(Entity entity, boolean bl, boolean bl2) {

        return true;
    }

//


    @Override
    protected void positionRider(Entity entity, MoveFunction moveFunction) {
        super.positionRider(entity, moveFunction);
      	if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).yBodyRot = this.yBodyRot;
        }
    }
    protected Vec2 getRiddenRotation(LivingEntity livingEntity) {
        return new Vec2(livingEntity.getXRot() * 0.75F, livingEntity.getYRot());
    }
    @Override
    protected void tickRidden(Player player, Vec3 vec3) {

        super.tickRidden(player, vec3);
        Vec2 vec2 = this.getRiddenRotation(player);
        float f = this.getYRot();
        float g = Mth.wrapDegrees(vec2.y - f);
        float h = 0.08F;
        f += g * 0.1F;
        this.setRot(f, vec2.x);
        this.yRotO = this.yBodyRot = this.yHeadRot = f;

    }



    @Override
    protected Vec3 getRiddenInput(Player player, Vec3 vec3) {
        float f = player.xxa * 1.2F;
        float g = player.zza;
        if (g <= 0.0F) {
            g *= 0.25F;
        }

        return new Vec3(f, 0.0, g);



    }
    @Nullable
    private Vec3 getDismountLocationInDirection(Vec3 vec3, LivingEntity livingEntity) {
        double d = this.getX() + vec3.x;
        double e = this.getBoundingBox().minY;
        double f = this.getZ() + vec3.z;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (Pose pose : livingEntity.getDismountPoses()) {
            mutableBlockPos.set(d, e, f);
            double g = this.getBoundingBox().maxY + 0.75;

            do {
                double h = this.level().getBlockFloorHeight(mutableBlockPos);
                if (mutableBlockPos.getY() + h > g) {
                    break;
                }

                if (DismountHelper.isBlockFloorValid(h)) {
                    AABB aABB = livingEntity.getLocalBoundsForPose(pose);
                    Vec3 vec32 = new Vec3(d, mutableBlockPos.getY() + h, f);
                    if (DismountHelper.canDismountTo(this.level(), livingEntity, aABB.move(vec32))) {
                        livingEntity.setPose(pose);
                        return vec32;
                    }
                }

                mutableBlockPos.move(Direction.UP);
            } while (!(mutableBlockPos.getY() < g));
        }

        return null;
    }
    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
        Vec3 vec3 = getCollisionHorizontalEscapeVector(
                this.getBbWidth(), livingEntity.getBbWidth(), this.getYRot() + (livingEntity.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F)
        );
        Vec3 vec32 = this.getDismountLocationInDirection(vec3, livingEntity);
        if (vec32 != null) {
            return vec32;
        } else {
            Vec3 vec33 = getCollisionHorizontalEscapeVector(
                    this.getBbWidth(), livingEntity.getBbWidth(), this.getYRot() + (livingEntity.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F)
            );
            Vec3 vec34 = this.getDismountLocationInDirection(vec33, livingEntity);
            return vec34 != null ? vec34 : this.position();
        }
    }
    @Override
    protected float getRiddenSpeed(Player player) {
        return (float)(this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 0.225);
    }

    @Override
        public boolean isPickable () {
            return true;
        }

    @Override
    public boolean isPushable() {
        return false;
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

    @Override
    public boolean boost() {
        return this.steering.boost(this.getRandom());
    }
//    public AttributeSupplier.Builder CreateAttributes() {
//    return
//
    }
