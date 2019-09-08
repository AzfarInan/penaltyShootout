package Hideo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by inan on 27-Aug-16.
 */
public class Credits {
    public JFrame Frame;
    public JButton back;

    public Credits()
    {
        Frame = new JFrame("Penalty Shootout");

        back = new JButton("Back");
        back.setBounds(10,10,70,20);
        Frame.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame.setVisible(false);
                new MenuPage();
            }
        });

        Frame.add(new JLabel(new ImageIcon("credits.jpg")));
        Frame.setSize(800,600);
        Frame.setLocation(300,85);
        Frame.setVisible(true);

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(null);
    }
}
