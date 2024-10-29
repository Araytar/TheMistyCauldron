package net.araytar.mistycauldron.framework.registers;

import net.araytar.mistycauldron.framework.item.Potion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Don't change anything in here before reading the docs!
public class PotionRegister {
    private static final Map<String, Potion> potions = new HashMap<>();

    public void registerItem(String key, Potion potion) {
        potions.put(key, potion);
    }

    public Potion get(String identifier) {
        return potions.get(identifier);
    }

    public boolean hasKey(String identifier) {
        return potions.containsKey(identifier);
    }

    public boolean hasPotion(Potion potion) {
        return potions.containsValue(potion);
    }

    public void removeItem(String key) {
        potions.remove(key);
    }

    public List<Potion> getAll() {
        return new ArrayList<>(potions.values());
    }
}
