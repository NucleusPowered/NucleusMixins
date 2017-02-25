/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.interfaces;

import com.flowpowered.math.vector.Vector3i;

public interface INucleusMixinChunkProviderServer {

    /**
     * Bypasses the deny chunk check.
     *
     * @param x The "x" co-ord
     * @param z The "z" co-ord
     */
    void loadForce(int x, int z);

    /**
     * Attempts to see if the chunk in question has been loaded before.
     *
     * @param position A position within the chunk to check.
     * @return {@code true} if the chunk has previously been loaded.
     */
    boolean hasBeenLoadedBefore(Vector3i position);
}
