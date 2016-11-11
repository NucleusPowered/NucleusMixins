/*
 * This file is part of NucleusMixins, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.mixins.mixin.invsee;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = InventoryPlayer.class, priority = 1001)
public class MixinInventoryPlayer {

    @Shadow public EntityPlayer player;

    @Inject(method = "isUseableByPlayer", at = @At("HEAD"), cancellable = true)
    public void onIsUseableByPlayer(EntityPlayer viewingPlayer, CallbackInfoReturnable<Boolean> cir) {
        if (!viewingPlayer.getUniqueID().equals(player.getUniqueID())) {
            cir.setReturnValue(true);
        }
    }
}
