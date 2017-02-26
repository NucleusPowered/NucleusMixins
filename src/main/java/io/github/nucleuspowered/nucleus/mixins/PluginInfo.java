/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins;

public final class PluginInfo {
    private PluginInfo() {}

    // This isn't going to change now - will break permissions if we have the token.
    public static final String ID = "nucleus-mixin";

    public static final String NAME = "Nucleus Mixins";
    public static final String VERSION = "0.25.1-5.1";

    // Preparing for 4.0.0 SpongeAPI
    public static final String DESCRIPTION = "Nucleus Mixins";
}
