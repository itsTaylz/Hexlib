package io.github.itstaylz.hexlib;

import io.github.itstaylz.hexlib.interactables.ClickableItemListener;
import io.github.itstaylz.hexlib.menus.Menu;
import io.github.itstaylz.hexlib.menus.MenuListener;
import io.github.itstaylz.hexlib.menus.components.MenuButton;
import io.github.itstaylz.hexlib.menus.components.MenuCollectableItem;
import io.github.itstaylz.hexlib.menus.components.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class HexlibPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new ClickableItemListener(), this);

        // Used for debugging
        getCommand("hexlibdebug").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            Menu menu = Menu.builder()
                    .setTitle("A")
                    .setType(InventoryType.FURNACE)
                    .setCanClickOutsize(false)
                    .setCloseable(true)
                    .build();
            menu.addComponent(0, new MenuButton(new ItemStack(Material.BARRIER), ((event, player1, menu1) -> {
                menu1.close(player1);
            })));
            menu.addComponent(1, new MenuItem(new ItemStack(Material.DIAMOND)));
            menu.addComponent(2, new MenuCollectableItem(new ItemStack(Material.MUSHROOM_STEW)));

            menu.open(player);
        }
        return true;
    }
}
