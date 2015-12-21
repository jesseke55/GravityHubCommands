package net.gravitynetwork.hubcommands;

import net.gravitynetwork.hub.JoinItems;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Main extends JavaPlugin {

    public void onEnable(){
        getCommand("clear").setExecutor(this);
        getCommand("reloadhub").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args){
        if(cmd.getName().equalsIgnoreCase("clear")){
            if(sender instanceof Player) {
                Player p = (Player) sender;
                new JoinItems().giveItems(p);
            }else{
                sender.sendMessage("You are not a player!");
            }
            if(cmd.getName().equalsIgnoreCase("reloadhub")){
                net.gravitynetwork.hub.Main.getPlugin().reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "The config has been reloaded!");
            }
        }

        return true;
    }
}
