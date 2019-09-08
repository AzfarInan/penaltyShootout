package Hideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.text.AttributedCharacterIterator;

import static Hideo.Main.clip1;
import static Hideo.Main.crowd;


/**
 * Created by inan on 15-Aug-16.
 */
public class GamePage {

    public static JFrame frame4;

    public GamePage(){
        frame4 = new JFrame("Penalty Shootout");

        frame4.setSize(800, 600);
        clip1.stop();
        Main.music2();
        frame4.add(new BackGroundWork());

        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame4.setVisible(true);
        frame4.setLocationRelativeTo(null);
        frame4.setResizable(false);

    }
}

