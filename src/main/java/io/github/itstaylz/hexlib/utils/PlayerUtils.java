package io.github.itstaylz.hexlib.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * A set of utilities to use for Players
 */
public final class PlayerUtils {

    /**
     * Removes all potion effects from a player
     * @param player The player to remove the potion effects
     */
    public static void clearEffects(@NotNull Player player) {
        clearEffects(player, e -> true);
    }

    /**
     * Removes all potion effects that passes through a filter from a player
     * @param player The player to remove the potion effects
     * @param filter The filter to test potion effects
     */
    public static void clearEffects(@NotNull Player player, @NotNull Predicate<PotionEffect> filter) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            if (filter.test(effect))
                player.removePotionEffect(effect.getType());
        }
    }

    /**
     * Sends a message in the player's action bar
     * @param player The player that the message will be sent
     * @param message The message to be sent
     */
    public static void sendActionbarMessage(@NotNull Player player, @NotNull String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    /**
     * Checks if a player can pickup an itemstack
     * @param player The player to check
     * @param item The item stack to pickup
     * @return True if the players has inventory space to receive the itemstack, false otherwiser.
     */
    public static boolean canPickup(@NotNull Player player, @NotNull ItemStack item) {
        for (ItemStack invItem : player.getInventory().getStorageContents()) {
            if (invItem == null)
                return true;
            if (invItem.isSimilar(item) && invItem.getMaxStackSize() - invItem.getAmount() >= item.getAmount())
                return true;
        }
        return false;
    }
}
