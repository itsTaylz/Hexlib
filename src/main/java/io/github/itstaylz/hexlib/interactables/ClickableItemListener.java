package io.github.itstaylz.hexlib.interactables;

import io.github.itstaylz.hexlib.utils.ItemUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClickableItemListener implements Listener {

    private final NamespacedKey clickKey;

    public ClickableItemListener(JavaPlugin plugin) {
        this.clickKey = new NamespacedKey(plugin, "clickable_item");
    }

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item != null) {
            String keyString = ItemUtils.getPDCValue(item, this.clickKey, PersistentDataType.STRING);
            if (keyString != null) {
                ClickableItem clickableItem = ClickableItemManager.getClickableItem(NamespacedKey.fromString(keyString));
                clickableItem.handleClick(event);
            }
        }
    }
}
