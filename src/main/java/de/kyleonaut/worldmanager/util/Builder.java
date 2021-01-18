package de.kyleonaut.worldmanager.util;


import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Collections;

public class Builder {

    public enum Color{
        WHITE,
        ORANGE,
        MAGENTA,
        LIGHT_BLUE,
        YELLOW,
        LIME_GREEN,
        PINK,
        GRAY,
        LIGHT_GRAY,
        CYAN,
        PURPLE,
        BLUE,
        BROWN,
        GREEN,
        RED,
        BLACK
    }

    public ItemStack createItem(Material itemMaterial) {
        return new ItemStack(itemMaterial);
    }

    public ItemStack createItem(Material itemMaterial, String itemName) {
        ItemStack itemStack = new ItemStack(itemMaterial);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(itemName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createItem(Material itemMaterial, String itemName, int itemAmount) {
        ItemStack itemStack = new ItemStack(itemMaterial, itemAmount);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(itemName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createItem(Material itemMaterial, String itemName, int itemAmount, String itemLore) {
        ItemStack itemStack = new ItemStack(itemMaterial, itemAmount);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Collections.singletonList(itemLore));
        meta.setDisplayName(itemName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createItem(Material itemMaterial, String itemName, int itemAmount, ArrayList itemLore) {
        ItemStack itemStack = new ItemStack(itemMaterial, itemAmount);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(itemLore);
        meta.setDisplayName(itemName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createGlassPane(Color color, String itemName, int itemAmount, ArrayList itemLore) {
        Material itemMaterial = Material.STAINED_GLASS_PANE;
        ItemStack itemStack = null;
        switch (color){
            case WHITE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 0);
                break;
            case ORANGE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 1);
                break;
            case MAGENTA:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 2);
                break;
            case LIGHT_BLUE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 3);
                break;
            case YELLOW:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 4);
                break;
            case LIME_GREEN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 5);
                break;
            case PINK:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 6);
                break;
            case GRAY:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 7);
                break;
            case LIGHT_GRAY:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 8);
                break;
            case CYAN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 9);
                break;
            case PURPLE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 10);
                break;
            case BLUE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 11);
                break;
            case BROWN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 12);
                break;
            case GREEN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 13);
                break;
            case RED:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 14);
                break;
            case BLACK:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 15);
                break;
            default:
                itemStack = new ItemStack(itemMaterial, itemAmount);
        }

        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(itemLore);
        meta.setDisplayName(itemName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createGlassPane(Color color, String itemName, int itemAmount, String itemLore) {
        Material itemMaterial = Material.STAINED_GLASS_PANE;
        ItemStack itemStack = null;
        switch (color){
            case WHITE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 0);
                break;
            case ORANGE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 1);
                break;
            case MAGENTA:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 2);
                break;
            case LIGHT_BLUE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 3);
                break;
            case YELLOW:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 4);
                break;
            case LIME_GREEN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 5);
                break;
            case PINK:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 6);
                break;
            case GRAY:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 7);
                break;
            case LIGHT_GRAY:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 8);
                break;
            case CYAN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 9);
                break;
            case PURPLE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 10);
                break;
            case BLUE:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 11);
                break;
            case BROWN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 12);
                break;
            case GREEN:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 13);
                break;
            case RED:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 14);
                break;
            case BLACK:
                itemStack = new ItemStack(itemMaterial, itemAmount,(short) 15);
                break;
            default:
                itemStack = new ItemStack(itemMaterial, itemAmount);
        }
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Collections.singletonList(itemLore));
        meta.setDisplayName(itemName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createItem(Material itemMaterial, String itemName, int itemAmount, ArrayList itemLore, Enchantment enchantment, int enchantmentLevel, ItemFlag itemFlag) {
        ItemStack itemStack = new ItemStack(itemMaterial, itemAmount);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(itemLore);
        meta.setDisplayName(itemName);
        meta.addEnchant(enchantment, enchantmentLevel, false);
        meta.addItemFlags(new ItemFlag[]{itemFlag});
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack createHead(Player player) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(player.getName());
        skull.setItemMeta(meta);
        return skull;
    }

    public ItemStack createHead(Player player, String displayName) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(player.getName());
        meta.setDisplayName(displayName);
        skull.setItemMeta(meta);
        return skull;
    }

    public ItemStack createHead(String playerName, String displayName, ArrayList<String> lore) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(playerName);
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        skull.setItemMeta(meta);
        return skull;
    }

    public ItemStack createHead(String playerName, String displayName, String lore) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(playerName);
        meta.setDisplayName(displayName);
        ArrayList<String> lorE = new ArrayList<>();
        lorE.add(lore);
        meta.setLore(lorE);
        skull.setItemMeta(meta);
        return skull;
    }
}

