package net.araytar.mistycauldron.framework.blocks.Cauldron.listeners;

import net.araytar.mistycauldron.Config;
import net.araytar.mistycauldron.framework.helper.TileEntityStorageHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class HeatSourcePlacedListener implements Listener {
    Config config = new Config();

    @EventHandler
    public void onHeatSourcePlaced(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();

        if (config.getHeatedMaterials().contains(block.getType())) {
            World world = block.getWorld();
            Location location = block.getLocation().clone().add(0,1,0);
            if (world.getBlockAt(location).getType() == Material.CAULDRON) {
                Block cauldronBlock = world.getBlockAt(location);
                TileEntityStorageHelper.setTileBlockData(cauldronBlock, config.getHeatLevelKey(), config.getHeatLevelKey(), this.pluginInstance);
            }

        } else if (config.getSoulHeatedMaterials().contains(block.getType())) {
            World world = block.getWorld();
            Location location = block.getLocation().clone().add(0,1,0);
            if (world.getBlockAt(location).getType() == Material.CAULDRON) {
                Block caudronBlock = world.getBlockAt(location);
                TileEntityStorageHelper.setTileBlockData(caudronBlock, config.getHeatLevelKey(), config.getSoulHeatedCauldronValue(), this.pluginInstance);
            }
        }
    }
}
