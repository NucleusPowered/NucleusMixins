/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import javax.inject.Inject;

@Plugin(id = PluginInfo.ID, name = PluginInfo.NAME, version = PluginInfo.VERSION, description = PluginInfo.DESCRIPTION)
public class NucleusMixinSpongePlugin {

    @Inject private Logger logger;

    @Listener
    public void onPreInit(GamePreInitializationEvent event) {
        PluginInfo.lockLoading();
        if (PluginInfo.isIsLoaded()) {
            logger.info("Nucleus Mixin enhancements " + PluginInfo.VERSION);
        } else {
            logger.error("FAILED TO LOAD: Nucleus Mixin enhancements " + PluginInfo.VERSION + " - larger error message coming up.");
        }
    }

    @Listener
    public void onStarted(GameStartedServerEvent event) {
        if (!PluginInfo.isIsLoaded()) {
            ConsoleSource source = Sponge.getServer().getConsole();

            Lists.newArrayList(
                    Text.of(TextColors.RED, "----------------------------------"),
                    Text.of(TextColors.RED, "- NUCLEUS MIXINS WERE NOT LOADED -"),
                    Text.of(TextColors.RED, "----------------------------------"),
                    Text.of(TextColors.RED, " "),
                    Text.of(TextColors.RED, "The Nucleus Mixins are not being applied, and so /invsee and pregen enhancements will not work."),
                    Text.of(TextColors.RED, "This is usually because you have not put Nucleus Mixins in your ", TextColors.YELLOW, "mods", TextColors.RED,
                            " directory. Nucleus Mixins is a MOD and **must** go in the mods folder."),
                    Text.of(TextColors.RED, "Please put the mixins in ", TextColors.YELLOW, "/mods ", TextColors.RED, " - not ", TextColors.YELLOW,
                            "/plugins", TextColors.RED, " or any other directory - and restart your server.")).forEach(source::sendMessage);
        }
    }
}
