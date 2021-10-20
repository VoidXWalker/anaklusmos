package com.voidxwalker.anaklusmos.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Consumer;

@Mixin(TridentItem.class)
public class TridentItemMixin<T> extends Item {
    public TridentItemMixin(Settings settings) {
        super(settings);
    }
    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    public boolean isTouchingWaterOrRain(PlayerEntity instance) {
        return true;
    }
    @Redirect(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Ljava/util/function/Consumer;)V"))
    public void empty(ItemStack instance, int amount, LivingEntity entity, Consumer<T> breakCallback) {
    }
    @Redirect(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    public boolean empty2(PlayerEntity instance) {
        return true;
    }

}
