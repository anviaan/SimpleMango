package net.anvian.simplemango.platform;

import java.util.ServiceLoader;

public final class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    private Services() {
    }

    private static <T> T load(Class<T> serviceClass) {
        return ServiceLoader.load(serviceClass)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No platform implementation found for " + serviceClass.getName()));
    }
}
