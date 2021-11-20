package de.ichmagomaskekse.uiengine.graphics.ui;

import java.util.HashMap;

public class UICManager {

    private static HashMap<String, UIC> components = new HashMap<>();


    /**
     * Registers a new UIC Component after checking if it's already registered.
     */
    public static boolean registerUIC(UIC uic) {
        if(isRegistered(uic)) return false;
        components.put(uic.getId(), uic);
        return true;
    }

    /**
     * Unregisters a already registered UIC Component.
     */
    public static boolean unregisterUIC(UIC uic) {
        if(!isRegistered(uic)) return false;
        components.remove(uic.getId(), uic);
        return true;
    }

    /**
     * Unregisters all registered UIC Components.
     */
    public static void unregisterAll() {
        components.clear();
    }

    /**
     * Checks if a UIC Component is already registered to the manager.
     */
    public static boolean isRegistered(UIC uic) { return components.containsValue(uic); }

}
