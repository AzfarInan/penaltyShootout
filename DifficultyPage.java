package Hideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Hideo.SelectionPage.frame3;

/**
 * Created by inan on 25-Aug-16.
 */
public class DifficultyPage {

    public static JFrame frameDifficulty;
    public JButton easy;
    public JButton hard;
    public static String difficulty;
    public DifficultyPage()
    {
        frameDifficulty = new JFrame("Difficulty");
        frameDifficulty.setSize(200,100);

        JLabel a = new JLabel("               Set Difficulty                 ");
        frameDifficulty.add(a);
        easy = new JButton("Easy");
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                difficulty = "easy";
                frameDifficulty.setVisible(false);
                frame3.setVisible(false);
                new GamePage();
            }
        });
        hard = new JButton("Hard");
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                difficulty = "hard";
                frameDifficulty.setVisible(false);
                frame3.setVisible(false);
                new GamePage();
            }
        });

        frameDifficulty.add(easy);
        frameDifficulty.add(hard);
        frameDifficulty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDifficulty.setLocation(600,300);
        frameDifficulty.setVisible(true);
        frameDifficulty.setLayout(new FlowLayout());

    }
}
