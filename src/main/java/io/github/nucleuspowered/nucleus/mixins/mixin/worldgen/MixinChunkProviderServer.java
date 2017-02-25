/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin.worldgen;

import com.flowpowered.math.vector.Vector3i;
import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinChunkProviderServer;
import io.github.nucleuspowered.nucleus.mixins.interfaces.internal.INucleusInternalMixinChunkLoader;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChunkProviderServer.class)
public abstract class MixinChunkProviderServer implements IChunkProvider, INucleusMixinChunkProviderServer {

    @Shadow @Final @Mutable public Long2ObjectMap<Chunk> id2ChunkMap;
    @Shadow @Final private IChunkLoader chunkLoader;
    @Shadow @Final private WorldServer worldObj;
    @Shadow public IChunkGenerator chunkGenerator;
    @Shadow public abstract Chunk loadChunkFromFile(int x, int z);
    @Shadow public abstract boolean chunkExists(int x, int z);

    // From SpongeCommon - MIT
    private void nucleusLoadChunkForce(int x, int z) {
        Chunk chunk = this.loadChunkFromFile(x, z);

        if (chunk == null)
        {
            long i = ChunkPos.chunkXZ2Int(x, z);

            try
            {
                chunk = this.chunkGenerator.provideChunk(x, z);
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Exception generating new chunk");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Chunk to be generated");
                crashreportcategory.addCrashSection("Location", String.format("%d,%d", new Object[] {Integer.valueOf(x), Integer.valueOf(z)}));
                crashreportcategory.addCrashSection("Position hash", Long.valueOf(i));
                crashreportcategory.addCrashSection("Generator", this.chunkGenerator);
                throw new ReportedException(crashreport);
            }
        }

        this.id2ChunkMap.put(ChunkPos.chunkXZ2Int(x, z), chunk);
        chunk.onChunkLoad();
        chunk.populateChunk((ChunkProviderServer)(Object) this, this.chunkGenerator);
    }

    @Override public boolean hasBeenLoadedBefore(Vector3i position) {
        return chunkExists(position.getX(), position.getZ()) || ((INucleusInternalMixinChunkLoader) chunkLoader)
                .chunkExists(worldObj, position.getX(), position.getZ());
    }

    @Override public void loadForce(int x, int z) {
        nucleusLoadChunkForce(x, z);
    }
}
