package io.github.itstaylz.hexlib.interactables;

import io.github.itstaylz.hexlib.HexlibPlugin;
import io.github.itstaylz.hexlib.utils.ItemUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class ClickableItem {

    private static final JavaPlugin PLUGIN;
    static final NamespacedKey CLICKABLE_ITEM_KEY;

    static {
        PLUGIN = JavaPlugin.getPlugin(HexlibPlugin.class);
        CLICKABLE_ITEM_KEY = new NamespacedKey(PLUGIN, "clickable_item");
    }

    private final NamespacedKey key;
    private final ItemStack itemStack;
    private final ItemClickHandler handler;

    public ClickableItem(String id, ItemStack itemStack, ItemClickHandler handler) {
        this.key = new NamespacedKey(PLUGIN, id);
        this.itemStack = itemStack.clone();
        this.handler = handler;
        ClickableItemManager.registerClickableItem(this);
        ItemUtils.setPDCValue(this.itemStack, CLICKABLE_ITEM_KEY, PersistentDataType.STRING, this.key.toString());
    }

    public ItemStack getItemStack() {
        return itemStack.clone();
    }

    public NamespacedKey getKey() {
        return key;
    }

    void handleClick(PlayerInteractEvent event) {
        handler.onClick(event, event.getPlayer(), event.getItem());
    }
}
