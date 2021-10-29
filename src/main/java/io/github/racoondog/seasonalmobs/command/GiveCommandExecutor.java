package io.github.racoondog.seasonalmobs.command;

import io.github.racoondog.seasonalmobs.SeasonalMobs;
import io.github.racoondog.seasonalmobs.entity.Ghost;
import io.github.racoondog.seasonalmobs.entity.HeadlessHorseman;
import io.github.racoondog.seasonalmobs.entity.Reaper;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class GiveCommandExecutor implements CommandExecutor {
    private final SeasonalMobs plugin;

    public GiveCommandExecutor(SeasonalMobs plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("seasonalmobs.giveseasonal") || sender.hasPermission("seasonalmobs.*")) {
            Player receiver = null;

            if (args.length > 0) {
                String arg1 = args[0];
                String item = null;
                int count = 1;
                if (Bukkit.getPlayer(arg1) != null && sender.hasPermission("seasonalmobs.giveseasonal.others")) {
                    receiver = Bukkit.getPlayer(arg1);
                    if (args.length > 1) {
                        item = args[1];
                        if (args.length > 2) {
                            count = Integer.parseInt(args[2]);
                        }
                    } else {
                        sender.sendMessage("Not enough arguments");
                        return false;
                    }
                } else {
                    if (sender instanceof Player) {
                        receiver = (Player) sender;
                        item = arg1;
                        if (args.length > 1) {
                            count = Integer.parseInt(args[1]);
                        }
                    } else {
                        sender.sendMessage("You need to be a player or target a player");
                        return false;
                    }
                }
                ItemStack itemStack = null;
                switch (item) {
                    case "reaper_skull":
                        itemStack = Reaper.skull();
                        break;
                    case "reaper_skull_secret":
                        itemStack = Reaper.skullSecret();
                        break;
                    case "reaper_chestplate":
                        itemStack = Reaper.chestplate();
                        break;
                    case "reaper_scythe":
                        itemStack = Reaper.scythe();
                        break;
                    case "ghost_chestplate":
                        itemStack = Ghost.chestplate();
                        break;
                    case "ghost_skull":
                        itemStack = Ghost.skull();
                        break;
                    case "horseman_chestplate":
                        itemStack = HeadlessHorseman.chestplate();
                        break;
                    case "horseman_leggings":
                        itemStack = HeadlessHorseman.leggings();
                        break;
                    case "horseman_boots":
                        itemStack = HeadlessHorseman.boots();
                        break;
                    case "horseman_sword":
                        itemStack = HeadlessHorseman.sword();
                        break;
                    default:
                        sender.sendMessage("Not a valid item");
                        return false;
                }
                Inventory inventory = receiver.getInventory();
                for (int i = 0; i < count; i++) {
                    inventory.setItem(inventory.firstEmpty(), itemStack);
                }
            } else {
                sender.sendMessage("Not enough arguments");
                return false;
            }
        }
        return true;
    }
}
