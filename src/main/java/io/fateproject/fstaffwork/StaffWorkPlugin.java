package io.fateproject.fstaffwork;

import io.fateproject.fstaffwork.services.impl.StaffWorkService;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffWorkPlugin extends JavaPlugin {

    private StaffWorkService staffWorkService;

    @Override
    public void onEnable() {
        this.staffWorkService = new StaffWorkService(this);
        this.getServer().getServicesManager().register(StaffWorkService.class, this.staffWorkService, this, ServicePriority.High);
    }

    @Override
    public void onDisable() {


    }
}
