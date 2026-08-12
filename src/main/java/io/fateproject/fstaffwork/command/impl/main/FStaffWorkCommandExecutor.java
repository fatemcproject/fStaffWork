package io.fateproject.fstaffwork.command.impl.main;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.command.CommandExecutor;
import io.fateproject.fstaffwork.command.impl.main.list.TestStaffWorkSubCommand;
import io.fateproject.fstaffwork.command.impl.main.list.ToggleStaffWorkSubCommand;

public final class FStaffWorkCommandExecutor extends CommandExecutor {
    public FStaffWorkCommandExecutor(StaffWorkPlugin plugin) {
        super(plugin);

        this.registerCommand("fstaffwork");
        this.registerSubCommand(
                new ToggleStaffWorkSubCommand(this.getPlugin()),
                new TestStaffWorkSubCommand(this.getPlugin())
        );
    }


}
