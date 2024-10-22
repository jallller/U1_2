package app;

import app.DataStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemoryStorage<T> implements DataStorage<T> {
    private Map<String, T> memoryStore = new HashMap<>();

    @Override
    public String store(T data) {
        String uniqueID = UUID.randomUUID().toString();  // Generate a unique ID
        memoryStore.put(uniqueID, data);  // Store the data in memory
        return uniqueID;  // Return the unique ID
    }

    @Override
    public T retrieve(String source) {
        return memoryStore.get(source);  // Retrieve the data using the unique ID
    }
}
