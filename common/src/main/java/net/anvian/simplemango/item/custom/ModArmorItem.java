package net.anvian.simplemango.item.custom;

import com.google.common.collect.ImmutableMap;
import net.anvian.simplemango.item.ModArmorMaterial;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;
import java.util.Random;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffect> MATERIAL_TO_EFFECT_MAP = new ImmutableMap.Builder<
                    ArmorMaterial, MobEffect>()
            .put(ModArmorMaterial.SEED, MobEffects.LUCK)
            .build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!level.isClientSide() && entity instanceof Player player && hasHelmetArmorOn(player)) {
            evaluateArmorEffects(player);
        }
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffect> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            if (hasCorrectArmorOn(entry.getKey(), player)) {
                addStatusEffectForMaterial(player, entry.getKey(), entry.getValue());
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial material, MobEffect effect) {
        if (hasCorrectArmorOn(material, player) && !player.hasEffect(effect)) {
            player.addEffect(new MobEffectInstance(effect, 200));
            if (new Random().nextFloat() > 0.8F) {
                player.getInventory().hurtArmor(DamageSource.MAGIC, 1.0F, new int[] {0, 1, 2, 3});
            }
        }
    }

    private boolean hasHelmetArmorOn(Player player) {
        return !player.getInventory().getArmor(3).isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        return player.getInventory().getArmor(3).getItem() instanceof ArmorItem armor
                && armor.getMaterial() == material;
    }
}
