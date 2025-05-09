package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {
    JProgressBar progressBar;

    public SplashScreen() {
        super("Loading...");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(70, 95, 220)); // Professional dark blue
        content.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo_lg.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Vellora Furnish Studio");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setForeground(new Color(255, 255, 255));
        progressBar.setBackground(new Color(7, 32, 224));
        progressBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        progressBar.setString("Getting things ready for you...");
        progressBar.setStringPainted(true);
        progressBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        content.add(image);
        content.add(title);
        content.add(progressBar);

        setContentPane(content);
        setUndecorated(true);
        pack();
        setSize(450, 280);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
        setVisible(true);
    }
}