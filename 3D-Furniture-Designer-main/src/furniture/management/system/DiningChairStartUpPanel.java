package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class DiningChairStartUpPanel extends JPanel {

    public DiningChairStartUpPanel(JPanel contentPanel, CardLayout cardLayout) {
        setBackground(new Color(245, 248, 255));
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 248, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Customize Your Dining Chair");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(new Color(30, 30, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel descriptionLabel = new JLabel("Select a design mode to personalize your dining chair to match your space and style.");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        descriptionLabel.setForeground(new Color(60, 60, 60));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(descriptionLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 248, 255));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

        JButton button2d = createRoundedBlueButton("Start in 2D");
        button2d.addActionListener(e -> cardLayout.show(contentPanel, "diningChairDisplay2d"));

        JButton button3d = createRoundedBlueButton("Start in 3D");
        button3d.addActionListener(e -> cardLayout.show(contentPanel, "diningChairDisplay"));

        buttonPanel.add(button2d);
        buttonPanel.add(button3d);

        panel.add(buttonPanel);

        add(panel);
    }

    private JButton createRoundedBlueButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(70, 95, 220));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                super.paintComponent(g);
                g2.dispose();
            }
        };
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(160, 45));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}