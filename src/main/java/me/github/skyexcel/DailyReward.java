package me.github.skyexcel;

import data.Config;
import me.github.skyexcel.cmd.RewardCmd;
import me.github.skyexcel.event.JoinEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class DailyReward extends JavaPlugin {

    public static Config config;
    public static DailyReward plugin;

    public static Config data;

    @Override
    public void onEnable() {
        super.onEnable();

        plugin = this;
        config = new Config("config");
        config.setPlugin(plugin);
        config.loadDefaultPluginConfig();


        getCommand("출석체크").setExecutor(new RewardCmd());
        Listener[] listeners = {new JoinEvent()};
        PluginManager pm = Bukkit.getPluginManager();
        Arrays.stream(listeners).forEach(listener ->
                pm.registerEvents(listener, this));

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

//    public static SkyExcel getCore() {
//        Plugin SkyExcelCore = Bukkit.getServer().getPluginManager().getPlugin("SkyExcelCore");
//        if (SkyExcelCore instanceof SkyExcel) {
//            return (SkyExcel) SkyExcelCore;
//        } else {
//            return null;
//        }
//    }

}
