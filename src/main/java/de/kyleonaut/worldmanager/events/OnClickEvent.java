package de.kyleonaut.worldmanager.events;

import de.kyleonaut.worldmanager.util.Config;
import de.kyleonaut.worldmanager.util.InventoryHolderClass;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class OnClickEvent implements Listener {

    public static HashMap<Player,WorldType> waitingForChatInput = new HashMap<>();

    @EventHandler
    public void onClickEvent(InventoryClickEvent e){
        String inventoryName = e.getInventory().getName();
        Player player = (Player) e.getWhoClicked();
        try {
            switch (inventoryName){
                case "World":
                    e.setCancelled(true);
                    if (e.getCurrentItem().getType().equals(Material.GRASS)){
                        InventoryHolderClass.openWorldsListGui(player);
                    }else if (e.getCurrentItem().getType().equals(Material.WOOD_AXE)){
                        InventoryHolderClass.openWorldSettings(player);

                    }
                    break;
                case "Select World Type":
                    e.setCancelled(true);
                    if (e.getSlot() == 4){
                        InventoryHolderClass.openMainGui(player);
                    }else {
                        switch (e.getSlot()){
                            case 0:
                                waitingForChatInput.put(player,WorldType.AMPLIFIED);
                                break;
                            case 1:
                                waitingForChatInput.put(player,WorldType.FLAT);
                                break;
                            case 2:
                                waitingForChatInput.put(player,WorldType.LARGE_BIOMES);
                                break;
                            case 3:
                                waitingForChatInput.put(player,WorldType.NORMAL);
                                break;
                        }
                        player.closeInventory();
                        sendMessage(player,"Please type the world name in the chat. Type exit to cancel this action.");
                    }
                    break;
                case "World List":
                    e.setCancelled(true);
                    if (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
                        InventoryHolderClass.openMainGui(player);
                    }else{
                        InventoryHolderClass.openWorldManagerGui(player,e.getCurrentItem().getItemMeta().getDisplayName().replace("§a",""));
                    }
                    break;

                case "World Manager":
                    e.setCancelled(true);
                    if (e.getCurrentItem().getType().equals(Material.ENDER_PEARL)){
                        World world = Bukkit.getWorld(e.getInventory().getItem(0).getItemMeta().getDisplayName().replace("§f",""));
                        player.teleport(world.getSpawnLocation());
                        Location loc = null;
                        while (!(player.getEyeLocation().getBlock().getType() == Material.AIR)){
                            loc = player.getLocation();
                            loc.setY(player.getLocation().getY()+1.0);
                            player.teleport(loc);
                        }
                    }else if (e.getCurrentItem().getType().equals(Material.BARRIER)){
                        InventoryHolderClass.openBestätigungsGui(player,e.getInventory().getItem(0).getItemMeta().getDisplayName().replace("§f",""));
                    }else if (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
                        InventoryHolderClass.openWorldsListGui(player);
                    }
                    break;

                case "World Delete":
                    e.setCancelled(true);
                    String worldName = e.getInventory().getItem(0).getItemMeta().getDisplayName().replace("§f","");
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Confirm")){
                        if (worldName.equals("world") || worldName.equals("world_nether") || worldName.equals("world_the_end")){
                            player.closeInventory();
                            sendMessage(player,"You must not delete this world.");
                        }else {
                            Bukkit.unloadWorld(worldName,false);
                            Bukkit.getWorlds().remove(Bukkit.getWorld(e.getInventory().getItem(0).getItemMeta().getDisplayName().replace("§f","")));
                            sendMessage(player,"The world was deleted.");
                            InventoryHolderClass.openWorldsListGui(player);
                            ArrayList<String> list = (ArrayList<String>) Config.getCfg().getList("worlds");
                            list.remove(worldName);
                            Config.getCfg().set("worlds",list);
                            Config.save();

                            deleteDir(new File(worldName));

                        }
                    }else {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Cancel")){
                            InventoryHolderClass.openWorldManagerGui(player,e.getInventory().getItem(0).getItemMeta().getDisplayName().replace("§f",""));
                        }
                    }
                    break;

                default:
                    break;

            }
        }catch (NullPointerException ignored){

        }

    }
    private void sendMessage(Player player,String message){
        player.sendMessage("§a[§2World-Manager§a] "+message);
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }
}
