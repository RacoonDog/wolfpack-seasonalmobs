package io.github.racoondog.seasonalmobs.events;

import io.github.racoondog.seasonalmobs.SeasonalMobs;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        Location location = entity.getLocation();
        World world = entity.getWorld();
        switch (entity.getType()) {
            case SKELETON:
                if(entity.getScoreboardTags().contains("2021Reaper")) {
                    world.playSound(location, Sound.ENTITY_WITHER_SKELETON_HURT, 1, 0);
                } else if (entity.getScoreboardTags().contains("2021Horseman")) {
                    if(event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                        event.setCancelled(true);
                        entity.setVisualFire(false);
                        entity.setFireTicks(-1);
                    } else {
                        world.playSound(location, Sound.ENTITY_SKELETON_HURT, 1, 0);
                    }
                }
                break;
            case ZOMBIE:
                if(entity.getScoreboardTags().contains("2021Ghost")) {
                    world.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_HURT, 1, 0);
                }
        }
    }
}
