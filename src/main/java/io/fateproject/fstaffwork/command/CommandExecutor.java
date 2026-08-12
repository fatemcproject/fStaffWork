package io.fateproject.fstaffwork.command;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import io.fateproject.fstaffwork.util.ColorUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter @RequiredArgsConstructor
public abstract class CommandExecutor implements TabExecutor {

    private final StaffWorkPlugin plugin;
    private final List<AbstractSubCommand> subCommands = new ArrayList<>();
    private AbstractSubCommand defaultArgument = null;

    protected void registerCommand(String label) {
        final PluginCommand pluginCommand = this.getPlugin().getCommand(label);

        if (pluginCommand == null) {
            throw new RuntimeException("This command not recognized in plugin.yml!");
        }

        pluginCommand.setExecutor(this);
        pluginCommand.setTabCompleter(this);

    }

    public void registerSubCommand(AbstractSubCommand... subs) {
        Arrays.asList(subs).forEach(subCommand -> {
            if (subCommand.getSubCommandInfo().defaultArgument()) {
                this.defaultArgument = subCommand;
            }
            this.getSubCommands().add(subCommand);
        });
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (this.getDefaultArgument() == null) {
                sender.sendMessage(ColorUtil.color("&cНет дефолтного аргумента для этой команды!"));
                return true;
            }

            this.getDefaultArgument().execute(sender, label, Arrays.copyOfRange(args, 1, args.length));
        }

        if (args.length >= 1) {
            final String arg = args[0];
            final AbstractSubCommand abstractSubCommand = this.getSubCommand(arg);

            if (abstractSubCommand == null) {
                sender.sendMessage(ColorUtil.color("&cНе найдена команда: " + arg));
                return true;
            }

            final String permission = abstractSubCommand.getSubCommandInfo().permission();
            if (!permission.isEmpty()) {
                if (!sender.hasPermission(permission)) {
                    sender.sendMessage(ColorUtil.color("&cНет прав!"));
                    return true;
                }
            }

            return abstractSubCommand.execute(sender, label, Arrays.copyOfRange(args, 1, args.length));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1) {
            final List<String> list = new ArrayList<>();
            this.getSubCommands()
                    .forEach(subCommand ->
                            list.addAll(Arrays.asList(subCommand.getSubCommandInfo().aliases()))
                    );
            return list;
        }

        final AbstractSubCommand subCommand = this.getSubCommand(args[0]);
        if (subCommand == null )return null;

        return subCommand.complete(sender, alias, Arrays.copyOfRange(args, 1, args.length));
    }

    private AbstractSubCommand getSubCommand(String label) {
        return this.getSubCommands()
                .stream()
                .filter(subCommand -> Arrays.asList(subCommand.getSubCommandInfo().aliases()).contains(label))
                .findFirst()
                .orElse(null);
    }

}
