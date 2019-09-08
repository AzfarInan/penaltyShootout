package Hideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static Hideo.DifficultyPage.difficulty;
import static Hideo.GamePage.frame4;
import static Hideo.Main.crowd;


public class BackGroundWork extends JPanel implements ActionListener,MouseListener
{

    static int initX = 380;
    static int initY = 450;
    static int gloveX = 360;
    static int gloveY = 220;
    static int markX = 375;
    static int markY = 220;

    static int move = 0;
    static int MouseX = -5;
    static int MouseY = 5;

    static int diffX;
    static int diffY;

    AddPictures football;
    AddKeeper gloves;
    TriggerMark mark;
    Image img;
    Timer timeX;
    static Random rn = new Random();
    static int randomX;
    static int randomY;
    static int randomCatch;

    int barXR = 495;
    int barXL = 255;
    int barYU = 165;
    int barYD = 280;

    public static String status;



    public BackGroundWork()
    {

        football = new AddPictures();
        gloves = new AddKeeper();
        mark = new TriggerMark();

        ImageIcon i = new ImageIcon("game_pic_final.jpg");
        img = i.getImage();
        addMouseListener(this);
        timeX = new Timer(10,this);
        timeX.start();

        new ScoreCard();

    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img,0,0,null);


        g2.drawImage(gloves.getImage(),gloveX,gloveY,null);


        if (initY >= 350)
            g2.drawImage(football.getImage3(),initX,initY,null);
        else if (initY < 350 && initY > 300)
            g2.drawImage(football.getImage2(),initX,initY,null);
        else
            g2.drawImage(football.getImage1(),initX,initY,null);

        if (move == 3 && status == "Goal") {
            Main.music4();
            g2.drawImage(football.getImageGoal(), 0, 150, null);
        }
        if (move == 3 && status == "Not Goal") {
            Main.music5();
            g2.drawImage(football.getImageNotGoal(), 0, 150, null);
        }

        if (move < 2)
            g2.drawImage(mark.getImage(),markX,markY,null);
        if (Integer.parseInt(ScoreCard.tfb.getText()) == 0)
        {
            if (Integer.parseInt(ScoreCard.tfp.getText()) > Integer.parseInt(ScoreCard.tfc.getText()))
            {
                new GameOver("win");
                Main.crowd.stop();
                GamePage.frame4.setVisible(false);
            }
            else if (Integer.parseInt(ScoreCard.tfp.getText()) < Integer.parseInt(ScoreCard.tfc.getText())) {

                new GameOver("lost");
                Main.crowd.stop();
                GamePage.frame4.setVisible(false);
            }
            else {
                new GameOver("draw");
                Main.crowd.stop();
                GamePage.frame4.setVisible(false);
            }

        }

    }
    public static void setDefault()
    {
        initX = 380;
        initY = 450;
        gloveX = 360;
        gloveY = 220;
        markX = 375;
        markY = 220;

        move = 0;
        MouseX = -5;
        MouseY = 5;
    }

    public void actionPerformed(ActionEvent e) {
        if (move == 0) {
            if (markX == barXR) {
                MouseX = 5;
            }
            if (markX == barXL) {
                MouseX = -5;
            }
                markX -= MouseX;
        }
        if (move == 1){
            if (markY == barYU){
                MouseY = -5;
            }
            if (markY == barYD){
                MouseY = 5;
            }
            markY -= MouseY;
        }
        if (move == 2 && initX != markX)
        {
            if (diffX > 0) {
                initX += 5;
            }
            if (diffX < 0)
                initX -=5;
        }
        if (move == 2 && initY != markY)
            initY -= 5;

        if (move == 2 && initY <= 365)
        {
            if (gloveX >= randomX)
                gloveX -= 5;
            if (gloveX <= randomX)
                gloveX += 5;
            if (gloveY >= randomY)
                gloveY -= 5;
            if (gloveY <= randomY)
                gloveY += 5;
        }
        if(move == 3)
        {
            if (initX >= gloveX+5 && initX <= gloveX+55 && initY >= gloveY-20 && initY <= gloveY+40) {
                status = "Not Goal";
                int a = Integer.parseInt(ScoreCard.tfb.getText());
                a--;
                ScoreCard.tfb.setText(String.valueOf(a));
                int b = Integer.parseInt(ScoreCard.tfc.getText());
                b++;
                ScoreCard.tfc.setText(String.valueOf(b));
                timeX.stop();
            }
            else {
                status = "Goal";
                int a = Integer.parseInt(ScoreCard.tfb.getText());
                a--;
                ScoreCard.tfb.setText(String.valueOf(a));
                int b = Integer.parseInt(ScoreCard.tfp.getText());
                b++;
                ScoreCard.tfp.setText(String.valueOf(b));
                timeX.stop();

            }
        }


        repaint();
    }
    public void mouseClicked(MouseEvent e) {
        move++;
        if (move == 2){
            Main.music3();
            diffX = markX - initX;
            diffY = initY - markY;

            randomCatch = rn.nextInt(10);
            System.out.println(randomCatch);
            if (difficulty == "easy") {
                if (randomCatch == 1 || randomCatch == 2 || randomCatch == 0) {
                    randomX = markX - 25;
                    randomY = markY - 14;
                } else {
                    randomX = barXL + rn.nextInt(241);
                    randomY = barYU + rn.nextInt(116);
                }
            }
            else if (difficulty == "hard")
            {
                if (randomCatch%2 == 0) {
                    randomX = markX - 25;
                    randomY = markY - 14;
                } else {
                    randomX = barXL + rn.nextInt(241);
                    randomY = barYU + rn.nextInt(116);
                }
            }

        }

        if (move == 5) {
            move = 0;
            initX = 380;
            initY = 450;
            markX = 375;
            markY = 220;
            gloveX = 360;
            gloveY = 220;
            timeX.start();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
