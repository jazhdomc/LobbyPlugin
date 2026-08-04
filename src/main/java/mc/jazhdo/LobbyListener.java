package mc.jazhdo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import net.md_5.bungee.api.chat.TextComponent;

public class LobbyListener implements Listener {
    private Location spawnLoc = null;
    private FileConfiguration config;

    public LobbyListener(LobbyPlugin plugin) {
        config = plugin.getConfig();
        spawnLoc = new Location(Bukkit.getWorld(config.getString("world")), config.getDouble("x"), config.getDouble("y"), config.getDouble("z"), (float) config.getDouble("yaw"), (float) config.getDouble("pitch"));
    }

    private void cancel(Cancellable event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    private boolean check(Player player, Cancellable event) {
        if (!player.hasPermission("lobby.change")) {
            cancel(event);
            return false;
        }
        return true;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        check(event.getPlayer(), event);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        check(event.getPlayer(), event);
    }
    
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockGrow(BlockGrowEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {
        check(event.getPlayer(), event);
    }
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        check(event.getPlayer(), event);
    }
    
    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        cancel(event);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onEntityBlockForm(EntityBlockFormEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        cancel(event);
    }
    
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        check((Player) event.getPlayer(), event);
    }

    @EventHandler
    public void onInventoryInteract(InventoryInteractEvent event) {
        if (event.getWhoClicked() instanceof Player player && !check(player, event)) player.updateInventory();
    }
    
    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        check((Player) event.getSource().getHolder(), event);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        cancel(event);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        check(event.getPlayer(), event);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        check(event.getPlayer(), event);
    }

    @EventHandler
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (event.getAttacker() instanceof Player player) check(player, event);
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {
        if (event.getAttacker() instanceof Player player) check(player, event);
    }

    public void spawn(Player player) {
        player.spigot().sendMessage(TextComponent.fromLegacyText(ChatColor.YELLOW + "Teleporting you to spawn..."));
        player.teleport(spawnLoc);
    }

    public void setSpawn(Location loc) {
        spawnLoc = loc;
        config.set("world", loc.getWorld().getName());
        config.set("x", loc.getX());
        config.set("y", loc.getY());
        config.set("z", loc.getZ());
        config.set("yaw", loc.getYaw());
        config.set("pitch", loc.getPitch());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        if (spawnLoc != null) player.teleport(spawnLoc);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if (spawnLoc != null) event.setRespawnLocation(spawnLoc);
    }
}
