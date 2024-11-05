package net.araytar.mistycauldron.framework.registers;

import net.araytar.mistycauldron.framework.blocks.Cauldron.Cauldron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//A basic class to store and work with Cauldron.
public class CauldronRegister {
    private final Map<String, Cauldron> cauldronMap = new HashMap<>();

    public void register(String key, Cauldron cauldron) {
        cauldronMap.put(key, cauldron);
    }

    public Cauldron get(String identifier) {
        return cauldronMap.get(identifier);
    }

    public boolean hasKey(String identifier) {
        return cauldronMap.containsKey(identifier);
    }

    public boolean hasCauldron(Cauldron cauldron) {
        return cauldronMap.containsValue(cauldron);
    }

    public void removeItem(String key) {
        cauldronMap.remove(key);
    }

    public List<Cauldron> getAll() {
        return new ArrayList<>(cauldronMap.values());
    }
}