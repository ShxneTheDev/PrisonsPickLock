package co.shanedev.prisonspicklock.commands;

import co.shanedev.prisonspicklock.config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("pplreload")) {
            Player player = (Player) sender;
            if (player.hasPermission("ppl.reload")) {

            config.reload();
            player.sendMessage(config.get().getString("Prefix").replaceAll("&", "§") + "§cConfig Reloaded§8.");

        } else {
                player.sendMessage(config.get().getString("Prefix").replaceAll("&", "§") + "§cYou do not have access to that command.");
            }
        }
        return true;
    }
}
