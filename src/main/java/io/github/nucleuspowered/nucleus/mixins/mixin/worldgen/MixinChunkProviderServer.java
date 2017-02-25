/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin.worldgen;

import com.flowpowered.math.vector.Vector3i;
import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinChunkProviderServer;
import io.github.nucleuspowered.nucleus.mixins.interfaces.internal.INucleusInternalMixinChunkLoader;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChunkProviderServer.class)
public abstract class MixinChunkProviderServer implements IChunkProvider, INucleusMixinChunkProviderServer {

    @Shadow @Final private IChunkLoader chunkLoader;
    @Shadow @Final private WorldServer worldObj;
    @Shadow public abstract boolean chunkExists(int x, int z);

    @Shadow private Chunk loadChunkForce(int x, int z) { return null; }

    @Override public boolean hasBeenLoadedBefore(Vector3i position) {
        return chunkExists(position.getX(), position.getZ()) || ((INucleusInternalMixinChunkLoader) chunkLoader)
                .chunkExists(worldObj, position.getX(), position.getZ());
    }

    @Override public void loadForce(int x, int z) {
        loadChunkForce(x, z);
    }
}
