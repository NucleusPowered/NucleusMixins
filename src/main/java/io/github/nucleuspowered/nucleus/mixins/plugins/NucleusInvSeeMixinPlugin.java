/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.plugins;

import com.google.common.collect.Lists;
import io.github.nucleuspowered.nucleus.mixins.NucleusMixinSpongePlugin;
import io.github.nucleuspowered.nucleus.mixins.PluginInfo;
import io.github.nucleuspowered.nucleus.mixins.config.NucleusMixinConfig;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class NucleusInvSeeMixinPlugin implements IMixinConfigPlugin {

    @Override public void onLoad(String mixinPackage) {
        PluginInfo.setLoaded();
    }

    @Override public String getRefMapperConfig() {
        return null;
    }

    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return NucleusMixinConfig.INSTANCE.config.isInvsee();
    }

    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override public List<String> getMixins() {
        return Lists.newArrayList();
    }

    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
