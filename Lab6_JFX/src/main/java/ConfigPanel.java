import javax.swing.*;

/**
 * Class to create the configuration panel (top one)
 */

public class ConfigPanel extends JPanel {
    Frame frame;
    JButton create = new JButton("Create");

    public ConfigPanel(Frame frame) {
        this.frame = frame;
        init();
    }


    private void init() {
        JLabel gridLabel = new JLabel("Grid size: ");
        JSpinner rows = new JSpinner(new SpinnerNumberModel(Constants.DEFAULTSIZE, 0, Constants.MAXSIZE, 1));
        JSpinner cols = new JSpinner(new SpinnerNumberModel(Constants.DEFAULTSIZE, 0, Constants.MAXSIZE, 1));

        add(gridLabel);
        add(rows);
        add(cols);
        add(create);
    }
}
