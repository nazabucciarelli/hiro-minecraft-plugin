package com.nbucciarelli.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("bet")){
            Random ran = new Random();
            int randInt = ran.nextInt(100) + 1;

            ItemStack item = p.getInventory().getItemInMainHand();
            int quantity = item.getAmount();
            String materialName = item.getType().name().toLowerCase();
            String[] splittedMaterialName = materialName.split("_");
            String aestheticName = "";
            for(String word: splittedMaterialName){
                char[] wordCharArr = word.toCharArray();
                for(int i = 0; i < wordCharArr.length; i++){
                    if( i == 0){
                        aestheticName = aestheticName.concat(String.valueOf(wordCharArr[i]).toUpperCase());
                    } else{
                        aestheticName = aestheticName.concat(String.valueOf(wordCharArr[i]));
                    }
                }
                aestheticName = aestheticName.concat(" ");
            }

            if(randInt > 35){
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE+ " apostó " + ChatColor.AQUA
                        + quantity + " " + aestheticName + ChatColor.WHITE +"y, ¡ganó el doble!");
                p.getInventory().getItemInMainHand().setAmount(quantity * 2);
            } else{
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE+ " apostó " + ChatColor.AQUA
                        + quantity + " " + aestheticName + ChatColor.WHITE +"y perdió todo...");
                p.getInventory().remove(item);
            }
        }
        return true;
    }
}
