package io.fateproject.fstaffwork.storage;

import io.fateproject.fstaffwork.storage.memory.object.MemoryObject;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public final class DataStorage {

    private final DataType dataType;

    private DataStorage(Builder builder){
        this.dataType = builder.dataType;
    }

    public static Builder builder(){
        return new Builder();
    }

    public enum DataType {
        MEMORY,
        YML
    }

    public static class Builder {
        private DataType dataType;
        private Set<Class<? extends MemoryObject>> registeredObjects = new HashSet<>();

        public Builder registerMemory(Class<? extends MemoryObject> type){
            registeredObjects.add(type);
            return this;
        }

        public Builder type(DataType dataType){
            this.dataType = dataType;
            return this;
        }

        public DataStorage build(){
            return new DataStorage(this);
        }
    }
}
