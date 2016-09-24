/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins;

public final class PluginInfo {
    private PluginInfo() {}

    // This isn't going to change now - will break permissions if we have the token.
    public static final String ID = "nucleus-mixin";

    public static final String NAME = "@name@";
    public static final String VERSION = "@version@";
    public static final String GIT_HASH = "@gitHash@";

    // Preparing for 4.0.0 SpongeAPI
    public static final String DESCRIPTION = "@description@";
    public static final String URL = "@url@";
}
