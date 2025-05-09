package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class ControlsPanel extends JPanel {

    public ControlsPanel(RotationManager rotationManager, ColorCont colorManager, LightingManager lightingManager) {
        setBackground(new Color(245, 248, 255)); // Light background
        setLayout(new GridBagLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 20, 20));
        buttonPanel.setBackground(new Color(245, 248, 255));

        // Create Buttons
        JButton resetColorButton = createResponsiveBlueButton("Reset Color");
        JButton floorColorButton = createResponsiveBlueButton("Floor Color");
        JButton backgroundColorButton = createResponsiveBlueButton("Background Color");
        JButton leftButton = createResponsiveBlueButton("Rotate Left");
        JButton rightButton = createResponsiveBlueButton("Rotate Right");
        JButton changeMaterialButton = createResponsiveBlueButton("Change Material");
        JButton lightButton = createResponsiveBlueButton("Light Toggle");

        // Add to Grid Panel
        buttonPanel.add(resetColorButton);
        buttonPanel.add(floorColorButton);
        buttonPanel.add(backgroundColorButton);
        buttonPanel.add(changeMaterialButton);
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        buttonPanel.add(lightButton);

        // Add margin by wrapping inside another panel
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBackground(new Color(245, 248, 255));
        wrapperPanel.add(buttonPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 0, 0); // top margin = 30
        gbc.anchor = GridBagConstraints.NORTH;
        add(wrapperPanel, gbc);

        // Actions
        leftButton.addActionListener(e -> rotationManager.rotateLeft());
        rightButton.addActionListener(e -> rotationManager.rotateRight());

        changeMaterialButton.addActionListener(e -> {
            GLUtil.Material selectedMaterial = (GLUtil.Material) JOptionPane.showInputDialog(
                    null,
                    "Choose Material:",
                    "Material Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    GLUtil.Material.values(),
                    GLUtil.Material.values()[0]
            );
            if (selectedMaterial != null) {
                GLUtil.setCurrentColors(selectedMaterial);
            }
        });

        floorColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Choose Floor Color", colorManager.getFloorColor());
            if (newColor != null) {
                colorManager.setFloorColor(newColor);
            }
        });

        backgroundColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Choose Background Color", colorManager.getBackgroundColor());
            if (newColor != null) {
                colorManager.setBackgroundColor(newColor);
            }
        });

        lightButton.addActionListener(e -> lightingManager.toggleLighting());

        resetColorButton.addActionListener(e -> {
            colorManager.resetBackgroundColor();
            colorManager.resetFloorColor();
        });
    }

    private JButton createResponsiveBlueButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(70, 95, 220));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8); // 4px radius
                super.paintComponent(g);
                g2.dispose();
            }
        };
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
}
