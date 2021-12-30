package io.github.racoondog.seasonalmobs.events;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Death implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        final Entity entity = event.getEntity();
        if (entity.getType() == EntityType.ZOMBIE) {
            if (entity.getScoreboardTags().contains("2021Grinch")) {
                entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_VINDICATOR_DEATH, 1, 0);
            }
        }
    }
}
