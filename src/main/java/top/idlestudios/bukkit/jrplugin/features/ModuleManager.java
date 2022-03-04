package top.idlestudios.bukkit.jrplugin.features;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import top.idlestudios.bukkit.jrplugin.JrPlugin;

public class ModuleManager {
    // noServerCrash
    // Snow-TNT
    public static boolean AntiSnowTNTEnabled;

    public static void load_features()
    {
        AntiSnowTNTEnabled = JrPlugin.config.getBoolean("features.serverCrash.snow-tnt.enabled");
    }
}
