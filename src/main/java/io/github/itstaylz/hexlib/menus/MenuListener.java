package io.github.itstaylz.hexlib.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class MenuListener implements Listener {

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player player) {
            Inventory topInv = player.getOpenInventory().getTopInventory();
            if (event.getClickedInventory() != null && topInv.getHolder() instanceof Menu menu) {
                if (topInv == event.getClickedInventory()) {
                    menu.handleClick(event, player);
                } else if (!menu.allowsOutsideClicks()) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    private void onClose(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player player) {
            if (event.getInventory().getHolder() instanceof Menu menu) {
                menu.handleClose(player);
            }
        }
    }
}
