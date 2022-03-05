package top.idlestudios.bukkit.jrplugin.features;

import top.idlestudios.bukkit.jrplugin.JrPlugin;

public class ModuleManager {
    // noServerCrash
    // Snow-TNT
    public static boolean AntiSnowTNT_Enabled;

    public static void load_features()
    {
        AntiSnowTNT_Enabled = JrPlugin.config.getBoolean("features.serverCrash.snow-tnt.enabled");
    }
}
