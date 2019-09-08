package Hideo;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by inan on 06-Aug-16.
 */
public class MenuPage
{


    public JFrame frame2;
    public JButton play,help,credits,exit,back;

    public MenuPage()
    {
        menuPage();
    }

    public void menuPage()
    {
        frame2 = new JFrame("Penalty Shootout");
        play = new JButton("Play");
        play.setBounds(110,476,80,30);
        frame2.add(play);
        help = new JButton("Help");
        help.setBounds(260,476,80,30);
        frame2.add(help);
        credits = new JButton("Credits");
        credits.setBounds(410,476,80,30);
        frame2.add(credits);
        exit = new JButton("Exit");
        exit.setBounds(560,476,80,30);
        frame2.add(exit);
        back = new JButton("Back");
        back.setBounds(10,10,70,20);
        frame2.add(back);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectionPage();
                frame2.setVisible(false);
                Main.music();
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                new StartingPage();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HelpPage();
                frame2.setVisible(false);
            }
        });
        credits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Credits();
                frame2.setVisible(false);
            }
        });

        frame2.add(new JLabel(new ImageIcon("menu_pic.jpg")));

        frame2.setSize(800,600);
        frame2.setLocation(300,85);
        frame2.setVisible(true);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(null);


    }
}
