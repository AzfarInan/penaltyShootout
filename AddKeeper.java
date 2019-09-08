package Hideo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by inan on 22-Aug-16.
 */
public class AddKeeper {

    public static int gkX,gkY;
    Image glove;
    ImageIcon glv = new ImageIcon("goalkeeper.png");

    public AddKeeper()
    {
        gkX = 360;
        gkY = 220;
        glove = glv.getImage();
    }
    public Image getImage()
    {
        return glove;
    }
}
