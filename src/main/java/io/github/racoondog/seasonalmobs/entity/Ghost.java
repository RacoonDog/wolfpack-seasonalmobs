package io.github.racoondog.seasonalmobs.entity;

import io.github.racoondog.seasonalmobs.util.Chat;
import org.bukkit.*;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Ghost {
    public static void spawn(Zombie entity) {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta leatherMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        leatherMeta.setColor(Color.fromRGB(227, 227, 227));
        leatherMeta.displayName(Chat.halloween("Ghost's Torso"));
        chestplate.setItemMeta(leatherMeta);

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner("LattyGhost");
        skullMeta.displayName(Chat.halloween("Ghost's Head"));
        skull.setItemMeta(skullMeta);

        entity.setInvisible(true);
        entity.setSilent(true);
        entity.addScoreboardTag("2021Ghost");

        entity.getEquipment().setChestplate(chestplate);
        entity.getEquipment().setHelmet(skull);

        World world = entity.getWorld();
        Location location = entity.getLocation();
        if(!entity.isAdult()) {
            world.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_HURT, 2, 1);
        } else {
            world.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_HURT, 2, 0);
        }
    }
}
