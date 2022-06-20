package io.github.itstaylz.hexlib;

import io.github.itstaylz.hexlib.interactables.ClickableItemListener;
import io.github.itstaylz.hexlib.menus.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class HexlibPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new ClickableItemListener(this), this);

        // Used for debugging
        getCommand("hexlibdebug").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            // DEBUG CODE HERE
        }
        return true;
    }
}
