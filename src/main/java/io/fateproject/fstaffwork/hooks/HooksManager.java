package io.fateproject.fstaffwork.hooks;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.hooks.impl.LiteBansHook;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class HooksManager {
    private final List<IHook> hooks = new ArrayList<>();
    @Getter
    private final StaffWorkPlugin plugin;

    public HooksManager(final StaffWorkPlugin plugin){
        this.plugin = plugin;
        this.register(
                new LiteBansHook()
        );
    }

    public void register(final IHook... hooks) {
        Arrays.asList(hooks).forEach(hook -> {
            if (hook.hook(this.getPlugin())) this.hooks.add(hook);
        });
    }

    public <T extends IHook> T getInstance(Class<T> tClass) {
        return (T) this.hooks
                .stream()
                .filter(hook -> hook.getClass().equals(tClass))
                .findFirst()
                .orElse(null);
    }

    public List<IHook> getKnownHooks() {
        return Collections.unmodifiableList(this.hooks);
    }

}
