package io.fateproject.fstaffwork.services.impl;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.api.PlayerEnterStaffWorkEvent;
import io.fateproject.fstaffwork.api.PlayerLeaveStaffWorkEvent;
import io.fateproject.fstaffwork.services.IPluginService;
import io.fateproject.fstaffwork.services.objects.PlayerStaffWorkState;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public final class StaffWorkService implements IPluginService {
    private final Map<UUID, PlayerStaffWorkState> playersMap = new HashMap<>();
    @Getter
    private final StaffWorkPlugin plugin;

    public StaffWorkService(StaffWorkPlugin plugin) {
        this.plugin = plugin;
    }

    public void startWork(final UUID uuid) {
        final PlayerStaffWorkState state = this.getMap().getOrDefault(uuid, new PlayerStaffWorkState(false));

        if (!this.isInWork(uuid)) {
            state.setEnabled(true);
            this.playersMap.put(uuid, state);
            this.getPlugin().getServer().getPluginManager().callEvent(new PlayerEnterStaffWorkEvent(uuid));
        }
    }

    public void stopWork(final UUID uuid) {
        final PlayerStaffWorkState state = this.getMap().getOrDefault(uuid, new PlayerStaffWorkState(false));

        if (this.isInWork(uuid)) {
            state.setEnabled(false);
            this.playersMap.put(uuid, state);
            this.getPlugin().getServer().getPluginManager().callEvent(new PlayerLeaveStaffWorkEvent(uuid));
        }
    }

    public boolean isInWork(final Player player) {
        return this.isInWork(player.getUniqueId());
    }

    public boolean isInWork(final UUID uuid) {
        return this.getMap().getOrDefault(uuid, null).isEnabled();
    }

    public boolean isInWork(final String playerName) {
        final Player player = Bukkit.getPlayer(playerName);

        return this.isInWork(player == null ? Bukkit.getOfflinePlayer(playerName).getUniqueId() : player.getUniqueId());
    }

    public Map<UUID, PlayerStaffWorkState> getMap() {
        return Collections.unmodifiableMap(playersMap);
    }
}
