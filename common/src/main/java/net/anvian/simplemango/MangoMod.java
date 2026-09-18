package net.anvian.simplemango;

import net.anvian.anvianslib.util.LibUtil;
import net.anvian.simplemango.wood.ModWoodTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MangoMod {
    public static final String MOD_ID = "simplemango";
    public static final String MOD_NAME = "Simple Mango";
    public static final String VERSION = "2.0.0";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    private MangoMod() {}

    public static void init() {
        LibUtil.setupTelemetry(MOD_ID, VERSION);
        ModWoodTypes.init();
    }
}
