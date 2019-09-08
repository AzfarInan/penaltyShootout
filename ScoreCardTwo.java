package Hideo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by inan on 25-Aug-16.
 */
public class ScoreCardTwo {
    public static JFrame frameST;
    public static JTextField tfp1,tfp2,tfbl;
    public JLabel player1,player2,left;


    public ScoreCardTwo()
    {
        frameST = new JFrame("Score Card");


        player1 = new JLabel("Player1:");
        frameST.add(player1);
        tfp1 = new JTextField("0",10);
        tfp1.setEditable(false);
        frameST.add(tfp1);
        player2 = new JLabel("      Player2:");
        frameST.add(player2);
        tfp2 = new JTextField("0",10);
        tfp2.setEditable(false);
        frameST.add(tfp2);
        left = new JLabel("Balls Left:");
        frameST.add(left);
        tfbl = new JTextField("10",10);
        tfbl.setEditable(false);
        frameST.add(tfbl);






        frameST.setSize(250,130);
        frameST.setLocation(1100,200);
        frameST.setVisible(true);

        frameST.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frameST.setLayout(new FlowLayout());

    }
    public static void resetScoreCard()
    {
        tfp1.setText("0");
        tfp2.setText("0");
        tfbl.setText("10");
    }
}

