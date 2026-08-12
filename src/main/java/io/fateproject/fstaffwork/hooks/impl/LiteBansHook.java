package io.fateproject.fstaffwork.hooks.impl;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.hooks.IHook;
import io.fateproject.fstaffwork.storage.memory.object.MemoryCollector;
import io.fateproject.fstaffwork.storage.memory.object.list.ModeratorStatisticObject;
import litebans.api.Entry;
import litebans.api.Events;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LiteBansHook implements IHook {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean hook(StaffWorkPlugin plugin) {
        if (!plugin.getServer().getPluginManager().isPluginEnabled("LiteBans")) return false;
        MemoryCollector collector = new MemoryCollector();

        Events.get().register(new Events.Listener() {
            @Override
            public void entryAdded(Entry entry) {
                switch (entry.getType()) {
                    case "ban":
                        collector.get(ModeratorStatisticObject.class).incrementValue(ModeratorStatisticObject.PunishmentType.BAN);
                        break;
                    case "mute":
                        collector.get(ModeratorStatisticObject.class).incrementValue(ModeratorStatisticObject.PunishmentType.MUTE);
                        break;
                    case "kick":
                        collector.get(ModeratorStatisticObject.class).incrementValue(ModeratorStatisticObject.PunishmentType.KICK);
                        break;
                }
            }
        });

        this.logger.info("LiteBansAPI has been successfully hooked into 'fStaffWork'!");
        return true;
    }
}
