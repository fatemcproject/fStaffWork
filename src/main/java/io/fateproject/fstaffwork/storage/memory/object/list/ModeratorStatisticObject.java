package io.fateproject.fstaffwork.storage.memory.object.list;

import io.fateproject.fstaffwork.storage.memory.object.MemoryObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class ModeratorStatisticObject implements MemoryObject {
    private String playerName;
    private List<TargetInformationObject> targetInformationList;

    private int muteValue;
    private int banValue;
    private int kickValue;

    public ModeratorStatisticObject(String playerName, int muteValue, int banValue, int kickValue){
        this.playerName = playerName;
        this.muteValue = muteValue;
        this.banValue = banValue;
        this.kickValue = kickValue;
        this.targetInformationList = new ArrayList<>();
    }

    public void incrementValue(PunishmentType punishmentType){
        if (punishmentType == PunishmentType.BAN) banValue++;
        else if (punishmentType == PunishmentType.MUTE) muteValue++;
        else if (punishmentType == PunishmentType.KICK) kickValue++;
    }

    public void setValue(PunishmentType punishmentType, int value) {
        if (punishmentType == PunishmentType.BAN) banValue = value;
        else if (punishmentType == PunishmentType.MUTE) muteValue = value;
        else if (punishmentType == PunishmentType.KICK) kickValue = value;
    }

    public enum PunishmentType {
        MUTE,
        BAN,
        KICK
    }
}
