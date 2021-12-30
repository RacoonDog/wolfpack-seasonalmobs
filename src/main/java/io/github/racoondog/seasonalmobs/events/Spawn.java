package io.github.racoondog.seasonalmobs.events;

import io.github.racoondog.seasonalmobs.SeasonalMobs;
import io.github.racoondog.seasonalmobs.entity.Grinch;
import io.github.racoondog.seasonalmobs.util.Math;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Spawn implements Listener {
    private final SeasonalMobs plugin;

    public Spawn(SeasonalMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        final Entity entity = event.getEntity();
        if (entity.getType() == EntityType.ZOMBIE) {
            int random = Math.randomNumberInRange(1, 100);
            if (random <= this.plugin.GrinchSpawnChance) {
                Grinch.spawn((Zombie) entity);
            }
        }
    }
}
