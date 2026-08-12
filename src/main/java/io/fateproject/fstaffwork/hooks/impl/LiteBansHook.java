package io.fateproject.fstaffwork.hooks.impl;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.hooks.IHook;
import litebans.api.Database;
import litebans.api.Entry;
import litebans.api.Events;

public final class LiteBansHook implements IHook {
    @Override
    public boolean hook(StaffWorkPlugin plugin) {
        if (!plugin.getServer().getPluginManager().isPluginEnabled("LiteBans")) return false;

        Events.get().register(new Events.Listener() {
            @Override
            public void entryAdded(Entry entry) {
                switch (entry.getType()) {
                    case "ban":
                        // ban
                        break;
                    case "mute":
                        // mute
                        break;
                    case "kick":
                        // kick
                        break;
                }
            }
        });

        return true;
    }
}
