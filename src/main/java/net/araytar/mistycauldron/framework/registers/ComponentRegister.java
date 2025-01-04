package net.araytar.mistycauldron.framework.registers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//A basic class to store and work with different types of components.
public class ComponentRegister<T> {
    private final Map<String, T> cauldronMap = new HashMap<>();

    public void register(String key, T cauldron) {
        cauldronMap.put(key, cauldron);
    }

    public T get(String identifier) {
        return cauldronMap.get(identifier);
    }

    public boolean hasKey(String identifier) {
        return cauldronMap.containsKey(identifier);
    }

    public boolean hasComponent(T cauldron) {
        return cauldronMap.containsValue(cauldron);
    }

    public void removeItem(String key) {
        cauldronMap.remove(key);
    }

    public List<T> getAll() {
        return new ArrayList<T>(cauldronMap.values());
    }

}