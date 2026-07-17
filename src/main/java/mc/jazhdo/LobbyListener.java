package mc.jazhdo;


import org.bukkit.entity.Player;
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
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class LobbyListener implements Listener {
    public LobbyListener() {}

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockGrow(BlockGrowEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onEntityBlockForm(EntityBlockFormEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
    
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryInteract(InventoryInteractEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
        if (event.getWhoClicked() instanceof Player player) player.updateInventory();
    }
    
    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {
        if (!event.isCancelled()) event.setCancelled(true);
    }
}
