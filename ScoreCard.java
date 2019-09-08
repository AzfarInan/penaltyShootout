package Hideo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by inan on 24-Aug-16.
 */
public class ScoreCard {
    public static JFrame frameS;
    public static JTextField tfp,tfc,tfb;
    public JLabel player,computer,ballsLeft;


    public ScoreCard()
    {
        frameS = new JFrame("Score Card");


        player = new JLabel("Player : ");
        frameS.add(player);
        tfp = new JTextField("0",10);
        tfp.setEditable(false);
        frameS.add(tfp);
        computer = new JLabel("Computer : ");
        frameS.add(computer);
        tfc = new JTextField("0",10);
        tfc.setEditable(false);
        frameS.add(tfc);
        ballsLeft = new JLabel("Balls Left : ");
        frameS.add(ballsLeft);
        tfb = new JTextField("10",10);
        tfb.setEditable(false);
        frameS.add(tfb);






        frameS.setSize(250,130);
        frameS.setLocation(1100,200);
        frameS.setVisible(true);

        frameS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frameS.setLayout(new FlowLayout());

    }
    public static void resetScoreCard()
    {
        tfp.setText("0");
        tfc.setText("0");
        tfb.setText("10");
    }
}
