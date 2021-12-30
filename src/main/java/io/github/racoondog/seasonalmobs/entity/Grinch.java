package io.github.racoondog.seasonalmobs.entity;

import io.github.racoondog.seasonalmobs.util.Chat;
import io.github.racoondog.seasonalmobs.util.Item;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Grinch {
    public static void spawn(Zombie entity) {
        entity.setInvisible(true);
        entity.setSilent(true);
        entity.addScoreboardTag("2021Grinch");

        entity.getEquipment().setBoots(boots());
        entity.getEquipment().setLeggings(leggings());
        entity.getEquipment().setChestplate(chestplate());
        entity.getEquipment().setHelmet(skull());

        entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_VINDICATOR_AMBIENT, 2, 0);
    }

    public static ItemStack boots() {
        final ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta leatherMeta = (LeatherArmorMeta) boots.getItemMeta();
        leatherMeta.setColor(Color.fromRGB(227, 0, 0));
        leatherMeta.displayName(Chat.christmas("Grinch's Feet"));
        Item.lore(leatherMeta, "Christmas 2021");
        boots.setItemMeta(leatherMeta);

        return boots;
    }

    public static ItemStack leggings() {
        final ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        final LeatherArmorMeta leatherMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leatherMeta.setColor(Color.fromRGB(0, 227, 0));
        leatherMeta.displayName(Chat.christmas("Grinch's Legs"));
        Item.lore(leatherMeta, "Christmas 2021");
        leggings.setItemMeta(leatherMeta);

        return leggings;
    }

    public static ItemStack chestplate() {
        final ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta leatherMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        leatherMeta.setColor(Color.fromRGB(227, 0, 0));
        leatherMeta.displayName(Chat.christmas("Grinch's Torso"));
        Item.lore(leatherMeta, "Christmas 2021");
        chestplate.setItemMeta(leatherMeta);

        return chestplate;
    }

    public static ItemStack skull() {
        final ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner("Checker62");
        skullMeta.displayName(Chat.christmas("Grinch's Head"));
        Item.lore(skullMeta, "Christmas 2021");
        skull.setItemMeta(skullMeta);

        return skull;
    }
}
