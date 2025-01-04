package net.araytar.mistycauldron.framework.crafting.cauldron;

import com.google.common.base.Ticker;
import net.araytar.mistycauldron.framework.blocks.cauldron.Cauldron;

public class CauldronProcess {
    private CauldronRecipe pattern = new CauldronRecipe();

    public CauldronProcess(CauldronRecipe recipe, Cauldron cauldron) {
        this.pattern = recipe;
    }
}
