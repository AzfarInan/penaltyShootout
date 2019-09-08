package Hideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by inan on 06-Aug-16.
 */
public class StartingPage
{

    public JFrame frame1;
    public JButton next;
    public StartingPage()
    {
        startingPage();
    }

    public void startingPage()
    {
        frame1 = new JFrame("Penalty Shootout");
        next = new JButton("Next");
        next.setBounds(573,510,80,30);


        frame1.add(next);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuPage();
                frame1.setVisible(false);
                Main.music();
            }
        });
        frame1.add(new JLabel(new ImageIcon("abstadium.jpg")));

        frame1.setSize(800,600);
        frame1.setLocation(300,85);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
    }
}
