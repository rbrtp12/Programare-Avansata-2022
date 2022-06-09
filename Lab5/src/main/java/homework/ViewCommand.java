package homework;

import compulsory.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand {
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
