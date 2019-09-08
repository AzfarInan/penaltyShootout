package Hideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by inan on 22-Aug-16.
 */
public class TriggerMark  {


    Image t;
    ImageIcon t1 = new ImageIcon("mark.png");

    public TriggerMark()
    {
        t = t1.getImage();
    }
    public Image getImage()
    {
        return t;
    }
}
