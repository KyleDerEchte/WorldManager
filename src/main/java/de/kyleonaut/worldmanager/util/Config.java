package de.kyleonaut.worldmanager.util;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;


public class Config {

    private static final FileConfiguration cfg = getFileConfiguration();

    public static void setConfig() {

        cfg.options().copyDefaults(true);

        try {
            cfg.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile() {
        return new File("plugins/WorldManager", "worlds.yml");
    }

    private static FileConfiguration getFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public static void save() {
        try {
            cfg.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }

    public static void sendMessage(Player player,String messageKey){
        player.sendMessage(cfg.getString("Settings.Prefix")+cfg.getString(messageKey));
    }
}

