package io.github.racoondog.seasonalmobs.entity;

import io.github.racoondog.seasonalmobs.util.Chat;
import io.github.racoondog.seasonalmobs.util.Item;
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

        setup(skeleton);
    }

    public static void setup(Skeleton entity) {
        World world = entity.getWorld();
        Location location = entity.getLocation();

        int random = Math.randomNumberInRange(1, 5);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.displayName(Chat.halloween("Horseman's Torso"));
        Item.lore(meta, "Halloween 2021");
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
        Item.lore(swordMeta, "Halloween 2021");
        sword.setItemMeta(swordMeta);

        entity.setInvisible(true);
        entity.setSilent(true);
        entity.addScoreboardTag("2021Horseman");

        entity.getEquipment().setChestplate(chestplate);
        entity.getEquipment().setItemInMainHand(sword);
        entity.getEquipment().setLeggings(leggings);
        entity.getEquipment().setBoots(boots);

        if (random == 1) {
            entity.getEquipment().setItemInMainHand(new ItemStack(Material.SKELETON_SKULL));
        } else {
            ZombieHorse horse = (ZombieHorse) world.spawnEntity(location, EntityType.ZOMBIE_HORSE);
            horse.addPassenger(entity);
        }
        world.playSound(location, Sound.ENTITY_SKELETON_AMBIENT, 2, 0);
        entity.getEquipment().setHelmet(new ItemStack(Material.AIR));
        entity.setFireTicks(-1);
        entity.setVisualFire(false);
    }
}
