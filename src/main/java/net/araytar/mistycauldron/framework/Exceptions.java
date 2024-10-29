package net.araytar.mistycauldron.framework;

import org.bukkit.Material;

public class Exceptions {
    public static void notAnItem(Material item) throws Exception {
        throw new Exception("MATERIAL " + item + " is not an Item.");
    }

    public static void notAPercentNumber() throws Exception {
        throw new Exception("The given number is not a Percent number. (Can only be from 0 to 100)");
    }

    public static void TMCInotFound(String identifier) throws Exception {
        throw new Exception("The TMC identifier called could not be resolved. (is NULL or does not exist) " + identifier);
    }
}
