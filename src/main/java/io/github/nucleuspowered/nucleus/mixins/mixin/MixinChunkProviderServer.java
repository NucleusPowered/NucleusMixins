/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin;

import com.flowpowered.math.vector.Vector3i;
import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinChunkLoader;
import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinChunkProviderServer;
import io.github.nucleuspowered.nucleus.mixins.util.RegionFileUtility;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.chunk.storage.RegionFileCache;
import net.minecraft.world.gen.ChunkProviderServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.File;

@Mixin(ChunkProviderServer.class)
public abstract class MixinChunkProviderServer implements IChunkProvider, INucleusMixinChunkProviderServer {

    @Shadow @Final private IChunkLoader chunkLoader;
    @Shadow public abstract boolean chunkExists(int x, int z);

    @Override public boolean hasBeenLoadedBefore(Vector3i position) {
        if (chunkExists(position.getX(), position.getZ())) {
            return true;
        }

        // If we haven't got a region file, we haven't loaded this chunk before.
        INucleusMixinChunkLoader nucleusMixinChunkLoader = ((INucleusMixinChunkLoader)chunkLoader);
        File regionFile = RegionFileUtility.getRegionFile(nucleusMixinChunkLoader.getWorldDir(), position.getX(), position.getZ());
        if (!regionFile.exists()) {
            return false;
        }

        // Time to do some Chunk checking!
        return RegionFileCache.getChunkInputStream(regionFile, position.getX(), position.getZ()) != null;
    }
}
