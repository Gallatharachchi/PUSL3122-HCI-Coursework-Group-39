package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class DiningChair2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();

        int width = drawable.getSurfaceWidth();
        int height = drawable.getSurfaceHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        gl.glColor3f(0.77f, 0.6f, 0.31f);

        drawDiningChair2D(gl, centerX, centerY);
    }

    private void drawDiningChair2D(GL2 gl, int centerX, int centerY) {
        // Draw centered text
        GLUtil2D.drawText(gl, "Standard Dining Chair (h:90cm * w:50cm * d:50cm) Side View", centerX - 200, centerY + 150);

        gl.glColor3f(0.77f, 0.6f, 0.31f);

        // Chair parts centered around centerX, centerY

        // Seat
        GLUtil2D.drawRectangle(gl, centerX - 175, centerY, 350, 20);

        // Backrest (left vertical)
        GLUtil2D.drawRectangle(gl, centerX - 175, centerY - 210, 20, 650);

        // Right leg
        GLUtil2D.drawRectangle(gl, centerX + 175 - 20, centerY - 210, 20, 230);

        // Support bar
        GLUtil2D.drawRectangle(gl, centerX - 175, centerY - 180, 350, 20);
    }
}
