package top.idlestudios.bukkit.jrplugin.locales;

import top.idlestudios.bukkit.jrplugin.JrPlugin;
import top.idlestudios.bukkit.jrplugin.exceptions.InvalidLanguageException;

import top.idlestudios.bukkit.jrplugin.locales.lang.en;
import top.idlestudios.bukkit.jrplugin.locales.lang.zh_CN;

public class localeMgr {
    // Meta-INF
    public static String locale_lang;
    public static String meta_author;
    public static String meta_version;

    // Main
    // Main.Load
    public static String main_load_completed;
    public static String main_load_failed;

    public static void doLocale() throws InvalidLanguageException
    {
        en.localeThis();
        locale_lang = JrPlugin.config.getString("language", "en");
        if (locale_lang.equals("en")) {
            return;
        } else if(locale_lang.equals("zh_CN")){
            zh_CN.localeThis();
        }
        else
        {
            throw new InvalidLanguageException("Invalid language name: " + locale_lang);
        }
    }
}
