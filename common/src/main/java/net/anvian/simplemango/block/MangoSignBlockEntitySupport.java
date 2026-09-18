package net.anvian.simplemango.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

final class MangoSignBlockEntitySupport {
    private static boolean registered;

    private MangoSignBlockEntitySupport() {
    }

    static void register(Block... blocks) {
        if (registered) {
            return;
        }

        try {
            for (Field field : BlockEntityType.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || !Set.class.isAssignableFrom(field.getType())) {
                    continue;
                }

                field.setAccessible(true);
                Object value = field.get(BlockEntityType.SIGN);
                if (!(value instanceof Set<?> set) || !set.contains(Blocks.OAK_SIGN)) {
                    continue;
                }

                @SuppressWarnings("unchecked")
                Set<Block> validBlocks = new HashSet<>((Set<Block>) set);
                validBlocks.addAll(Arrays.asList(blocks));
                field.set(BlockEntityType.SIGN, validBlocks);
                if (Arrays.stream(blocks).allMatch(block -> BlockEntityType.SIGN.isValid(block.defaultBlockState()))) {
                    registered = true;
                    return;
                }
                throw new IllegalStateException("Mango signs were not accepted by BlockEntityType.SIGN");
            }
        } catch (ReflectiveOperationException | RuntimeException exception) {
            throw new IllegalStateException("Unable to register Mango sign blocks", exception);
        }

        throw new IllegalStateException("BlockEntityType.SIGN valid block set was not found");
    }
}
