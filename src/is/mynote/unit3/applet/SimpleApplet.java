package is.mynote.unit3.applet;

import java.applet.Applet;
import java.awt.*;

/**
 * @author neal
 */
public class SimpleApplet extends Applet {
    @Override
    public void paint(Graphics graphics) {
        graphics.drawString("A simple applet", 120, 120);
    }
}
