package net.anvian.simplemango.forge.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class ModDesertPyramid extends LootModifier {
    public static final Supplier<Codec<ModDesertPyramid>> CODEC =
            Suppliers.memoize(() -> RecordCodecBuilder.create(instance -> codecStart(instance)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(modifier -> modifier.item))
                    .apply(instance, ModDesertPyramid::new)));
    private final Item item;

    private ModDesertPyramid(LootItemCondition[] conditions, Item item) {
        super(conditions);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(
            ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() <= 0.026F) {
            generatedLoot.add(new ItemStack(item));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
