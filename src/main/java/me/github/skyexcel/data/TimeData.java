package me.github.skyexcel.data;

import me.github.skyexcel.DailyReward;
import me.github.skyexcelcore.data.Config;
import me.github.skyexcelcore.data.Time;
import org.bukkit.entity.Player;

public class TimeData {

    private Time time;
    private Player player;
    private Config config;
    public TimeData(Player player) {
        this.player = player;
        this.config = new Config("data/" + player.getUniqueId());
        config.setPlugin(DailyReward.plugin);
    }


    public void saveTime() {
        if (!config.isFileExist()) {
            config.getConfig().set("time", 0);
            config.saveConfig();
        } else {
            long millseconds = config.getLong("time");
            time = new Time(millseconds);
            config.getConfig().set("time", millseconds);
            config.saveConfig();
        }
    }

    public long getMillSecond() {
        return config.getLong("time");
    }

    public Player getPlayer() {
        return player;
    }

    public Config getConfig() {
        return config;
    }

    public Time getTime() {
        return time;
    }
}
