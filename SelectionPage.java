package Hideo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by inan on 12-Aug-16.
 */
public class SelectionPage {
    public static JFrame frame3;
    public JButton one;
    public JButton two;
    public JButton multi;
    public JButton back;

    public SelectionPage()
    {
        selectionPage();
    }
    public void selectionPage()
    {
        frame3 = new JFrame("Penalty Shootout");

        one = new JButton("Single Player");
        one.setBounds(38,513,180,30);
        frame3.add(one);
        two = new JButton("Two Players");
        two.setBounds(300,513,180,30);
        frame3.add(two);
        multi = new JButton("Online");
        multi.setBounds(570,513,180,30);
        frame3.add(multi);
        back = new JButton("Back");
        back.setBounds(10,10,70,20);
        frame3.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(false);
                new MenuPage();
            }
        });

        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DifficultyPage();
                Main.music();
            }
        });
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GamePageTwo();
                Main.music();
                frame3.setVisible(false);

            }
        });
        multi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MultiPlayer();
                frame3.setVisible(false);
            }
        });

        frame3.add(new JLabel(new ImageIcon("selection_page.jpg")));
        frame3.setSize(800,600);
        frame3.setLocation(300,85);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLayout(null);
    }
}
