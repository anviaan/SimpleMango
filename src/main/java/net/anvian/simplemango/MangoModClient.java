package net.anvian.simplemango;

import net.anvian.simplemango.util.ModRenderHelper;
import net.fabricmc.api.ClientModInitializer;

public class MangoModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();
    }
}
