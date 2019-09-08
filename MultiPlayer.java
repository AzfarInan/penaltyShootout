package Hideo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MultiPlayer {

    public JFrame MFrame;
    public JButton back;

    public MultiPlayer()
        {
            MFrame = new JFrame("Penalty Shootout");

            back = new JButton("Back");
            back.setBounds(10,10,70,20);
            MFrame.add(back);

            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MFrame.setVisible(false);
                    new SelectionPage();
                }
            });

            MFrame.add(new JLabel(new ImageIcon("Multi.jpg")));
            MFrame.setSize(800,600);
            MFrame.setLocation(300,85);
            MFrame.setVisible(true);

            MFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MFrame.setLayout(null);

        }

}


