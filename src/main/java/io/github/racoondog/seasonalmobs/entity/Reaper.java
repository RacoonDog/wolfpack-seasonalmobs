package io.github.racoondog.seasonalmobs.entity;

import io.github.racoondog.seasonalmobs.util.Chat;
import io.github.racoondog.seasonalmobs.util.Item;
import io.github.racoondog.seasonalmobs.util.Math;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Reaper {
    public static void spawn(Skeleton entity) {
        ItemStack chestplate = chestplate();
        ItemStack skull = skullRandom();
        ItemStack scythe = scythe();

        entity.setInvisible(true);
        entity.setSilent(true);
        entity.addScoreboardTag("2021Reaper");
        entity.getEquipment().setChestplate(chestplate);
        entity.getEquipment().setHelmet(skull);
        entity.getEquipment().setItemInMainHand(scythe);
        entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_WITHER_SKELETON_AMBIENT, 2, 0);
    }

    public static ItemStack chestplate() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setColor(Color.fromRGB(18, 18, 18));
        chestplateMeta.displayName(Chat.halloween("Reaper's Torso"));
        Item.lore(chestplateMeta, "Halloween 2021");
        chestplate.setItemMeta(chestplateMeta);

        return chestplate;
    }

    public static ItemStack skullRandom() {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        int random = Math.randomNumberInRange(1, 1000);
        if (random == 1) {
            skullMeta.setOwner("moricalliopeEN");
        } else {
            skullMeta.setOwner("Deathhhh");
        }
        skullMeta.displayName(Chat.halloween("Reaper's Head"));
        Item.lore(skullMeta, "Halloween 2021");
        skull.setItemMeta(skullMeta);

        return skull;
    }

    public static ItemStack skull() {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner("Deathhhh");
        meta.displayName(Chat.halloween("Reaper's Head"));
        Item.lore(meta, "Halloween 2021");
        skull.setItemMeta(meta);

        return skull;
    }

    public static ItemStack skullSecret() {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner("moricalliopeEN");
        meta.displayName(Chat.halloween("Reaper's Head"));
        Item.lore(meta, "Halloween 2021");
        skull.setItemMeta(meta);

        return skull;
    }

    public static ItemStack scythe() {
        ItemStack scythe = new ItemStack(Material.IRON_HOE);
        ItemMeta scytheMeta = scythe.getItemMeta();
        scytheMeta.displayName(Chat.halloween("Reaper's Scythe"));
        Item.lore(scytheMeta, "Halloween 2021");
        scythe.setItemMeta(scytheMeta);

        return scythe;
    }
}
