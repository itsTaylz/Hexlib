package io.github.itstaylz.hexlib.menus.components;

import io.github.itstaylz.hexlib.menus.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuItem extends MenuComponent {

    public MenuItem(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public void handleClick(InventoryClickEvent event, Player player, Menu menu) {
        event.setCancelled(true);
    }
}
