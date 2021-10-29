package io.github.racoondog.seasonalmobs;

import io.github.racoondog.seasonalmobs.events.Damage;
import io.github.racoondog.seasonalmobs.events.Death;
import io.github.racoondog.seasonalmobs.events.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class SeasonalMobs extends JavaPlugin {
    public final String pluginVer = this.getDescription().getVersion();
    public final String system = Bukkit.getServer().getName();
    public final String author = "Crosby";

    @Override
    public void onEnable() {
        createFiles();
        Bukkit.getServer().getPluginManager().registerEvents(new Damage(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Death(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Spawn(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public final int GhostSpawnChance = getConfig().getInt("Ghost Spawn Chance");
    public final int ReaperSpawnChance = getConfig().getInt("Reaper Spawn Chance");
    public final int HorsemanSpawnChance = getConfig().getInt("Headless Horseman Spawn Chance");

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void createFiles() {
        String configPath = "config.yml";
        FileConfiguration config = new YamlConfiguration();
        File configFile = new File(getDataFolder(), configPath);

        if (!(configFile.exists())) {
            configFile.getParentFile().mkdir();
            saveResource(configPath, false);
        }
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
