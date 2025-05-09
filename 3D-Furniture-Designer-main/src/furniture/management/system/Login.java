package furniture.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Login extends JFrame {
    JTextField textField1;
    JPasswordField passwordField;
    JButton b1;

    public Login() {
        super("Furniture Management System");

        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("team", "123");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int panelWidth = screenWidth / 2;

        // Left Panel (Branding)
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, panelWidth, screenHeight);
        leftPanel.setBackground(new Color(70, 95, 220));
        leftPanel.setLayout(null);
        add(leftPanel);

        // Logo at the top
        ImageIcon logoIcon = new ImageIcon("icons/logo_lg.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setBounds(50, 120, 500, 50);
        leftPanel.add(logoLabel);

        JLabel branding = new JLabel("Hello, Vellora Furnish Studio!");
        branding.setBounds(50, 120, 500, 50);
        branding.setFont(new Font("SansSerif", Font.BOLD, 36));
        branding.setForeground(Color.WHITE);
        leftPanel.add(branding);

        JLabel subText = new JLabel("<html>Welcome to Vellora Furnish Studio Management System. This platform allows you to manage your furniture inventory, track sales, and generate reports with ease. Streamline your operations and enhance productivity through our user-friendly dashboard designed for efficiency and accuracy.<br><br>Let us help you automate and grow your furniture business with confidence and simplicity.</html>");
        subText.setBounds(50, 120, panelWidth - 100, 400);
        subText.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subText.setForeground(Color.WHITE);
        leftPanel.add(subText);

        // Right Panel (Login)
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(panelWidth, 0, panelWidth, screenHeight);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setLayout(null);
        add(loginPanel);

        JLabel title = new JLabel("Welcome Back!");
        title.setBounds(50, screenHeight / 6, panelWidth - 100, 40);
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        loginPanel.add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50, screenHeight / 6 + 80, panelWidth - 100, 25);
        userLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        loginPanel.add(userLabel);

        textField1 = new JTextField();
        textField1.setBounds(50, screenHeight / 6 + 110, panelWidth - 100, 40);
        textField1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textField1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        loginPanel.add(textField1);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50, screenHeight / 6 + 170, panelWidth - 100, 25);
        passLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        loginPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, screenHeight / 6 + 200, panelWidth - 100, 40);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        loginPanel.add(passwordField);

        b1 = new JButton("Login Now");
        b1.setBounds(50, screenHeight / 6 + 270, panelWidth - 100, 45);
        b1.setBackground(new Color(30, 30, 30));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SansSerif", Font.BOLD, 16));
        b1.setFocusPainted(false);
        loginPanel.add(b1);

        b1.addActionListener(e -> {
            String username = textField1.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(Login.this, "Username and password are required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {

                SplashScreen loadingScreen = new SplashScreen();
                SwingUtilities.invokeLater(() -> {
                    new Menu(username);
                    loadingScreen.dispose(); // Close the splash screen after the menu is displayed
                });
                dispose();

            } else {
                JOptionPane.showMessageDialog(Login.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}