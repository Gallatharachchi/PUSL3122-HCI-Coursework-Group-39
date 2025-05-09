package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class ShowRoomPanel extends JPanel {

    public ShowRoomPanel() {
        setBackground(new Color(191, 191, 191));
        setLayout(new GridBagLayout());

        addPanel(new DiningChairDisplay(false), 0, 0);
        addPanel(new DiningTableDisplayPanel(false), 1, 0);
        addPanel(new ComputerDeskDisplayPanel(false), 2, 0);
    }

    private void addPanel(JPanel panel, int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(panel, gbc);
    }
}
