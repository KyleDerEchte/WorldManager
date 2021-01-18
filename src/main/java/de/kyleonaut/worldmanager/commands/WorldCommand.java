package de.kyleonaut.worldmanager.commands;

import de.kyleonaut.worldmanager.util.InventoryHolderClass;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("worldmanager.world")){
                InventoryHolderClass.openMainGui(player);
            }else{
                sendMessage(player,"§cYou have no permissions to execute this command!");
            }
        }
        return false;
    }

    private void sendMessage(Player player,String message){
        player.sendMessage("§a[§2World-Manager§a] "+message);
    }
}
