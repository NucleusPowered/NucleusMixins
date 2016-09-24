/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.interfaces.internal;

import net.minecraft.world.World;

/**
 * For internal use only.
 */
public interface INucleusInternalMixinChunkLoader {

    boolean chunkExists(World world, int x, int z);
}
