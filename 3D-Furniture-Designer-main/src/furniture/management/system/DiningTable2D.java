package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLDrawable;

public class DiningTable2D extends Furniture2D {
    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        drawDiningTable(gl, drawable);
    }

    private void drawDiningTable(GL2 gl, GLDrawable drawable) {
        int width = drawable.getSurfaceWidth();
        int height = drawable.getSurfaceHeight();

        int centerX = width / 2;
        int centerY = height / 2 + 50; // Adjust center slightly higher

        int tableWidth = 550;
        int tableHeight = 300;

        // Draw main table
        gl.glColor3f(0.824f, 0.706f, 0.549f); // light brown
        GLUtil2D.drawRectangle(gl, centerX - tableWidth / 2, centerY - tableHeight / 2, tableWidth, tableHeight);
        GLUtil2D.drawText(gl, "-Dining Table top view-", centerX - 90, centerY + 200);
        GLUtil2D.drawText(gl, "36 in wide x 29 in long", centerX - 80, centerY + 180);

        // Chair size and spacing
        int chairSize = 100;
        int spacing = 50;

        gl.glColor3f(0.545f, 0.271f, 0.075f); // brown

        // Top chairs
        for (int i = -3; i <= 3; i += 2) {
            int x = centerX + i * (chairSize + spacing) / 2;
            int y = centerY + tableHeight / 2 + spacing;
            GLUtil2D.drawRectangle(gl, x, y, chairSize, chairSize);
        }

        // Bottom chairs
        for (int i = -3; i <= 3; i += 2) {
            int x = centerX + i * (chairSize + spacing) / 2;
            int y = centerY - tableHeight / 2 - chairSize - spacing;
            GLUtil2D.drawRectangle(gl, x, y, chairSize, chairSize);
        }
    }
}
