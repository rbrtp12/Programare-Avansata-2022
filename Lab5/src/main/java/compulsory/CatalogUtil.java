package compulsory;

import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog, String path) {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            oos.writeObject(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add(Item i, Catalog catalog) {
        catalog.add(i);
    }

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

    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(item.getLocation());
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}