package net.anvian.simplemango.item.custom;

import net.anvian.simplemango.entity.MangoBoat;
import net.anvian.simplemango.entity.MangoChestBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public final class MangoBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final boolean hasChest;

    public MangoBoatItem(boolean hasChest, Properties properties) {
        super(properties);
        this.hasChest = hasChest;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);
        }

        Vec3 viewVector = player.getViewVector(1.0F);
        List<Entity> entities = level.getEntities(
                player, player.getBoundingBox().expandTowards(viewVector.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
        if (!entities.isEmpty()) {
            Vec3 eyePosition = player.getEyePosition();
            for (Entity entity : entities) {
                AABB bounds = entity.getBoundingBox().inflate(entity.getPickRadius());
                if (bounds.contains(eyePosition)) {
                    return InteractionResultHolder.pass(stack);
                }
            }
        }

        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(stack);
        }

        Boat boat = hasChest
                ? new MangoChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z)
                : new MangoBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
        boat.setYRot(player.getYRot());
        if (!level.noCollision(boat, boat.getBoundingBox())) {
            return InteractionResultHolder.fail(stack);
        }
        if (!level.isClientSide()) {
            level.addFreshEntity(boat);
            level.gameEvent(player, GameEvent.ENTITY_PLACE, hitResult.getLocation());
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
