package io.github.itstaylz.hexlib.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

/**
 * A set of utilities to use for ItemStacks
 */
public final class ItemUtils {

    /**
     * Sets a Persistent Data Container value of an itemstack
     * @param item The item to be added the value
     * @param key The namespaced key for the value to be set
     * @param dataType The datatype of the value
     * @param value The value to be set
     */
    public static <T, Z> void setPDCValue(@NotNull ItemStack item, @NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> dataType, Z value) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null)
            return;
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key, dataType, value);
        item.setItemMeta(meta);
    }

    /**
     * Return a Persistent Data Container value from an itemstack
     * @param item The item to be added the value
     * @param key The namespaced key for the value to be set
     * @param dataType The datatype of the value
     */
    public static <T, Z> Z getPDCValue(@NotNull ItemStack item, @NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> dataType) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null)
            return null;
        PersistentDataContainer container = meta.getPersistentDataContainer();
        return container.get(key, dataType);
    }

    /**
     * Checks if the itemstack has a certain Persistent Data Container Key set
     * @param item The itemstack to be checked
     * @param key The namespaced key of the container to be checked
     * @param dataType The datatype of the value
     */
    public static <T, Z> boolean hasPDCValue(@NotNull ItemStack item, @NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> dataType) {
        return getPDCValue(item, key, dataType) != null;
    }
}
