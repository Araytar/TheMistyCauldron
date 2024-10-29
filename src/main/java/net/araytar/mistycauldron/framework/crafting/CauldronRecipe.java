package net.araytar.mistycauldron.framework.crafting;

import net.araytar.mistycauldron.Mistycauldron;
import net.araytar.mistycauldron.framework.Exceptions;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;

public abstract class CauldronRecipe {
    //default values
    protected List<ItemStack> ingredients = new ArrayList<ItemStack>();
    protected List<ItemStack> results = new ArrayList<ItemStack>();
    protected int brewingTicks = 100;
    protected int accuracy = 50;
    protected boolean dynamicEffects = true;
    protected Color particleColor = Color.fromRGB(255, 255, 255);
    protected String identifier = this.getClass().getSimpleName();

    public void addIngredient(ItemStack item) throws Exception {
        ingredients.add(item);
    }

    public void setParticleColor(int r, int g, int b) {
        particleColor = Color.fromRGB(r, g, b);
    }

    public void setDynamicEffects(boolean value) {
        dynamicEffects = value;
    }

    public void setBrewingTime(int Seconds) {
        this.brewingTicks = Seconds/20;
    }

    public void addResult(ItemStack item) throws Exception {
        results.add(item);
    }

    public void setAccuracy(int percent) throws Exception {
        if (percent < 0 || percent > 100) {Exceptions.notAPercentNumber();}
        this.accuracy = percent;
    }

    public void build() {
        Mistycauldron.cauldronRecipeRegister.registerRecipe(identifier, this);
    }
}
