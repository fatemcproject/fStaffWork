package io.fateproject.fstaffwork.command.impl.main.list;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.command.AbstractSubCommand;
import io.fateproject.fstaffwork.command.SubCommandInfo;
import org.bukkit.command.CommandSender;

import java.util.List;

@SubCommandInfo(
        aliases = { "toggle" },
        defaultArgument = true
)
public final class ToggleStaffWorkSubCommand extends AbstractSubCommand {
    public ToggleStaffWorkSubCommand(StaffWorkPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> complete(CommandSender sender, String label, String[] args) {
        return List.of();
    }
}
