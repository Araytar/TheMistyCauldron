package net.araytar.mistycauldron.framework.crafting.cauldron.listeners;

import net.araytar.mistycauldron.Mistycauldron;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDroppedListener implements Listener {
    @EventHandler
    public void onItemDropped(PlayerDropItemEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        Item item = event.getItemDrop();

        //await the item to land until the detection starts.
        while (!item.isOnGround()) {Thread.sleep(250);}
        Location location = item.getLocation();

        if (Mistycauldron.cauldronRegister.hasKey(location.toString())) {
            Mistycauldron.cauldronRegister.get(location.toString());
        }
    }
}
