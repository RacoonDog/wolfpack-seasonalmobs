package io.github.racoondog.seasonalmobs.events;

import io.github.racoondog.seasonalmobs.SeasonalMobs;
import io.github.racoondog.seasonalmobs.entity.Ghost;
import io.github.racoondog.seasonalmobs.entity.HeadlessHorseman;
import io.github.racoondog.seasonalmobs.entity.Reaper;
import io.github.racoondog.seasonalmobs.util.Math;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
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
        Entity entity = event.getEntity();
        int random = Math.randomNumberInRange(1, 100);

        switch (entity.getType()) {
            case HORSE:
                if (random <= this.plugin.HorsemanSpawnChance) {
                    HeadlessHorseman.spawn(event);
                }
                break;
            case SKELETON:
                if (random <= this.plugin.ReaperSpawnChance) {
                    Reaper.spawn((Skeleton) entity);
                }
                break;
            case ZOMBIE:
                if (random <= this.plugin.GhostSpawnChance) {
                    Ghost.spawn((Zombie) entity);
                }
        }
    }
}
