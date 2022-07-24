package io.github.itstaylz.hexlib.menus.components;

import io.github.itstaylz.hexlib.menus.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuCollectableItem extends MenuComponent {

    public MenuCollectableItem(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public void onClick(InventoryClickEvent event, Player player, Menu menu) {
    }
}
