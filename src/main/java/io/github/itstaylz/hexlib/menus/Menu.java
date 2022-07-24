package io.github.itstaylz.hexlib.menus;

import io.github.itstaylz.hexlib.HexlibPlugin;
import io.github.itstaylz.hexlib.menus.components.MenuComponent;
import io.github.itstaylz.hexlib.menus.handlers.MenuCloseHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Menu implements InventoryHolder {

    private final Inventory inventory;
    private final HashMap<Integer, MenuComponent> contents = new HashMap<>();
    private final MenuCloseHandler closeHandler;
    private final boolean canClickOutside;
    private final boolean closeable;

    private final Set<UUID> closeablePlayers = new HashSet<>();

    protected Menu(int size, String title, boolean canClickOutside, boolean closeable, MenuCloseHandler closeHandler) {
        this.inventory = Bukkit.createInventory(this, size, title);
        this.canClickOutside = canClickOutside;
        this.closeable = closeable;
        this.closeHandler = closeHandler;
    }

    protected Menu(InventoryType type, String title, boolean canClickOutside, boolean closeable, MenuCloseHandler closeHandler) {
        this.inventory = Bukkit.createInventory(this, type, title);
        this.canClickOutside = canClickOutside;
        this.closeable = closeable;
        this.closeHandler = closeHandler;
    }

    @Override
    public @NotNull Inventory getInventory() {
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

    public void close(Player player) {
        closeablePlayers.add(player.getUniqueId());
        player.closeInventory();
    }

    void handleClick(InventoryClickEvent event, Player player) {
        int slot = event.getSlot();
        MenuComponent component = this.contents.get(slot);
        if (component != null)
            component.onClick(event, player, this);
    }

    void handleClose(Player player) {
        if (!this.closeable && !closeablePlayers.contains(player.getUniqueId())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.openInventory(getInventory());
                }
            }.runTaskLater(JavaPlugin.getPlugin(HexlibPlugin.class), 1L);
        } else if (this.closeHandler != null)
            this.closeHandler.onClose(player, this);
        closeablePlayers.remove(player.getUniqueId());
    }

    boolean allowsOutsideClicks() {
        return this.canClickOutside;
    }

    boolean isCloseable() {
        return this.closeable;
    }

    public static MenuBuilder builder() {
        return new MenuBuilder();
    }

    public static class MenuBuilder {

        private int size = 6*9;
        private String title = "";
        private InventoryType type = InventoryType.CHEST;
        private MenuCloseHandler closeHandler = null;
        private boolean canClickOutside = false;

        private boolean closeable = true;

        private MenuBuilder() { }

        public MenuBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public MenuBuilder setTitle(@NotNull String title) {
            this.title = title;
            return this;
        }

        public MenuBuilder setType(@NotNull InventoryType type) {
            this.type = type;
            return this;
        }

        public MenuBuilder setCloseHandler(@Nullable MenuCloseHandler closeHandler) {
            this.closeHandler = closeHandler;
            return this;
        }

        public MenuBuilder setCanClickOutsize(boolean canClickOutside) {
            this.canClickOutside = canClickOutside;
            return this;
        }

        public MenuBuilder setCloseable(boolean closeable) {
            this.closeable = closeable;
            return this;
        }

        public Menu build() {
            if (this.type == InventoryType.CHEST)
                return new Menu(this.size, this.title, this.canClickOutside, this.closeable, this.closeHandler);
            return new Menu(this.type, this.title, this.canClickOutside, this.closeable, this.closeHandler);
        }

    }
}
