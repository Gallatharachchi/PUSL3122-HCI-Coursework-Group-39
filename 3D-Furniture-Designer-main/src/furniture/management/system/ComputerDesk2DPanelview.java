package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class ComputerDesk2DPanelview extends JPanel {

    ComputerDesk2DPanelview(){
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        ComputerDesk2Dview computerDesk2Dview = new ComputerDesk2Dview();
        gljPanel.addGLEventListener(computerDesk2Dview);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);
    }
}
