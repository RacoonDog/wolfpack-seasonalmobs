package io.github.racoondog.seasonalmobs;

import io.github.racoondog.seasonalmobs.events.Damage;
import io.github.racoondog.seasonalmobs.events.Death;
import io.github.racoondog.seasonalmobs.events.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SeasonalMobs extends JavaPlugin {
    public final String pluginVer = this.getDescription().getVersion();
    public final String system = Bukkit.getServer().getName();
    public final String author = "Crosby";

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new Damage(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Death(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Spawn(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public final int GrinchSpawnChance = 50;
}
