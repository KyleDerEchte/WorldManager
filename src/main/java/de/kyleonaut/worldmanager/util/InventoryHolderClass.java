package de.kyleonaut.worldmanager.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.ArrayList;

public class InventoryHolderClass {

    public static void openMainGui(Player player){
        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER,"World");
        ItemStack item = new ItemStack(Material.GRASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aDisplay all worlds");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§2Click to display all worlds");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inventory.setItem(1,item);

        ItemStack item2 = new ItemStack(Material.WOOD_AXE);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§aCreate a new world");
        lore.clear();
        lore.add("§2Click to create a new world.");
        meta2.setLore(lore);
        item2.setItemMeta(meta2);
        inventory.setItem(3,item2);

        player.openInventory(inventory);
    }

    public static void openWorldsListGui(Player player){
        Inventory inventory = Bukkit.createInventory(null,9*6,"World List");
        ArrayList<String> lore = new ArrayList<>();
        Builder builder = new Builder();
        for (World world : Bukkit.getWorlds()){
            ItemStack witem = new ItemStack(Material.GRASS);
            ItemMeta wmeta = witem.getItemMeta();
            wmeta.setDisplayName("§a"+world.getName());
            lore.clear();
            lore.add("§2Players online: "+world.getPlayers().size());
            wmeta.setLore(lore);
            witem.setItemMeta(wmeta);
            try {
                inventory.addItem(witem);
            }catch (Exception e){

            }
        }
        inventory.setItem(53,builder.createGlassPane(Builder.Color.RED,"§2Close",1,"§aClose the worlds overview"));
        player.openInventory(inventory);
    }

    public static void openWorldManagerGui(Player player, String worldName){
        Inventory inventory = Bukkit.createInventory(null,3*9,"World Manager");
        Builder builder = new Builder();
        inventory.setItem(0,builder.createGlassPane(Builder.Color.LIGHT_GRAY,"§f"+worldName,1,""));
        inventory.setItem(12,builder.createItem(Material.ENDER_PEARL,"§2Teleport to this world",1,"§aClick to teleport to this world."));
        inventory.setItem(14,builder.createItem(Material.BARRIER,"§2Delete this world",1,"§aClick to delete this world."));
        inventory.setItem(26,builder.createGlassPane(Builder.Color.RED,"§2Close",1,"§aClose the WorldManager."));
        player.openInventory(inventory);
    }

    public static void openBestätigungsGui(Player player,String worldName){
        Inventory inventory = Bukkit.createInventory(null,9,"World Delete");
        Builder builder = new Builder();
        inventory.setItem(0,builder.createGlassPane(Builder.Color.LIGHT_GRAY,"§f"+worldName,1,""));
        inventory.setItem(3,builder.createGlassPane(Builder.Color.GREEN,"§2Confirm",1,"§aClick to delete this world."));
        inventory.setItem(5,builder.createGlassPane(Builder.Color.RED,"§2Cancel",1,"§aClick to cancel."));
        player.openInventory(inventory);
    }

    public static void openWorldSettings(Player player){
        Inventory inventory = Bukkit.createInventory(null,InventoryType.HOPPER,"Select World Type");
        Builder builder = new Builder();
        inventory.addItem(builder.createGlassPane(Builder.Color.LIME_GREEN,"§2Amplified",1,""));
        inventory.addItem(builder.createGlassPane(Builder.Color.BLUE,"§2Flat",1,""));
        inventory.addItem(builder.createGlassPane(Builder.Color.MAGENTA,"§2Large Bioms",1,""));
        inventory.addItem(builder.createGlassPane(Builder.Color.YELLOW,"§2Normal",1,""));
        inventory.addItem(builder.createGlassPane(Builder.Color.RED,"§2Cancel",1,"§aClick to cancel."));

        player.openInventory(inventory);

    }
}
