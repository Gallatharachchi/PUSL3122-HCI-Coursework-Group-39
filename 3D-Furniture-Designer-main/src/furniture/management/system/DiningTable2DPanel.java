package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class DiningTable2DPanel extends JPanel {
    public DiningTable2DPanel() {
        setBackground(new Color(245, 248, 255));
        setLayout(new GridBagLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        DiningTable2D diningTable2D = new DiningTable2D();
        gljPanel.addGLEventListener(diningTable2D);
        gljPanel.setPreferredSize(new Dimension(800, 600));

        add(gljPanel); // GridBagLayout centers this by default
    }
}
