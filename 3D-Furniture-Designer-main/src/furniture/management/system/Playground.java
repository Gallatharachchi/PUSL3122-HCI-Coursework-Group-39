package furniture.management.system;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Playground implements GLEventListener {

    private float angleY = 0;
    private float zoom = -20;
    private float dragX = 0, dragY = 0;
    private int prevMouseX, prevMouseY;
    private boolean dragging = false;

    private final java.util.List<Furniture> furnitureItems = new java.util.ArrayList<>();
    private final RotationManager rotationManager = new RotationManager();
    private final ColorCont colorManager = new ColorCont();
    private final LightingManager lightingManager = new LightingManager();

    public Playground() {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        GLJPanel panel = new GLJPanel(caps);
        panel.addGLEventListener(this);

        FPSAnimator animator = new FPSAnimator(panel, 60);
        animator.start();

        // Mouse Interaction
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                prevMouseX = e.getX();
                prevMouseY = e.getY();
                dragging = true;
            }

            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    int x = e.getX();
                    int y = e.getY();
                    angleY += (x - prevMouseX);
                    dragX += (x - prevMouseX) * 0.01f;
                    dragY -= (y - prevMouseY) * 0.01f;
                    prevMouseX = x;
                    prevMouseY = y;
                    panel.repaint();
                }
            }
        });

        panel.addMouseWheelListener(e -> {
            zoom += e.getWheelRotation();
            panel.repaint();
        });

        // UI Setup
        JFrame frame = new JFrame("Playground - 3D Designer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        JPanel controls = new JPanel(new BorderLayout());

        // Top: Add Furniture Buttons
        JPanel addButtons = new JPanel();
        JButton addChair = new JButton("Add Chair");
        JButton addTable = new JButton("Add Table");
        JButton addDesk = new JButton("Add Desk");
        addButtons.add(addChair);
        addButtons.add(addTable);
        addButtons.add(addDesk);

        addChair.addActionListener(e -> {
            furnitureItems.add(new DiningChair());
            panel.repaint();
        });
        addTable.addActionListener(e -> {
            furnitureItems.add(new DiningTable());
            panel.repaint();
        });
        addDesk.addActionListener(e -> {
            furnitureItems.add(new ComputerDesk());
            panel.repaint();
        });

        controls.add(addButtons, BorderLayout.NORTH);
        controls.add(new ControlsPanel(rotationManager, colorManager, lightingManager), BorderLayout.CENTER);

        frame.add(controls, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glClearColor(0.9f, 0.95f, 1f, 1f); // light blue bg
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(dragX, dragY, zoom);
        gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f);

        float startX = -8.0f;
        float spacing = 8.0f;

        for (int i = 0; i < furnitureItems.size(); i++) {
            gl.glPushMatrix();
            gl.glTranslatef(startX + i * spacing, 0f, 0f);
            furnitureItems.get(i).display(drawable);
            gl.glPopMatrix();
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        float aspect = (float) width / height;

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        new com.jogamp.opengl.glu.GLU().gluPerspective(45, aspect, 1.0, 100.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {}
}
