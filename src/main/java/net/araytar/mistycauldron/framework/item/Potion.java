package net.araytar.mistycauldron.framework.item;

import org.bukkit.Color;
import net.araytar.mistycauldron.Mistycauldron;
import org.bukkit.event.player.PlayerItemConsumeEvent;

//Don't change anything in here before reading the docs!
public abstract class Potion {

    protected String displayName;
    protected String lore;
    protected Color potionColor;
    protected String identifier;

    public Potion() {
         identifier = this.getClass().getSimpleName();
    }

    public void setPotionColor(int r, int g, int b) {
        this.potionColor = Color.fromRGB(r, g, b);
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public void build() {
        //this right here is the way2go.
        Mistycauldron.potionRegister.registerItem(identifier, this);
    }

    public void onConsumed(PlayerItemConsumeEvent event) {}
}