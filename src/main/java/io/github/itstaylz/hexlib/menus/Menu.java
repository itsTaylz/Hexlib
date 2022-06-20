package io.github.itstaylz.hexlib.menus;

import io.github.itstaylz.hexlib.menus.components.MenuComponent;
import io.github.itstaylz.hexlib.menus.handlers.MenuCloseHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;

public class Menu implements InventoryHolder {

    private final Inventory inventory;
    private final HashMap<Integer, MenuComponent> contents = new HashMap<>();
    private MenuCloseHandler closeHandler;

    public Menu(int size, String title) {
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    public Menu(InventoryType type, String title) {
        this.inventory = Bukkit.createInventory(this, type, title);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    public void addComponent(int slot, MenuComponent component) {
        this.contents.put(slot, component);
        this.inventory.setItem(slot, component.getItemStack());
    }

    public void removeComponent(int slot) {
        this.inventory.setItem(slot, null);
        this.contents.remove(slot);
    }

    public void open(Player player) {
        player.openInventory(this.inventory);
    }

    public void setCloseHandler(MenuCloseHandler handler) {
        this.closeHandler = handler;
    }

    void handleClick(InventoryClickEvent event, Player player) {
        int slot = event.getSlot();
        MenuComponent component = this.contents.get(slot);
        if (component != null)
            component.handleClick(event, player, this);
        else
            event.setCancelled(true);
    }

    void handleClose(Player player) {
        if (this.closeHandler != null)
            this.closeHandler.onClose(player, this);
    }
}
