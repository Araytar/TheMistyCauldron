package net.araytar.mistycauldron.framework.blocks.Cauldron;

import net.araytar.mistycauldron.Mistycauldron;
import org.bukkit.Location;

public class Cauldron {
    protected String cauldronId;
    protected Location cauldronLocation;
    protected String heatLevel;

    public Cauldron setId(String cauldronId) {
        this.cauldronId = cauldronId;
        return this;
    }

    public Cauldron setLocation(Location location) {
        this.cauldronLocation = location;
        return this;
    }

    public Cauldron setHeatLevel(String heatLevel) {
        this.heatLevel = heatLevel;
        return this;
    }

    public Cauldron build() {
        Mistycauldron.cauldronRegister.registerCauldron();
    }
}
