/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.interfaces;

import java.io.IOException;

public interface INucleusMixinWorldServer {

    boolean saveWorld() throws IOException;
}
