package io.github.itstaylz.hexlib.menus.handlers;

import io.github.itstaylz.hexlib.menus.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface MenuButtonClickHandler {

    void onClick(InventoryClickEvent event, Player player, Menu menu);
}
