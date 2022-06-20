package io.github.itstaylz.hexlib.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class ItemUtils {

    public static <T, Z> void setPDCValue(ItemStack item, NamespacedKey key, PersistentDataType<T, Z> dataType, Z value) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null)
            return;
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key, dataType, value);
        item.setItemMeta(meta);
    }

    public static <T, Z> Z getPDCValue(ItemStack item, NamespacedKey key, PersistentDataType<T, Z> dataType) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null)
            return null;
        PersistentDataContainer container = meta.getPersistentDataContainer();
        return container.get(key, dataType);
    }

    public static <T, Z> boolean hasPDCValue(ItemStack item, NamespacedKey key, PersistentDataType<T, Z> dataType) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null)
            return false;
        PersistentDataContainer container = meta.getPersistentDataContainer();
        return container.has(key, dataType);
    }


}
