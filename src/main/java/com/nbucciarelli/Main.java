package com.nbucciarelli;

import com.nbucciarelli.commands.BetCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Hiro-plugin initialized! Enjoy it...");
        getServer().getPluginManager().registerEvents(new Events(),this);
        getCommand("bet").setExecutor(new BetCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting down hiro-plugin...");
    }
}
