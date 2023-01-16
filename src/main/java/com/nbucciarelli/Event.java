package com.nbucciarelli;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {

    @EventHandler
    public void helloPlayer(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String name = p.getName();

    }
}
