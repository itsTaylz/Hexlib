package io.github.itstaylz.hexlib.menus.handlers;

import io.github.itstaylz.hexlib.menus.Menu;
import org.bukkit.entity.Player;

public interface MenuCloseHandler {

    void onClose(Player player, Menu menu);
}
