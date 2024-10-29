package net.araytar.mistycauldron.framework.item;

import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ExamplePotion extends Potion {
    public ExamplePotion() {
        setDisplayName("Example Potion");
        setLore("OP Potion");
        setPotionColor(0,255, 100);
        build();
    }

    @Override
    public void onConsumed(PlayerItemConsumeEvent event) {
        //Effects Yara, Yara...
    }
}



