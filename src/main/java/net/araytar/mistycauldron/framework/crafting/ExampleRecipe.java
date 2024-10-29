package net.araytar.mistycauldron.framework.crafting;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExampleRecipe extends CauldronRecipe {
    public ExampleRecipe() throws Exception {
        addIngredient(new ItemStack(Material.DIRT, 5));
        addResult(new ItemStack(Material.DIAMOND));
        setAccuracy(100);
        setBrewingTime(10);
        setParticleColor(120, 0, 201);
    }
}