package de.kyleonaut.worldmanager;

import de.kyleonaut.worldmanager.commands.WorldCommand;
import de.kyleonaut.worldmanager.events.OnChatMessage;
import de.kyleonaut.worldmanager.events.OnClickEvent;
import de.kyleonaut.worldmanager.util.Config;
import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Worldmanager extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("world").setExecutor(new WorldCommand());

        Bukkit.getPluginManager().registerEvents(new OnClickEvent(),this);
        Bukkit.getPluginManager().registerEvents(new OnChatMessage(),this);
        Config.setConfig();
        System.out.println(ChatColor.GREEN+"Loading worlds.");
        for (Object worldname : (List<?>) Config.getCfg().get("worlds")){
            getServer().createWorld(new WorldCreator((String) worldname));
        }


        System.out.println(ChatColor.GREEN+"All worlds have been loaded.");
    }
}
