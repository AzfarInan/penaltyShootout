package Hideo;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Hideo.BackGroundWork.initX;
import static Hideo.BackGroundWork.initY;
import static Hideo.BackGroundWork.move;
import static Hideo.Main.clip1;
import static Hideo.Main.crowd;
import static Hideo.ScoreCard.tfb;
import static Hideo.ScoreCard.tfc;
import static Hideo.ScoreCard.tfp;

/**
 * Created by inan on 24-Aug-16.
 */
public class GameOver {
    public static JFrame frameG;
    public static String msg;

    public GameOver(String txt)
    {
        this.msg = txt;
        frameG = new JFrame("GAME OVER");


        JButton A = new JButton("Retry");
        A.setBounds(110,476,80,30);
        A.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameOver.frameG.setVisible(false);
                ScoreCard.frameS.setVisible(false);
                ScoreCard.resetScoreCard();
                crowd.start();
                BackGroundWork.setDefault();
                new GamePage();
            }
        });
        JButton B = new JButton("Menu");
        B.setBounds(260,476,80,30);
        B.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GameOver.frameG.setVisible(false);
                ScoreCard.resetScoreCard();
                BackGroundWork.setDefault();
                clip1.start();
                clip1.loop(Clip.LOOP_CONTINUOUSLY);
                ScoreCard.frameS.setVisible(false);
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

        frameG.add(A);
        frameG.add(B);
        frameG.add(C);

        if (msg == "win")
            frameG.add(new JLabel(new ImageIcon("win.png")));
        else if (msg == "lost")
            frameG.add(new JLabel(new ImageIcon("lost.png")));
        else if (msg == "draw")
            frameG.add(new JLabel(new ImageIcon("draw.png")));



        frameG.setSize(800,600);
        frameG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameG.setVisible(true);
        frameG.setLocationRelativeTo(null);
        frameG.setLayout(null);
    }
}
