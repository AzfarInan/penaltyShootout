package Hideo;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by inan on 22-Aug-16.
 */
public class AddPictures
{
    Image image3,image2,image1;
    Image goal,notGoal;
    Image playerOne, playerTwo;

    ImageIcon i3 = new ImageIcon("3.png");
    ImageIcon i2 = new ImageIcon("2.png");
    ImageIcon i1 = new ImageIcon("1.png");

    ImageIcon g = new ImageIcon("goal.png");
    ImageIcon ng = new ImageIcon("not goal.jpg");

    ImageIcon p1 = new ImageIcon("player1.png");
    ImageIcon p2 = new ImageIcon("player2.png");

    public AddPictures()
    {
        image3 = i3.getImage();
        image2 = i2.getImage();
        image1 = i1.getImage();
        goal = g.getImage();
        notGoal = ng.getImage();
        playerOne = p1.getImage();
        playerTwo = p2.getImage();
    }
    public Image getImageGoal()
    {
        return goal;
    }
    public Image getImageNotGoal()
    {
        return notGoal;
    }
    public Image getImage3()
    {
        return image3;
    }
    public Image getImage2()
    {
        return image2;
    }
    public Image getImage1()
    {
        return image1;
    }
    public Image getP1()
    {
        return playerOne;
    }
    public Image getP2()
    {
        return playerTwo;
    }


}
