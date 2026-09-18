package net.anvian.simplemango.wood;

import net.anvian.simplemango.platform.Services;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class ModWoodTypes {
    public static WoodType MANGO;

    private ModWoodTypes() {}

    public static void init() {
        if (MANGO == null) {
            MANGO = Services.PLATFORM.createWoodType("mango");
        }
    }

    public static WoodType createAndRegisterReflectively(String name) {
        try {
            Constructor<WoodType> constructor = WoodType.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return registerReflectively(constructor.newInstance(name));
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to create Mango wood type", exception);
        }
    }

    public static WoodType registerReflectively(WoodType woodType) {
        WoodType existing = WoodType.values()
                .filter(type -> type.name().equals(woodType.name()))
                .findFirst()
                .orElse(null);
        if (existing != null) {
            return existing;
        }

        for (Method method : WoodType.class.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers())
                    && method.getReturnType() == WoodType.class
                    && method.getParameterCount() == 1
                    && method.getParameterTypes()[0] == WoodType.class) {
                try {
                    method.setAccessible(true);
                    return (WoodType) method.invoke(null, woodType);
                } catch (ReflectiveOperationException exception) {
                    throw new IllegalStateException("Unable to register Mango wood type", exception);
                }
            }
        }
        throw new IllegalStateException("WoodType registration method was not found");
    }
}
