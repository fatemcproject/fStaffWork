package io.fateproject.fstaffwork.storage.memory.object.list;

import io.fateproject.fstaffwork.storage.memory.object.MemoryObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public final class TargetInformationObject implements MemoryObject {
    private String playerName;
    private String moderatorName;

    private LocalDateTime date;
    private String reason;
    private int time;
}
