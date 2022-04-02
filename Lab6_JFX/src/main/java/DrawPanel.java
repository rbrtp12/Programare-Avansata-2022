import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Class to create the canvas (mid panel)
 */
public class DrawPanel extends JPanel {
    Frame frame;
    BufferedImage image = Constants.image;
    Graphics2D graphics;

    public DrawPanel(Frame frame) throws IOException {
        this.frame = frame;
        createBlank();
        init();
    }

    private void createBlank() {
        graphics = image.createGraphics();
        graphics.setBackground(Color.GRAY);
        graphics.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
    }

    private void init() throws IOException {
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        BufferedImage vadim = ImageIO.read(new File("src/main/resources/corneliu-vadim-tudor.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(vadim));
        add(picLabel);
    }


}
