package top.idlestudios.bukkit.jrplugin.locales.lang;

import top.idlestudios.bukkit.jrplugin.locales.localeMgr;

public class zh_CN {
    // META-INF
    static String author = "IDLE-Studios";
    static String version = "0.1.0";

    // JrPlugin.java
    static String main_load_completed = "JrPlugin 加载完成";
    static String main_load_failed = "JrPlugin 加载失败";

    public static void localeThis(){
        // Meta-INF
        localeMgr.meta_author = author;
        localeMgr.meta_version = version;

        // Main
        // Main.Load
        localeMgr.main_load_completed = main_load_completed;
        localeMgr.main_load_failed = main_load_failed;
    }
}
