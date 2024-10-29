package net.araytar.mistycauldron.framework.blocks.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.araytar.mistycauldron.framework.helper.TileEntityStorageHelper;
import net.araytar.mistycauldron.Config;

public class cauldronPlacedLogic implements Listener {
    private final Config config =  new Config();
    private final JavaPlugin pluginInstance;

    //Constructor
    public cauldronPlacedLogic(JavaPlugin pluginInstance) {
        this.pluginInstance = pluginInstance;

    }

    //edit the Config.java file to change the blocks used to heat cauldrons.
    @EventHandler
    public void onCauldronPlaced(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();
        World world = block.getWorld();

        if (block.getType() == Material.CAULDRON) {
            Location location = block.getLocation().clone().subtract(0,1,0);
            if (config.getHeatedMaterials().contains(world.getBlockAt(location).getType())) {
                TileEntityStorageHelper.setTileBlockData(block, config.getHeatLevelKey(), config.getHeatedCauldronValue(), this.pluginInstance);
            } else if (config.getSoulHeatedMaterials().contains(world.getBlockAt(location).getType())){
                TileEntityStorageHelper.setTileBlockData(block, config.getHeatLevelKey(), config.getSoulHeatedCauldronValue(), this.pluginInstance);
            } else {
                TileEntityStorageHelper.setTileBlockData(block, config.getHeatLevelKey(), config.getColdCauldronValue(), this.pluginInstance);
            }
        }
    }

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