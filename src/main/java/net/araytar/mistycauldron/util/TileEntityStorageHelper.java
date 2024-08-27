package net.araytar.mistycauldron.util;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class TileEntityStorageHelper {
    //CustomTileBlockData manager methods -> All static :3

    public static void setTileBlockData(Block block, String key, String data, JavaPlugin pluginInstance) {
        if (block.getState() instanceof TileState) {
            TileState tileState = (TileState) block.getState();
            PersistentDataContainer container = tileState.getPersistentDataContainer();
            container.set(new NamespacedKey(pluginInstance, key), PersistentDataType.STRING, data);
            tileState.update();
        }
    }

    public static String getTileBlockData(Block block, String key, JavaPlugin pluginInstance) {
        if (block.getState() instanceof  TileState) {
            TileState tileState = (TileState) block.getState();
            PersistentDataContainer container = tileState.getPersistentDataContainer();
            return container.get(new NamespacedKey(pluginInstance, key), PersistentDataType.STRING);
        } else {
            return null;
        }
    }

    public static void removeTileBlockData(Block block, String key, JavaPlugin pluginInstance) {
        if (block.getState() instanceof TileState) {
            TileState tileState = (TileState) block.getState();
            PersistentDataContainer container = tileState.getPersistentDataContainer();
            container.remove(new NamespacedKey(pluginInstance, key));
        }
    }
}
