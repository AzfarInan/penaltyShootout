package Hideo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by inan on 27-Aug-16.
 */
public class HelpPage {
    public JFrame helpFrame;
    public JButton back;

    public HelpPage()
    {
        helpFrame = new JFrame("Penalty Shootout");

        back = new JButton("Back");
        back.setBounds(10,10,70,20);
        helpFrame.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                helpFrame.setVisible(false);
                new MenuPage();
            }
        });

        helpFrame.add(new JLabel(new ImageIcon("Help.jpg")));
        helpFrame.setSize(800,600);
        helpFrame.setLocation(300,85);
        helpFrame.setVisible(true);

        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setLayout(null);
    }
}
