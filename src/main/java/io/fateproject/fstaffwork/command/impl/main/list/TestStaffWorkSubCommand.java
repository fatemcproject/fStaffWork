package io.fateproject.fstaffwork.command.impl.main.list;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.command.AbstractSubCommand;
import io.fateproject.fstaffwork.command.SubCommandInfo;
import io.fateproject.fstaffwork.storage.memory.object.MemoryCollector;
import io.fateproject.fstaffwork.storage.memory.object.list.ModeratorStatisticObject;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

@SubCommandInfo(
        aliases = { "test" }
)
public final class TestStaffWorkSubCommand extends AbstractSubCommand {
    public TestStaffWorkSubCommand(StaffWorkPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        MemoryCollector collector = new MemoryCollector();
        sender.sendMessage(String.valueOf(collector.get(ModeratorStatisticObject.class).getMuteValue()));

        return true;
    }

    @Override
    public List<String> complete(CommandSender sender, String label, String[] args) {
        return Collections.emptyList();
    }
}
