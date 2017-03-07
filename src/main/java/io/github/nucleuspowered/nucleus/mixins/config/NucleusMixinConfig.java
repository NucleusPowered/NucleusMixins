/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.config;

import com.google.common.reflect.TypeToken;
import io.github.nucleuspowered.nucleus.mixins.PluginInfo;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.commented.SimpleCommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NucleusMixinConfig {

    public static NucleusMixinConfig INSTANCE = new NucleusMixinConfig();

    public final Config config;

    private NucleusMixinConfig() {
        Config config;
        try {
            Path path = Paths.get("config", "nucleus", "mixins.conf");
            ConfigurationLoader<CommentedConfigurationNode> ccn = HoconConfigurationLoader.builder().setPath(path).build();
            CommentedConfigurationNode node = ccn.load();
            node.mergeValuesFrom(SimpleCommentedConfigurationNode.root().setValue(TypeToken.of(Config.class), new Config()));
            ccn.save(node);
            config = node.getValue(TypeToken.of(Config.class));
        } catch (Exception e) {
            config = new Config();
        }

        this.config = config;
    }

    @ConfigSerializable
    public static class Config {

        @Setting(value = "world-generation", comment = "Enhanced world generation")
        private boolean worldgeneration = true;

        @Setting(value = "invsee", comment = "Enables /invsee to work across all players.")
        private boolean invsee = true;

        public boolean isWorldgeneration() {
            return PluginInfo.isIsLoaded() && worldgeneration;
        }

        public boolean isInvsee() {
            return PluginInfo.isIsLoaded() && invsee;
        }
    }
}
