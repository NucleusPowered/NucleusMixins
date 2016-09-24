/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.interfaces;

import com.flowpowered.math.vector.Vector3i;
import net.minecraft.world.chunk.IChunkProvider;

public interface INucleusMixinChunkProviderServer extends IChunkProvider {

    /**
     * Attempts to see if the chunk in question has been loaded before.
     *
     * @param position A position within the chunk to check.
     * @return {@code true} if the chunk has previously been loaded.
     */
    boolean hasBeenLoadedBefore(Vector3i position);
}
