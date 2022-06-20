package io.github.itstaylz.hexlib.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.function.Predicate;

public final class PlayerUtils {

    public static void clearEffects(Player player) {
        clearEffects(player, e -> true);
    }

    public static void clearEffects(Player player, Predicate<PotionEffect> filter) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            if (filter.test(effect))
                player.removePotionEffect(effect.getType());
        }
    }

    public static void sendActionbarMessage(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    public static boolean canPickup(Player player, ItemStack item) {
        for (ItemStack invItem : player.getInventory().getStorageContents()) {
            if (invItem == null)
                return true;
            if (invItem.isSimilar(item) && invItem.getMaxStackSize() - invItem.getAmount() >= item.getAmount())
                return true;
        }
        return false;
    }
}
