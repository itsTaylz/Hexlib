package io.github.itstaylz.hexlib.menus.components;

import io.github.itstaylz.hexlib.menus.Menu;
import io.github.itstaylz.hexlib.menus.handlers.MenuButtonClickHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuButton extends MenuComponent {

    private final MenuButtonClickHandler clickHandler;

    public MenuButton(ItemStack itemStack, MenuButtonClickHandler clickHandler) {
        super(itemStack);
        this.clickHandler = clickHandler;
    }

    @Override
    public void onClick(InventoryClickEvent event, Player player, Menu menu) {
        event.setCancelled(true);
        this.clickHandler.onClick(event, player, menu);
    }
}
