package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLDrawable;

public class ComputerDesk2Dview extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        drawComputerDesk2D(gl, drawable); // Pass drawable for dynamic centering
    }

    private void drawComputerDesk2D(GL2 gl, GLDrawable drawable) {
        int width = drawable.getSurfaceWidth();
        int height = drawable.getSurfaceHeight();

        int centerX = width / 2;
        int centerY = height / 2 + 50; // Adjust slightly higher for better view

        // Desk measurements
        int deskWidth = 700;
        int deskHeight = 40;
        int legWidth = 50;
        int legHeight = 300;
        int cabinetWidth = 100;
        int cabinetHeight = 20;
        int cabinetGap = 20;

        // Draw title text above desk
        GLUtil2D.drawText(gl, "Computer Desk Front View (h:75cm * w:120cm * d:60cm)", centerX - 200, centerY + 220);

        // Desk top
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        GLUtil2D.drawRectangle(gl, centerX - deskWidth / 2, centerY, deskWidth, deskHeight);

        // Left leg
        gl.glColor3f(0.58f, 0.408f, 0.0f);
        GLUtil2D.drawRectangle(gl, centerX - deskWidth / 2 + 100, centerY - legHeight, legWidth, legHeight);

        // Right leg
        GLUtil2D.drawRectangle(gl, centerX + deskWidth / 2 - 150, centerY - legHeight, legWidth, legHeight);

        // Draw cabinet (drawn vertically stacked drawers under the desk)
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        int cabinetStartY = centerY - 50;
        for (int i = 0; i < 5; i++) {
            GLUtil2D.drawRectangle(gl, centerX - cabinetWidth / 2, cabinetStartY - (cabinetHeight + cabinetGap) * i, cabinetWidth, cabinetHeight);
        }
    }
}
