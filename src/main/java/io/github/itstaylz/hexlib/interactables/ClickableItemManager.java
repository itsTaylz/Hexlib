package io.github.itstaylz.hexlib.interactables;

import org.bukkit.NamespacedKey;

import java.util.HashMap;

final class ClickableItemManager {

    private static final HashMap<NamespacedKey, ClickableItem> CLICKABLE_ITEMS_MAP = new HashMap<>();

    static ClickableItem getClickableItem(NamespacedKey key) {
        return CLICKABLE_ITEMS_MAP.get(key);
    }

    static void registerClickableItem(ClickableItem item) {
        CLICKABLE_ITEMS_MAP.put(item.getKey(), item);
    }
}
