package io.github.itstaylz.hexlib.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder extends ItemMaker<ItemBuilder> {

    public ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    public ItemBuilder(Material material, int amount) {
        this(new ItemStack(material, amount));
    }

    public ItemBuilder(ItemStack itemStack) {
        super(itemStack);
        setChildInstance(this);
    }
}
