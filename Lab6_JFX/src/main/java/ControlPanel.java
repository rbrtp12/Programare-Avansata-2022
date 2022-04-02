import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Class for the control panel (bottom one)
 * exitBtn works!!!
 */
public class ControlPanel extends JPanel {
    final Frame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(Frame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);
        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(this::exit);
    }

    private void load(ActionEvent actionEvent) {
    }
    private void save(ActionEvent actionEvent) {
    }
    private void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
