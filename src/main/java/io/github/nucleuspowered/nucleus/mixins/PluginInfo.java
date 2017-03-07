/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins;

public final class PluginInfo {
    private PluginInfo() {}

    private static boolean lock = false;
    private static boolean isLoaded = false;

    public static boolean isIsLoaded() {
        return isLoaded;
    }

    public static void lockLoading() {
        lock = true;
    }

    public static void setLoaded() {
        if (!lock) {
            isLoaded = true;
        }
    }

    // This isn't going to change now - will break permissions if we have the token.
    public static final String ID = "nucleus-mixin";

    public static final String NAME = "Nucleus Mixins";
    public static final String VERSION = "0.25.2-5.1";

    // Preparing for 4.0.0 SpongeAPI
    public static final String DESCRIPTION = "Nucleus Mixins";
}
