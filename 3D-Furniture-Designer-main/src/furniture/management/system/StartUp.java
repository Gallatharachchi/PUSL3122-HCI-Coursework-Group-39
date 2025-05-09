package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class StartUp extends JFrame {

    JLabel titleLabel;
    JButton loginButton;

    public StartUp() {
        super("Welcome to Vellora Furnish Studio");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Logo at the top
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo_lg.png"));
        Image scaledLogo = logoIcon.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setBounds((screenWidth - 120) / 2, 50, 120, 100);
        add(logoLabel);

        // Title
        titleLabel = new JLabel("Vellora Furnish Studio");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        titleLabel.setForeground(new Color(70, 95, 220));
        titleLabel.setBounds((screenWidth - 500) / 2, 170, 500, 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);

        // Description
        JTextArea description = new JTextArea("Our passion for craftsmanship and commitment to quality reflect in every piece we create. We are more than just a furniture company; we are artisans of comfort, style, and functionality. Explore a new level of design excellence and durability with Vellora Furnish Studio.");
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setFocusable(false);
        description.setOpaque(false);
        description.setForeground(Color.DARK_GRAY);
        description.setFont(new Font("SansSerif", Font.PLAIN, 18));
        description.setBounds((screenWidth - 700) / 2, 240, 700, 150);
        add(description);

        // Login Button
        loginButton = new JButton("ENTER");
        loginButton.setBounds((screenWidth - 150) / 2, 420, 150, 50);
        loginButton.setBackground(new Color(30, 30, 30));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        loginButton.setFocusPainted(false);
        add(loginButton);

        loginButton.addActionListener(e -> {
            dispose();
            new Login();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StartUp();
    }
}
