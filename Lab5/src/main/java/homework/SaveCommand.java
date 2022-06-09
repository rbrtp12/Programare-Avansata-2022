package homework;

import compulsory.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand {
    public static void save(Catalog catalog, String path) {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            oos.writeObject(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
