package furniture.management.system;

import com.jogamp.opengl.GL2;
import java.awt.*;

public class ColorCont {

    private final float[] floorColor = {0.3f, 0.3f, 0.3f};
    // Initial floor color (light brown)
    private final float[] backgroundColor = {0.85f, 0.92f, 0.98f}; // Light blue background

    // Apply the floor color
    public void applyFloorColor(GL2 gl) {
        gl.glColor3fv(floorColor, 0);
    }

    // Change the floor color
    public void setFloorColor(Color newColor) {
        floorColor[0] = newColor.getRed() / 255.0f;
        floorColor[1] = newColor.getGreen() / 255.0f;
        floorColor[2] = newColor.getBlue() / 255.0f;
    }

    // Get the current floor color
    public Color getFloorColor() {
        return new Color(floorColor[0], floorColor[1], floorColor[2]);
    }

    // Apply the background color
    public void applyBackgroundColor(GL2 gl) {
        gl.glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], 1.0f);
    }

    // Change the background color
    public void setBackgroundColor(Color newColor) {
        backgroundColor[0] = newColor.getRed() / 255.0f;
        backgroundColor[1] = newColor.getGreen() / 255.0f;
        backgroundColor[2] = newColor.getBlue() / 255.0f;
    }

    // Get the current background color
    public Color getBackgroundColor() {
        return new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]);
    }

    // Reset floor color to default
    public void resetFloorColor() {
        floorColor[0] = 0.898f;
        floorColor[1] = 0.729f;
        floorColor[2] = 0.451f;
    }

    // Reset background color to light blue
    public void resetBackgroundColor() {
        backgroundColor[0] = 0.85f;
        backgroundColor[1] = 0.92f;
        backgroundColor[2] = 0.98f;
    }
}
