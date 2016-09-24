/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin;

import io.github.nucleuspowered.nucleus.mixins.interfaces.INucleusMixinChunkLoader;
import io.github.nucleuspowered.nucleus.mixins.interfaces.internal.INucleusInternalMixinChunkLoader;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.storage.IThreadedFileIO;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.File;

@Mixin(value = AnvilChunkLoader.class, priority = 0)
public abstract class MixinAnvilChunkLoader implements INucleusMixinChunkLoader, INucleusInternalMixinChunkLoader, IChunkLoader, IThreadedFileIO {

    @Shadow @Final private File chunkSaveLocation;

    @Override public File getWorldDir() {
        return chunkSaveLocation;
    }
}
