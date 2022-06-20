package io.github.itstaylz.hexlib.interactables;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public interface ItemClickHandler {

    void onClick(PlayerInteractEvent event, Player player, ItemStack item);
}
