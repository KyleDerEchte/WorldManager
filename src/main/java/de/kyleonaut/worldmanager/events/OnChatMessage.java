package de.kyleonaut.worldmanager.events;

import de.kyleonaut.worldmanager.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;


import java.util.ArrayList;


public class OnChatMessage implements Listener {

    @EventHandler
    public void onChatMessage(PlayerChatEvent e){
        if (OnClickEvent.waitingForChatInput.containsKey(e.getPlayer())){
            String msg = e.getMessage();
            e.setCancelled(true);
            if (msg.equalsIgnoreCase("exit") || msg.equalsIgnoreCase("close")){
                OnClickEvent.waitingForChatInput.remove(e.getPlayer());
            }else {
                Bukkit.createWorld(WorldCreator.name(msg).type(OnClickEvent.waitingForChatInput.get(e.getPlayer())).generateStructures(false));
                Bukkit.getWorld(msg).save();
                sendMessage(e.getPlayer(),"The world §2"+msg+" §awas created");
                OnClickEvent.waitingForChatInput.remove(e.getPlayer());
                ArrayList<String> list = (ArrayList<String>) Config.getCfg().getList("worlds");
                list.add(msg);
                Config.getCfg().set("worlds",list);
                Config.save();

            }
        }
    }

    private void sendMessage(Player player, String message){
        player.sendMessage("§a[§2World-Manager§a] "+message);
    }

}
