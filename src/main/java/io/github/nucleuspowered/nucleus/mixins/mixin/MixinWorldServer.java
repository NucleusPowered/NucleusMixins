/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin;

import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinWorldServer;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.IOException;

@Mixin(value = WorldServer.class)
public abstract class MixinWorldServer extends MixinWorld implements INucleusMixinWorldServer {

    @Shadow protected abstract void saveLevel() throws MinecraftException;

    @Intrinsic
    public boolean saveWorld() throws IOException {
        try {
            saveLevel();
            return true;
        } catch (MinecraftException e) {
            return false;
        }
    }
}
