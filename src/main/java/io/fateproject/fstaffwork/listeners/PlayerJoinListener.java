package io.fateproject.fstaffwork.listeners;

import io.fateproject.fstaffwork.storage.memory.object.MemoryCollector;
import io.fateproject.fstaffwork.storage.memory.object.list.ModeratorStatisticObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class PlayerJoinListener implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event){
        MemoryCollector collector = new MemoryCollector();
        collector.add(new ModeratorStatisticObject(event.getPlayer().getName(), 0, 0, 0));
    }
}
