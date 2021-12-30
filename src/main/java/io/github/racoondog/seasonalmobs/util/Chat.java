package io.github.racoondog.seasonalmobs.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public final class Chat {
    public static Component halloween(String msg) {
        return Component.text(msg).color(NamedTextColor.GOLD).decoration(TextDecoration.UNDERLINED, true);
    }
    public static Component christmas(String msg) {
        return Component.text(msg).color(NamedTextColor.RED).decoration(TextDecoration.UNDERLINED, true);
    }
    public static Component lore(String msg) {
        return Component.text(msg).color(NamedTextColor.DARK_GRAY).decoration(TextDecoration.ITALIC, true);
    }
}
