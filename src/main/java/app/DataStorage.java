package app;

public interface DataStorage<T> {
    String store(T data);  // Store the data and return an identifier (e.g., a unique ID or filename)
    T retrieve(String source);  // Retrieve the data using the given source (e.g., ID or filename)
}
