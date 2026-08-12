package io.fateproject.fstaffwork.storage.memory.object;

import java.util.HashMap;

public final class MemoryCollector {

    private final HashMap<Class<? extends MemoryObject>, MemoryObject> objectHashMap = new HashMap<>();

    public <T extends MemoryObject> void add(T object){
        objectHashMap.put(object.getClass(), object);
    }

    public <T extends MemoryObject> T get(Class<T> type){
        return type.cast(objectHashMap.get(type));
    }

    public <T extends MemoryObject> boolean contains(Class<T> type){
        return objectHashMap.containsKey(type);
    }

    public <T extends MemoryObject> void remove(Class<T> type){
        objectHashMap.remove(type);
    }
}
