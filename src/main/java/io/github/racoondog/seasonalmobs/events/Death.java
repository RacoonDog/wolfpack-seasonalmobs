package io.github.racoondog.seasonalmobs.events;

import io.github.racoondog.seasonalmobs.SeasonalMobs;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Death implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Location loc = entity.getLocation();
        World world = entity.getWorld();
        EntityType type = entity.getType();
        switch (type) {
            case ZOMBIE:
                if(entity.getScoreboardTags().contains("2021Ghost")) {
                    world.playSound(loc, Sound.ENTITY_ELDER_GUARDIAN_DEATH, 1, 0);
                }
                break;
            case SKELETON:
                if(entity.getScoreboardTags().contains("2021Reaper")) {
                    world.playSound(loc, Sound.ENTITY_WITHER_SKELETON_DEATH, 1, 0);
                } else if(entity.getScoreboardTags().contains("2021Horseman")) {
                    world.playSound(loc, Sound.ENTITY_SKELETON_DEATH, 1, 0);
                }
        }
    }
}
