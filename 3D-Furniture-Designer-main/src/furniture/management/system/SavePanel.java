package furniture.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavePanel extends JPanel {
    private final List<String> savedPanels;

    public SavePanel(String panelName) {
        savedPanels = new ArrayList<>();

        setLayout(new GridBagLayout());
        setBackground(new Color(245, 248, 255)); // Light professional background

        JButton saveButton = createRoundedBlueButton("💾 Save Design");

        saveButton.addActionListener((ActionEvent e) -> {
            if (!savedPanels.contains(panelName)) {
                savedPanels.add(panelName);
                savePanelNamesToLocalFile(savedPanels);
                JOptionPane.showMessageDialog(null, "Design saved successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Design already saved!");
            }
        });

        // GridBagConstraints with bottom margin
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0); // bottom margin = 30
        gbc.anchor = GridBagConstraints.SOUTH;

        add(saveButton, gbc);
    }

    // Reusable styled button
    private JButton createRoundedBlueButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new GradientPaint(0, 0, new Color(33, 52, 216), getWidth(), getHeight(), new Color(33, 52, 216)));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                super.paintComponent(g);
                g2.dispose();
            }
        };
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(160, 45));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    // Save to file
    private void savePanelNamesToLocalFile(List<String> panelNames) {
        try (FileWriter writer = new FileWriter("saved_panels.txt", true)) {
            for (String panelName : panelNames) {
                writer.write(panelName + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
