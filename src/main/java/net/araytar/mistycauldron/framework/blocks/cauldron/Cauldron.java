package net.araytar.mistycauldron.framework.blocks.cauldron;

import net.araytar.mistycauldron.Mistycauldron;
import org.bukkit.Location;

//Maybe Change this up to an abstract class? not sure yet because it gets created dynamically by the plugin without user input
public class Cauldron {
    protected String cauldronId;
    protected Location cauldronLocation;
    protected String heatLevel;

    public void setId(String cauldronId) {
        this.cauldronId = cauldronId;
    }

    public void setLocation(Location location) {
        this.cauldronLocation = location;
    }

    public void setHeatLevel(String heatLevel) {
        this.heatLevel = heatLevel;
    }

    public void build() {
        Mistycauldron.cauldronRegister.register(this.cauldronId, this);
    }
}
