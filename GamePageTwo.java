package Hideo;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Hideo.Main.clip1;

/**
 * Created by inan on 25-Aug-16.
 */
public class GamePageTwo {

    public static JFrame frameTwo;

    public GamePageTwo()
    {
        frameTwo = new JFrame("Penalty Shootout");

        frameTwo.setSize(800, 600);

        clip1.stop();
        Main.music2();

        frameTwo.add(new BackGroundWorkTwo());

        frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frameTwo.setVisible(true);
        frameTwo.setLocationRelativeTo(null);
        frameTwo.setResizable(false);
        //frameTwo.setLayout(null);
    }
}
