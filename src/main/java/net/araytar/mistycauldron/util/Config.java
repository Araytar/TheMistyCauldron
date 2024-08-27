package net.araytar.mistycauldron.util;

import org.bukkit.Material;

import java.util.ArrayList;

public class Config {
    ArrayList<Material> heatedMaterials = new ArrayList<>();
    ArrayList<Material> soulHeatedMaterials = new ArrayList<>();

    String heatLevelKey;
    String coldCauldronValue;
    String heatedCauldronValue;
    String soulHeatedCauldronValue;

    public Config() {
        //heated material config here
        heatedMaterials.add(Material.CAMPFIRE);
        heatedMaterials.add(Material.MAGMA_BLOCK);
        heatedMaterials.add(Material.LAVA);
        heatedMaterials.add(Material.FIRE);

        //superheated material config here
        soulHeatedMaterials.add(Material.SOUL_FIRE);
        soulHeatedMaterials.add(Material.SOUL_CAMPFIRE);

        //heatLevel
        heatLevelKey = "heatLevel";
        coldCauldronValue = "0";
        heatedCauldronValue = "1";
        soulHeatedCauldronValue = "2";
    }

    public ArrayList<Material> getHeatedMaterials() {
        return this.heatedMaterials;
    }

    public ArrayList<Material> getSoulHeatedMaterials() {
        return this.soulHeatedMaterials;
    }

    public String getHeatLevelKey() {
        return heatLevelKey;
    }

    public String getColdCauldronValue() {
        return coldCauldronValue;
    }

    public String getHeatedCauldronValue() {
        return heatedCauldronValue;
    }

    public String getSoulHeatedCauldronValue() {
        return soulHeatedCauldronValue;
    }
}
