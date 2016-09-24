/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin;

import com.flowpowered.math.vector.Vector3i;
import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinChunkProviderServer;
import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinWorld;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class MixinWorld implements IBlockAccess, INucleusMixinWorld {

    @Shadow private IChunkProvider chunkProvider;
    @Shadow @Final protected ISaveHandler saveHandler;

    @Override public boolean hasChunkBeenGenerated(Vector3i position) {
        return ((INucleusMixinChunkProviderServer)chunkProvider).hasBeenLoadedBefore(position);
    }
}
