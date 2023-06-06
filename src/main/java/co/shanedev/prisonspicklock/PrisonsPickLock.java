package co.shanedev.prisonspicklock;

import co.shanedev.prisonspicklock.commands.PPLCommand;
import co.shanedev.prisonspicklock.commands.ReloadCommand;
import co.shanedev.prisonspicklock.events.DeathEvent;
import co.shanedev.prisonspicklock.events.PickLock;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrisonsPickLock extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        config.setup();
        config.get().addDefault("Prefix", "&f&lPrisonsPickLock &8&l» ");
        config.get().addDefault("LockMessage", "&cYou cannot interact your pickaxe&8.");
        config.get().options().copyDefaults(true);
        config.save();


        getCommand("pplreload").setExecutor(new ReloadCommand());
        getCommand("ppl").setExecutor(new PPLCommand());
        getServer().getPluginManager().registerEvents(new PickLock(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getConsoleSender().sendMessage("§aTnitializing PPL.");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "==================================================");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage("§cPlugin: §7PrisonsPickLock");
        getServer().getConsoleSender().sendMessage("§cAuthor: §7ShaneDev");
        getServer().getConsoleSender().sendMessage("§cVersion: §72.0");
        getServer().getConsoleSender().sendMessage("§cSupport Discord: §7https://discord.gg/RC82gb2g2u");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "==================================================");


    }

    @Override
    public void onDisable(){ getServer().getConsoleSender().sendMessage(ChatColor.RED + "[PPL]: Disabled"); }
}
