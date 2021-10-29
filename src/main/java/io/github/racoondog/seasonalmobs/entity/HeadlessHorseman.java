package io.github.racoondog.seasonalmobs.entity;

import io.github.racoondog.seasonalmobs.util.Chat;
import io.github.racoondog.seasonalmobs.util.Math;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class HeadlessHorseman {
    public static void spawn(EntitySpawnEvent event) {
        World world = event.getEntity().getWorld();
        Location location = event.getEntity().getLocation();

        event.setCancelled(true);

        Skeleton skeleton = (Skeleton) world.spawnEntity(location, EntityType.SKELETON);

        int random = Math.randomNumberInRange(1, 5);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.displayName(Chat.halloween("Horseman's Torso"));
        chestplate.setItemMeta(meta);

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        meta.displayName(Chat.halloween("Horseman's Legs"));
        leggings.setItemMeta(meta);

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        meta.displayName(Chat.halloween("Horseman's Feet"));
        boots.setItemMeta(meta);

        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.displayName(Chat.halloween("Horseman's Sword"));
        sword.setItemMeta(swordMeta);

        skeleton.setInvisible(true);
        skeleton.setSilent(true);
        skeleton.addScoreboardTag("2021Horseman");

        skeleton.getEquipment().setChestplate(chestplate);
        skeleton.getEquipment().setItemInMainHand(sword);
        skeleton.getEquipment().setLeggings(leggings);
        skeleton.getEquipment().setBoots(boots);

        if (random == 1) {
            skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.SKELETON_SKULL));
        } else {
            ZombieHorse horse = (ZombieHorse) world.spawnEntity(location, EntityType.ZOMBIE_HORSE);
            horse.addPassenger(skeleton);
        }
        world.playSound(location, Sound.ENTITY_SKELETON_AMBIENT, 2, 0);
        skeleton.getEquipment().setHelmet(new ItemStack(Material.AIR));
        skeleton.setFireTicks(-1);
        skeleton.setVisualFire(false);
    }
}
