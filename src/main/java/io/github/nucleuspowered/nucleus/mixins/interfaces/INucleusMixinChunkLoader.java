/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.interfaces;

import java.io.File;

public interface INucleusMixinChunkLoader {

    /**
     * Gets the directory where this world's data is housed.
     *
     * @return The {@link File} containing the world data.
     */
    File getWorldDir();
}
