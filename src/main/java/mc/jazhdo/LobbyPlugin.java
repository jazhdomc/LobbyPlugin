package mc.jazhdo;

import org.bukkit.plugin.java.JavaPlugin;

public class LobbyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        LobbyListener listener = new LobbyListener();
        getServer().getPluginManager().registerEvents(listener , this);
        getLogger().info("Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }
}