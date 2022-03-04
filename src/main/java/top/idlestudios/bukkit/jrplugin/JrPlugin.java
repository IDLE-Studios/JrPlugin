package top.idlestudios.bukkit.jrplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class JrPlugin extends JavaPlugin {
    public static FileConfiguration config = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try
        {
            // Configurations
            saveDefaultConfig();
            config = getConfig();

            // Completed
            System.out.println("JrPlugin loaded.");
        } catch (Exception e)
        {
            System.out.println("Unable to load JrPlugin");
            System.out.println("Caused by: " + e.getCause());
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
