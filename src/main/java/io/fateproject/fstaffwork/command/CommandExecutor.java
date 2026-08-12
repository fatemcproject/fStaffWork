package io.fateproject.fstaffwork.command;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @RequiredArgsConstructor
public abstract class CommandExecutor implements TabExecutor {

    private final StaffWorkPlugin plugin;
    private final List<AbstractSubCommand> subCommands = new ArrayList<>();

    protected void registerCommand(String label) {
        final PluginCommand pluginCommand = this.getPlugin().getCommand(label);

        if (pluginCommand == null) {
            throw new RuntimeException("This command not recognized in plugin.yml!");
        }

        pluginCommand.setExecutor(this);
        pluginCommand.setTabCompleter(this);

    }

    public void registerSubCommand(AbstractSubCommand... subs) {
        this.getSubCommands().addAll(Arrays.asList(subs));
    }

}
