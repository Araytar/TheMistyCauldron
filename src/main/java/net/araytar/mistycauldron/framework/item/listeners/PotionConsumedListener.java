package net.araytar.mistycauldron.framework.item.listeners;

import net.araytar.mistycauldron.framework.Exceptions;
import net.araytar.mistycauldron.framework.item.Potion;
import net.araytar.mistycauldron.Mistycauldron;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

//Don't change anything in here before reading the docs!
public class PotionConsumedListener implements Listener {
    private final JavaPlugin pluginInstance;

    //Constructor
    public PotionConsumedListener(JavaPlugin pluginInstance) {
        this.pluginInstance = pluginInstance;
    }

    @EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent event) throws Exception {
        Player player = event.getPlayer();
        //NEEDS to stay here!
        if (!(event.getItem().hasItemMeta()) || !(event.getItem().getItemMeta() instanceof PotionMeta)) {return;}
        ItemMeta itemMeta = event.getItem().getItemMeta();
        NamespacedKey key = new NamespacedKey(pluginInstance, "tmc_identifier");
        if (itemMeta == null || !(itemMeta.getPersistentDataContainer().has(key, PersistentDataType.STRING))) {return;}
        String identifier = itemMeta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
        Potion potion = Mistycauldron.potionRegister.get(identifier);
        if (potion == null) {Exceptions.TMCInotFound(identifier);}
        potion.onConsumed(event);
    }
}
