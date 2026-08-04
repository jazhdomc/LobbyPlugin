package mc.jazhdo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.chat.TextComponent;

public class LobbyPlugin extends JavaPlugin {
    private Logger log;
    private LobbyListener listener = null;

    private class Commands implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender == null) return false;
            if (sender instanceof Player player) {
                if (listener == null) {
                    player.spigot().sendMessage(TextComponent.fromLegacyText(ChatColor.RED + "The listener object is null. Please wait for it to load."));
                    return true;
                }
                switch (command.getName()) {
                    case "spawn" -> listener.spawn(player);
                    case "setspawn" -> listener.setSpawn(player.getLocation());
                }
            } else sender.sendMessage(ChatColor.RED + "You must be a player to run this command.");
            return true;
        }
    }

    @Override
    public void onEnable() {
        log = getLogger();
        log.log(Level.INFO, "Starting...");

        // Load config
        saveDefaultConfig();

        // Register events listener
        listener = new LobbyListener(this);
        getServer().getPluginManager().registerEvents(listener , this);

        // Register commands listener
        Commands commands = new Commands();
        getCommand("spawn").setExecutor(commands);
        getCommand("setspawn").setExecutor(commands);
    }

    @Override
    public void onDisable() {
        log.log(Level.INFO, "Shutting down...");

        // Save config just in case
        saveConfig();
    }
}