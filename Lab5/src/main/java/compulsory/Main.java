package compulsory;

import homework.AddCommand;
import homework.LoadCommand;
import homework.SaveCommand;
import homework.ViewCommand;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyRefs");
        var book = new Book("book0", "DaVinci Code", "C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\DaVinci Code.txt", "Dan Brown", 2003, 689);
        var painting = new Painting("paint0", "Wheatfield With Crows", "C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\Wheatfield With Crows.jpg", "Vincent Van Gogh", 1890, "oil on canvas");
        // catalog.add(book);
        // catalog.add(painting);
        AddCommand.add(book, catalog);
        AddCommand.add(painting, catalog);
        var book1 = new Book("book2", "Peppa Pig", "C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\Peppa Pig.txt", "Neville Astley Mark Baker", 2045, 12);
        AddCommand.add(book1, catalog);
        // CatalogUtil.save(catalog, "C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\catalog.json");
        SaveCommand.save(catalog, "C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\catalog.json");
    }

    private void testLoadView() throws IOException {
        // Catalog catalog = CatalogUtil.load("C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\catalog.json");
        Catalog catalog = LoadCommand.load("C:\\Users\\Teo Lupu\\IdeaProjects\\Java_Lab5\\catalog.json");
        // CatalogUtil.view(catalog.findById("paint1"));
        ViewCommand.view(catalog.findById("paint0"));
    }
}
