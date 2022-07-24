package io.github.itstaylz.hexlib.interactables;

import io.github.itstaylz.hexlib.utils.ItemUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public final class ClickableItemListener implements Listener {

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item != null) {
            String keyString = ItemUtils.getPDCValue(item, ClickableItem.CLICKABLE_ITEM_KEY, PersistentDataType.STRING);
            if (keyString != null) {
                ClickableItem clickableItem = ClickableItemManager.getClickableItem(NamespacedKey.fromString(keyString));
                if (clickableItem != null)
                    clickableItem.handleClick(event);
            }
        }
    }
}
