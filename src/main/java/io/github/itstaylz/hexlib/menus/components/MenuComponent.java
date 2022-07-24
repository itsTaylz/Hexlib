package io.github.itstaylz.hexlib.menus.components;

import io.github.itstaylz.hexlib.menus.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class MenuComponent {

    private final ItemStack itemStack;

    public MenuComponent(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public abstract void onClick(InventoryClickEvent event, Player player, Menu menu);
}
