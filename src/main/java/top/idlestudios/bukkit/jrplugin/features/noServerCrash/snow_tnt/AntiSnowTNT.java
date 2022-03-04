package top.idlestudios.bukkit.jrplugin.features.noServerCrash.snow_tnt;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import top.idlestudios.bukkit.jrplugin.features.ModuleManager;

public class AntiSnowTNT implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        if (ModuleManager.AntiSnowTNTEnabled)
        {

            Player player = e.getPlayer();
            Action action = e.getAction();
            ItemStack item = e.getItem();
            Block block = e.getClickedBlock();

            // Right click only
            if (action != Action.RIGHT_CLICK_BLOCK || block.getType() != Material.TNT)
            {
                return;
            }

            // Flint and steel only
            assert item != null;
            if (item.getType() != Material.FLINT_AND_STEEL)
            {
                return;
            }

            Location location = block.getLocation();
            int vl = 0;

            // Block X1
            Location location_X1 = location.add(1, 0, 0);
            Block block_X1 = location_X1.getBlock();
            // Block Z1
            Location location_Z1 = location.add(0, 0, 1);
            Block block_Z1 = location_Z1.getBlock();
            // Block 1X
            Location location_1X = location.add(-1, 0, 0);
            Block block_1X = location_1X.getBlock();
            // Block 1Z
            Location location_1Z = location.add(0, 0, -1);
            Block block_1Z = location_1Z.getBlock();
            // Detect 1
            if (block_1Z.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (block_1X.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (block_Z1.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (block_X1.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (vl >= 2)
            {
                System.out.println("Player \"" + player.getDisplayName() + "\" is suspected of using TNT and snow block to crash the server.");
                try {
                    e.setCancelled(true);
                    System.out.println("Cancelled PlayerInteractEvent: " + e.getEventName());
                    player.sendMessage(ChatColor.RED + "DO NOT TRY TO CRASH THE SERVER");
                    player.sendMessage(ChatColor.RED + "Event cancelled for security, by JrPlugin.");
                } catch (Exception ex) {
                    System.out.println("Unable to cancel PlayerInteractEvent: " + e.getEventName());
                    System.out.println("Caused by: " + ex.getCause());
                }
            }

            // Block X1Z1
            Location location_X1Z1 = location.add(1, 0, 1);
            Block block_X1Z1 = location_X1Z1.getBlock();
            // Block 1Z1X
            Location location_1Z1X = location.add(-1, 0, -1);
            Block block_1Z1X = location_1Z1X.getBlock();
            // Block 1ZX1
            Location location_1ZX1 = location.add(1, 0, -1);
            Block block_1ZX1 = location_1ZX1.getBlock();
            // Block Z11X
            Location location_Z11X = location.add(1, 0, -1);
            Block block_Z11X = location_Z11X.getBlock();
            // Detect 2
            if (block_1ZX1.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (block_X1Z1.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (block_Z11X.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (block_1Z1X.getType() == Material.SNOW_BLOCK)
            {
                vl += 1;
            }
            if (vl >= 6)
            {
                System.out.println("Player \"" + player.getDisplayName() + "\" is trying to crash the server.");
                System.out.println("Trying to cancel event and kick player.");
                try
                {
                    e.setCancelled(true);
                    player.kickPlayer(ChatColor.RED + "KICKED OF TRYING TO CRASH THE SERVER");
                } catch (Exception ex) {
                    System.out.println("Unable to process this event.");
                    System.out.println("Caused by: " + ex.getCause());
                }
            }
        }
    }
}
