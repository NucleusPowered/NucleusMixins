/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.interfaces;

import com.flowpowered.math.vector.Vector3i;

public interface INucleusMixinWorld {

    /**
     * Returns whether the specified chunk has been generated
     *
     * @param position The {@link Vector3i} which is a point within the interested chunk.
     * @return <code>true</code> if the chunk has been generated before.
     */
    boolean hasChunkBeenGenerated(Vector3i position);
}
