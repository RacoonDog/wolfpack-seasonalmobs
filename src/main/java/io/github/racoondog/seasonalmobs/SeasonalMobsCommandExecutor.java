package io.github.racoondog.seasonalmobs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SeasonalMobsCommandExecutor implements CommandExecutor {
    private final SeasonalMobs plugin;

    public SeasonalMobsCommandExecutor(SeasonalMobs plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return false;
    }
}
