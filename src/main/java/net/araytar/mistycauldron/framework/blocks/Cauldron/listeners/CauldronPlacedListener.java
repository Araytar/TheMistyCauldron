package net.araytar.mistycauldron.framework.blocks.Cauldron.listeners;

import net.araytar.mistycauldron.framework.blocks.Cauldron.Cauldron;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.araytar.mistycauldron.Config;

public class CauldronPlacedListener implements Listener {
    private final Config config =  new Config();

    //edit the Config.java file to change the blocks used to heat cauldrons.
    @EventHandler
    public void onCauldronPlaced(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();
        Block heatSource = event.getBlockPlaced().getLocation().clone().subtract(0, -1, 0).clone().getBlock();
        Material heatSourceMaterial = heatSource.getType();
        World world = block.getWorld();

        Cauldron cauldron = new Cauldron();
        cauldron.setId(block.getLocation().clone().toString());
        cauldron.setLocation(block.getLocation().clone());
        if (config.getHeatedMaterials().contains(heatSourceMaterial)) {
            cauldron.setHeatLevel(config.getHeatedCauldronValue());
        } else if (config.getSoulHeatedMaterials().contains(heatSourceMaterial)) {
            cauldron.setHeatLevel(config.getSoulHeatedCauldronValue());
        } else {
            cauldron.setHeatLevel(config.getColdCauldronValue());
        }
        cauldron.build();
    }
}