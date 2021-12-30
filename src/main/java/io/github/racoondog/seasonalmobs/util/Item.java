package io.github.racoondog.seasonalmobs.util;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public final class Item {
    public static void lore(ItemMeta meta, String msg) {
        final Component text = Chat.lore(msg);
        ArrayList<Component> lore;
        if (meta.hasLore()) {
            lore = (ArrayList<Component>) meta.lore();
            if (lore == null) lore = new ArrayList<>();
        } else {
            lore = new ArrayList<>();
        }
        lore.add(text);
        meta.lore(lore);
    }
}
