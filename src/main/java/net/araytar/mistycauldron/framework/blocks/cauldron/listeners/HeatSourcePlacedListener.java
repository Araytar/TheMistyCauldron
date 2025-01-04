package net.araytar.mistycauldron.framework.blocks.cauldron.listeners;

import net.araytar.mistycauldron.Config;
import net.araytar.mistycauldron.framework.blocks.cauldron.Cauldron;
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
        World world = block.getWorld();
        Location cauldronLocation = block.getLocation().clone().add(0,1,0);

        if (world.getBlockAt(cauldronLocation).getType() != Material.CAULDRON)  {
            return;
        }

        Cauldron cauldron = new Cauldron();
        cauldron.setId(cauldronLocation.toString());
        cauldron.setLocation(cauldronLocation);

        if (config.getHeatedMaterials().contains(block.getType())) {
            cauldron.setHeatLevel(config.getHeatedCauldronValue());
            cauldron.build();
        } else if (config.getSoulHeatedMaterials().contains(block.getType())) {
            cauldron.setHeatLevel(config.getSoulHeatedCauldronValue());
            cauldron.build();
        } else {
            cauldron.setHeatLevel(config.getColdCauldronValue());
            cauldron.build();
        }
    }
}
