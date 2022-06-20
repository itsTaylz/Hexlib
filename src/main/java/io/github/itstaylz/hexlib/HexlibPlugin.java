package io.github.itstaylz.hexlib;

import io.github.itstaylz.hexlib.interactables.ClickableItem;
import io.github.itstaylz.hexlib.interactables.ClickableItemListener;
import io.github.itstaylz.hexlib.menus.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class HexlibPlugin extends JavaPlugin implements CommandExecutor {

    private final ItemStack item = new ItemStack(Material.BLAZE_ROD);

    private final ClickableItem clickableItem = new ClickableItem(new NamespacedKey(this, "blaze_rod"), item, ((event, player, item1) -> {
        player.launchProjectile(Fireball.class, player.getLocation().getDirection().multiply(3));
    }));

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new ClickableItemListener(this), this);
        getCommand("hexlibdebug").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            this.clickableItem.giveItem(player);
        }
        return true;
    }
}
