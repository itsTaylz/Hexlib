package io.github.itstaylz.hexlib.items;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class ItemMaker<T extends ItemMaker<T>> {

    private final ItemStack itemStack;
    private final ItemMeta meta;
    private T childInstance;

    public ItemMaker(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = this.itemStack.getItemMeta();
    }

    public T setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this.childInstance;
    }

    public T setCustomModelData(Integer data) {
        this.meta.setCustomModelData(data);
        return this.childInstance;
    }

    public T setDisplayName(String name) {
        this.meta.setDisplayName(name);
        return this.childInstance;
    }

    public T addEnchant(Enchantment enchant, int level) {
        this.meta.addEnchant(enchant, level, true);
        return this.childInstance;
    }

    public T addItemFlags(ItemFlag... flags) {
        this.meta.addItemFlags(flags);
        return this.childInstance;
    }

    public T removeEnchant(Enchantment enchant) {
        this.meta.removeEnchant(enchant);
        return this.childInstance;
    }

    public T setLore(List<String> lore) {
        this.meta.setLore(lore);
        return this.childInstance;
    }

    public T setLore(String... lore) {
        return setLore(Arrays.asList(lore));
    }

    public T addLore(String... lines) {
        List<String> lore;
        if (this.meta.hasLore())
            lore = this.meta.getLore();
        else
            lore = new ArrayList<>();
        Collections.addAll(lore, lines);
        return setLore(lore);
    }

    public T addAttribute(Attribute attribute, AttributeModifier modifier) {
        this.meta.addAttributeModifier(attribute, modifier);
        return this.childInstance;
    }

    public T setUnbreakable(boolean unbreakable) {
        this.meta.setUnbreakable(unbreakable);
        return this.childInstance;
    }

    protected void setChildInstance(T instance) {
        this.childInstance = instance;
    }

    protected ItemMeta getMeta() {
        return meta;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.meta);
        return this.itemStack;
    }
}
