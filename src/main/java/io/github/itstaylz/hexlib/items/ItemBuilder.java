package io.github.itstaylz.hexlib.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * A class to create or modify items
 */
public class ItemBuilder extends ItemMaker<ItemBuilder> {

    /**
     * Initializes an ItemBuilder with an itemstack of the specified material
     * @param material The material of the itemstack
     */
    public ItemBuilder(@NotNull Material material) {
        this(new ItemStack(material));
    }

    /**
     * Initializes an ItemBuilder with an itemstack of the specified material and amount
     * @param material The material of the itemstack
     * @param amount The amount of the itemstack
     */
    public ItemBuilder(@NotNull Material material, int amount) {
        this(new ItemStack(material, amount));
    }

    /**
     * Initializes an ItemBuilder with an itemstack
     * (Warning the itemstack is not cloned inside this method so any changes you do will affect the itemstack passed
     * in the constructor)
     * @param itemStack The itemstack to be changed
     */
    public ItemBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
        setChildInstance(this);
    }
}
