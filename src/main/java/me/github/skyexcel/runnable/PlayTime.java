package me.github.skyexcel.runnable;

import me.github.skyexcelcore.data.Config;
import me.github.skyexcelcore.data.Time;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class PlayTime extends BukkitRunnable {

    private Config config;

    private Player player;

    public PlayTime(Player player) {
        this.player = player;
        this.config = new Config("data/" + player.getUniqueId());
    }


    @Override
    public void run() {
        if (config.isFileExist()) {
            long millseconds = config.getLong("time");
            Time time = new Time(millseconds);
            time.addSecond(1);
            config.setLong("time",time.SECOND_IN_MILLIS());
        }
    }
}
