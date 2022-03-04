package top.idlestudios.bukkit.jrplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import top.idlestudios.bukkit.jrplugin.locales.localeMgr;

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

            // Locale
            localeMgr.doLocale();
            System.out.println("You are using language: " + localeMgr.locale_lang);
            System.out.println("Made by: " + localeMgr.meta_author);
            System.out.println("For JrPlugin version: " + localeMgr.meta_version);

            // Completed
            System.out.println(localeMgr.main_load_completed);
        } catch (Exception e)
        {
            System.out.println(localeMgr.main_load_failed);
            System.out.println("Caused by: " + e.getCause());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
