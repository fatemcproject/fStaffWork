package io.fateproject.fstaffwork.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public final class PlayerLeaveStaffWorkEvent extends Event {
    private final UUID uuid;

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
}
