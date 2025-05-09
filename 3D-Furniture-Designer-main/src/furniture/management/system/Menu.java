package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class Menu {
    CardLayout cardLayout;
    JPanel contentPanel;

    public Menu(String username) {
        JFrame f = new JFrame("Vellora Furnish Studio Management System");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Sidebar Panel
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(70, 95, 220));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("\uD83C\uDFE0 Vellora Furnish Studio", JLabel.CENTER);
        logo.setFont(new Font("SansSerif", Font.BOLD, 22));
        logo.setForeground(Color.WHITE);
        logo.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(logo);

        // Menu buttons
        String[] labels = {"Dashboard", "Dining Chair", "Dining Table", "Computer Desk", "Playground"};
        for (String label : labels) {
            JButton btn = createMenuButton(label);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(180, 40));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(70, 95, 220));
            btn.setFont(new Font("SansSerif", Font.BOLD, 14));
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220)),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)));

            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(btn);

            btn.addActionListener(e -> {
                if (label.equals("Playground")) {
                    // Open NEWT version of Playground (external window)
                    new Playground();
                } else {
                    cardLayout.show(contentPanel, label.replace(" ", "") + "StartUpPanel");
                }
            });
        }

        sidebar.add(Box.createVerticalGlue());

        JButton btnSignOut = createMenuButton("Sign Out");
        btnSignOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSignOut.setBackground(Color.WHITE);
        btnSignOut.setForeground(new Color(70, 95, 220));
        btnSignOut.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSignOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSignOut.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        btnSignOut.setMaximumSize(new Dimension(180, 40));
        btnSignOut.addActionListener(e -> {
            f.dispose();
            new Login();
        });

        sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebar.add(btnSignOut);
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(sidebar);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Content Panel
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        contentPanel.add(new ShowRoomPanel(), "DashboardStartUpPanel");

        contentPanel.add(new DiningChairStartUpPanel(contentPanel, cardLayout), "DiningChairStartUpPanel");
        contentPanel.add(new DiningChairDisplay(true), "diningChairDisplay");
        contentPanel.add(new DiningChair2DPanel(), "diningChairDisplay2d");

        contentPanel.add(new DiningTableStartUpPanel(contentPanel, cardLayout), "DiningTableStartUpPanel");
        contentPanel.add(new DiningTableDisplayPanel(true), "diningTableDisplay");
        contentPanel.add(new DiningTable2DPanel(), "diningTableDisplay2d");

        contentPanel.add(new ComputerDeskStartUpPanel(contentPanel, cardLayout), "ComputerDeskStartUpPanel");
        contentPanel.add(new ComputerDeskDisplayPanel(true), "computerDeskDisplay");
        contentPanel.add(new ComputerDesk2DPanelview(), "computerDeskDisplay2d");

        // 🚫 Removed this line: Playground is NOT a JPanel
        // contentPanel.add(new Playground(), "PlaygroundStartUpPanel");

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, contentPanel);
        splitPane.setDividerLocation(260);
        splitPane.setEnabled(false);
        f.add(splitPane);

        f.setVisible(true);
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        new Menu("team");
    }
}
