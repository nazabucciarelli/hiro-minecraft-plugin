package com.nbucciarelli;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class Events implements Listener {

    @EventHandler
    public void helloPlayer(PlayerJoinEvent e){
        String[] greetings = {", coautor del atentado a Paunero 660, entró al servidor.",", el del buzo verde, entró al " +
                "servidor.",", novio de la Chunilda, entró al servidor.",", primohermano del gordo pantufla, entró " +
                "al servidor.",", el evasor de impuestos, entró al servidor.",", nieto de Natalia Natalia, entró al servidor.",
        ", hater de la vida, entró al servidor.",", Licenciado en Casi Todo, entró al servidor."};
        Player p = e.getPlayer();
        String name = p.getName();
        Random ran = new Random();
        int randInt = ran.nextInt(8) + 1;
        e.setJoinMessage(ChatColor.GREEN + name + ChatColor.RED + greetings[randInt - 1]);
    }
}
