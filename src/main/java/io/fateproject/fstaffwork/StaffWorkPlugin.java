package io.fateproject.fstaffwork;

import io.fateproject.fstaffwork.command.impl.main.FStaffWorkCommandExecutor;
import io.fateproject.fstaffwork.hooks.HooksManager;
import io.fateproject.fstaffwork.listeners.PlayerJoinListener;
import io.fateproject.fstaffwork.services.impl.StaffWorkService;
import io.fateproject.fstaffwork.storage.DataStorage;
import io.fateproject.fstaffwork.storage.memory.object.list.ModeratorStatisticObject;
import io.fateproject.fstaffwork.storage.memory.object.list.TargetInformationObject;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public final class StaffWorkPlugin extends JavaPlugin {

    private StaffWorkService staffWorkService;
    private HooksManager hooksManager;
    private DataStorage dataStorage;
    private FStaffWorkCommandExecutor fStaffWorkCommandExecutor;

    @Override
    public void onEnable() {
        this.fStaffWorkCommandExecutor = new FStaffWorkCommandExecutor(this);
        this.hooksManager = new HooksManager(this);
        this.staffWorkService = new StaffWorkService(this);

        this.getServer().getServicesManager().register(StaffWorkService.class, staffWorkService, this, ServicePriority.High);
        this.dataStorage = DataStorage.builder().type(DataStorage.DataType.MEMORY).registerMemory(ModeratorStatisticObject.class).registerMemory(TargetInformationObject.class).build();

        Arrays.asList(
                new PlayerJoinListener()
        ).forEach(listener -> this.getServer().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable() {

    }
}
