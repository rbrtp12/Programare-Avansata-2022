import java.io.IOException;

/**
 * Main class calls Frame to open game window
 */
public class Main {
    public static void main(String[] args) {
        try {
            new Frame().setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
