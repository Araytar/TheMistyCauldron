package net.araytar.mistycauldron;

import net.araytar.mistycauldron.framework.blocks.Cauldron.Cauldron;
import net.araytar.mistycauldron.framework.blocks.Cauldron.listeners.CauldronPlacedListener;
import net.araytar.mistycauldron.framework.blocks.Cauldron.listeners.HeatSourcePlacedListener;
import net.araytar.mistycauldron.framework.crafting.CauldronRecipe;
import net.araytar.mistycauldron.framework.item.Potion;
import net.araytar.mistycauldron.framework.item.listeners.PotionConsumedListener;
import net.araytar.mistycauldron.framework.registers.ComponentRegister;

import java.util.concurrent.ExecutorService;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public final class Mistycauldron extends JavaPlugin {
    private ExecutorService executor;

    //Registers
    public static ComponentRegister<Potion> potionRegister = new ComponentRegister<>();
    public static ComponentRegister<CauldronRecipe> cauldronRecipeRegister = new ComponentRegister<>();
    public static ComponentRegister<Cauldron> cauldronRegister = new ComponentRegister<>();

    @Override
    public void onEnable() {
        executor = Executors.newCachedThreadPool();

        //Cauldron listeners
        getServer().getPluginManager().registerEvents(new CauldronPlacedListener(), this);
        getServer().getPluginManager().registerEvents(new HeatSourcePlacedListener(), this);

        //Item listeners
        getServer().getPluginManager().registerEvents(new PotionConsumedListener(this), this);
    }

    @Override
    public void onDisable() {
        shutdownExecutor();
    }

    private void shutdownExecutor() {
        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
