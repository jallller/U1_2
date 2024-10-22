package app;

import app.DataStorage;

import java.io.*;
import java.util.UUID;

public class FileStorage<T> implements DataStorage<T> {
    @Override
    public String store(T data) {
        String filename = UUID.randomUUID().toString() + ".dat";  // Create a unique filename
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);  // Serialize and write data to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;  // Return the filename
    }

    @Override
    @SuppressWarnings("unchecked")
    public T retrieve(String filename) {
        T data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            data = (T) ois.readObject();  // Read and deserialize data from the file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}