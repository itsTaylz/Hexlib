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

/**
 * An extension of the ItemBuilder used for making player heads, this class adds methods specific for players heads
 * like, for example, {@link #setOwningPlayer(OfflinePlayer)}
 */
public class SkullBuilder extends ItemMaker<SkullBuilder> {

    private final SkullMeta skullMeta;

    /**
     * Initializes a new skull builder, the item will be of type {@link Material}.PLAYER_HEAD and have quantity of 1
     */
    public SkullBuilder() {
        this(1);
    }

    /**
     * Initializes a new skull builder, with the specified amount
     */
    public SkullBuilder(int amount) {
        super(new ItemStack(Material.PLAYER_HEAD, amount));
        setChildInstance(this);
        this.skullMeta = (SkullMeta) getMeta();
    }

    /**
     * Changes the owning player of the head
     * @param owner The new owner of the player head
     * @return Self instance
     */
    public SkullBuilder setOwningPlayer(OfflinePlayer owner) {
        this.skullMeta.setOwningPlayer(owner);
        return this;
    }

    /**
     * Changes the player profile of the player head
     * @param profile The new player profile of the player head
     * @return Self instance
     */
    public SkullBuilder setOwnerProfile(PlayerProfile profile) {
        this.skullMeta.setOwnerProfile(profile);
        return this;
    }

    /**
     * Changes the skin of the player head to the one in the specified url
     * @param url The url for the skin
     * @return Self instance
     */
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
