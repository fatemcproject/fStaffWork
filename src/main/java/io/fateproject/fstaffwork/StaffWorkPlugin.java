package io.fateproject.fstaffwork;

import io.fateproject.fstaffwork.storage.DataStorage;
import io.fateproject.fstaffwork.storage.memory.object.MemoryCollector;
import io.fateproject.fstaffwork.storage.memory.object.list.ModeratorStatisticObject;
import io.fateproject.fstaffwork.storage.memory.object.list.TargetInformationObject;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffWorkPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        DataStorage.builder()
                .type(DataStorage.DataType.MEMORY)
                .registerMemory(ModeratorStatisticObject.class)
                .registerMemory(TargetInformationObject.class)
                .build();

        MemoryCollector memoryCollector = new MemoryCollector();

        memoryCollector.add(new ModeratorStatisticObject("TestPlayer", 1, 1));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
