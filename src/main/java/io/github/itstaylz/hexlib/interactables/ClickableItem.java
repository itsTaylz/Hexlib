package io.github.itstaylz.hexlib.interactables;

import io.github.itstaylz.hexlib.HexlibPlugin;
import io.github.itstaylz.hexlib.utils.ItemUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class ClickableItem {

    private final NamespacedKey key;
    private final ItemStack itemStack;
    private final ItemClickHandler handler;

    public ClickableItem(NamespacedKey key, ItemStack itemStack, ItemClickHandler handler) {
        this.key = key;
        this.itemStack = itemStack;
        this.handler = handler;
        ClickableItemManager.registerClickableItem(this);
    }

    public void giveItem(Player player) {
        ItemStack item = this.itemStack.clone();
        ItemUtils.setPDCValue(item, new NamespacedKey(JavaPlugin.getPlugin(HexlibPlugin.class), "clickable_item"), PersistentDataType.STRING, this.key.toString());
        player.getInventory().addItem(item);
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
