package Hideo;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Hideo.Main.clip1;
import static Hideo.Main.crowd;

/**
 * Created by inan on 26-Aug-16.
 */
public class GameOverTwo {

    public static JFrame frameGT;
    public static String txt;

    public GameOverTwo(String txt)
    {
        this.txt = txt;
        frameGT = new JFrame("GAME OVER");


        JButton A = new JButton("Retry");
        A.setBounds(110,476,80,30);
        A.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameOverTwo.frameGT.setVisible(false);
                ScoreCardTwo.frameST.setVisible(false);
                ScoreCardTwo.resetScoreCard();
                crowd.start();
                BackGroundWorkTwo.setDefault();
                new GamePageTwo();
            }
        });
        JButton B = new JButton("Menu");
        B.setBounds(260,476,80,30);
        B.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GameOverTwo.frameGT.setVisible(false);
                ScoreCardTwo.resetScoreCard();
                BackGroundWorkTwo.setDefault();
                clip1.start();
                clip1.loop(Clip.LOOP_CONTINUOUSLY);
                ScoreCardTwo.frameST.setVisible(false);
                new MenuPage();
            }
        });
        JButton C = new JButton("Exit");
        C.setBounds(410,476,80,30);
        C.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frameGT.add(A);
        frameGT.add(B);
        frameGT.add(C);

        if (txt == "player1")
            frameGT.add(new JLabel(new ImageIcon("palyer1won.jpg")));
        else if (txt == "player2")
            frameGT.add(new JLabel(new ImageIcon("player2won.png")));
        else if (txt == "draw")
            frameGT.add(new JLabel(new ImageIcon("draw.png")));



        frameGT.setSize(800,600);
        frameGT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGT.setVisible(true);
        frameGT.setLocationRelativeTo(null);
        frameGT.setLayout(null);
    }
}
