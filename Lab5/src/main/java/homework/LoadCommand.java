package homework;

import compulsory.Catalog;
import compulsory.InvalidCatalogException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand {
    public static Catalog load(String path) {
        Catalog catalog = new Catalog();

        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            var obj = ois.readObject();
            ois.close();
            if (obj.getClass().isInstance(catalog)) {
                catalog = (Catalog) obj;
            } else {
                throw new InvalidCatalogException(new Exception());
            }
        } catch (IOException | ClassNotFoundException | InvalidCatalogException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
