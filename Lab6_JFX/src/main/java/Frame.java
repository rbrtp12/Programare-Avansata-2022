import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * main frame of the game
 */
public class Frame extends JFrame {
    DrawPanel canvas;
    ConfigPanel configPanel;
    ControlPanel controlPanel;

    public Frame() throws IOException {
        super("Positional Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    public void init() throws IOException {
        canvas = new DrawPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
    }
}
