package io.github.racoondog.seasonalmobs.util;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Item {
    public static void lore(ItemMeta meta, String msg) {
        Component text = Chat.lore(msg);
        ArrayList<Component> lore;
        if (meta.hasLore()) {
            lore = (ArrayList<Component>) meta.lore();
        } else {
            lore = new ArrayList<Component>();
        }
        assert lore != null;
        lore.add(text);
        meta.lore(lore);
    }
}
