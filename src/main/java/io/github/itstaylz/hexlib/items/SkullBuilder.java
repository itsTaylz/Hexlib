package io.github.itstaylz.hexlib.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class SkullBuilder extends ItemMaker<SkullBuilder> {

    private final SkullMeta skullMeta;

    public SkullBuilder() {
        this(1);
    }

    public SkullBuilder(int amount) {
        super(new ItemStack(Material.PLAYER_HEAD, amount));
        setChildInstance(this);
        this.skullMeta = (SkullMeta) getMeta();
    }

    public SkullBuilder setOwningPlayer(OfflinePlayer owner) {
        this.skullMeta.setOwningPlayer(owner);
        return this;
    }

    public SkullBuilder setOwnerProfile(PlayerProfile profile) {
        this.skullMeta.setOwnerProfile(profile);
        return this;
    }

    public SkullBuilder setSkinFromURL(String url) {
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
        PlayerTextures textures = profile.getTextures();
        try {
            textures.setSkin(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        profile.setTextures(textures);
        return setOwnerProfile(profile);
    }
}
