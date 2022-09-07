package me.github.skyexcel.event;

import me.github.skyexcel.data.TimeData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        TimeData timedata = new TimeData(player);

        timedata.saveTime();


    }
}
