/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.util;

import java.io.File;

public final class RegionFileUtility {

    private RegionFileUtility() {}

    public static File getRegionFile(File worldDir, int chunkX, int chunkZ) {
        File file1 = new File(worldDir, "region");
        return new File(file1, "r." + (chunkX >> 5) + "." + (chunkZ >> 5) + ".mca");
    }

    public static boolean regionFileExists(File regionFile) {
        return regionFile.exists();
    }

    public static boolean regionFileExists(File worldDir, int chunkX, int chunkZ) {
        return getRegionFile(worldDir, chunkX, chunkZ).exists();
    }
}
