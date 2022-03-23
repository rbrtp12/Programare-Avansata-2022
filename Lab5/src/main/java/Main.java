import lombok.extern.java.Log;

import java.io.IOException;
import java.util.ArrayList;

@Log
public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Catalog catalog = new Catalog("Catalogul meu", new ArrayList<>());
        Catalog catalogLoaded = new Catalog("Catalog din load", new ArrayList<>());
        Item book = new Item("1", "Java Programming Guide", "https://www.iitk.ac.in/esc101/share/downloads/javanotes5.pdf");
        Item song = new Item("2", "Java Song", "https://www.youtube.com/watch?v=b-Cr0EWwaTk");
        catalog.addItem(book);
        catalog.addItem(song);
        try {
            CatalogUtil.save(catalog, "D:\\facultate\\an3\\Java\\Lab5\\catalog.json");
             catalogLoaded = CatalogUtil.load("D:\\facultate\\an3\\Java\\Lab5\\catalog.json");
        } catch (Exception e) {
            log.warning("Exception caught: " + e);
        }
        log.info("Catalogul incarcat din json: " + catalogLoaded.toString());



    }
}
