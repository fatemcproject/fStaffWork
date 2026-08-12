package io.fateproject.fstaffwork.command;

import io.fateproject.fstaffwork.StaffWorkPlugin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;

import java.text.NumberFormat;
import java.util.List;

@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor
public abstract class AbstractSubCommand {

    private final StaffWorkPlugin plugin;
    private final SubCommandInfo subCommandInfo = this.getClass().getAnnotation(SubCommandInfo.class);

    public abstract boolean execute(CommandSender sender, String label, String[] args);
    public abstract List<String> complete(CommandSender sender, String label, String[] args);

}
