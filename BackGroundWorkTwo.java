package Hideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Hideo.BackGroundWork.move;

/**
 * Created by inan on 25-Aug-16.
 */
public class BackGroundWorkTwo extends JPanel implements ActionListener,MouseListener,KeyListener
{
    public static int ballX = 380;
    static int ballY = 450;
    static int keeperX = 360;
    static int keeperY = 220;

    static int player;
    static int gameO = 0;

    static int moveX = 360;
    static int moveY = 220;
    static int triggerX = 375;
    static int triggerY = 220;
    static int click = 0;
    static String result;
    static int showTrigger = 0;
    public static int barXR = 530;
    public static int barXL = 225;
    public static int barYU = 170;
    public static int barYD = 280;



    AddPictures picture;
    AddKeeper goalKeeper;
    TriggerMark trig;

    Image image;
    Timer time2;

    public BackGroundWorkTwo()
    {
        player = 1;
        picture = new AddPictures();
        goalKeeper = new AddKeeper();
        trig = new TriggerMark();


        ImageIcon i = new ImageIcon("game_pic_final.jpg");
        image = i.getImage();
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        new ScoreCardTwo();
        time2 = new Timer(5,this);
        time2.start();

    }
    public static void setDefault()
    {
        ballX = 380;
        ballY = 450;
        keeperX = 360;
        keeperY = 220;

        gameO = 0;

        moveX = 360;
        moveY = 220;
        triggerX = 375;
        triggerY = 220;
        click = 0;

        barXR = 530;
        barXL = 225;
        barYU = 170;
        barYD = 280;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image,0,0,null);
        g2.drawImage(goalKeeper.getImage(),keeperX,keeperY,null);
        if (player == 1)
            g2.drawImage(picture.getP1(),0,150,null);

        if (showTrigger == 1)
            g2.drawImage(trig.getImage(),triggerX,triggerY,null);


        if (ballY >= 350)
            g2.drawImage(picture.getImage3(),ballX,ballY,null);
        else if (ballY < 350 && ballY > 300)
            g2.drawImage(picture.getImage2(),ballX,ballY,null);
        else
            g2.drawImage(picture.getImage1(),ballX,ballY,null);

        if (click == 2 && result == "Goal") {
            Main.music4();
            g2.drawImage(picture.getImageGoal(), 0, 150, null);
        }
        if (click == 2 && result == "Not Goal") {
            Main.music5();
            g2.drawImage(picture.getImageNotGoal(), 0, 150, null);
        }

        if (Integer.parseInt(ScoreCardTwo.tfbl.getText()) == 0 && gameO == 0)
        {
            gameO = 1;
            player = 2;
            if (player == 2)
                g2.drawImage(picture.getP2(),0,150,null);
            ScoreCardTwo.tfbl.setText("10");
        }
        if (Integer.parseInt(ScoreCardTwo.tfbl.getText()) == 0 && gameO == 1)
        {
            gameO = 0;
            if (Integer.parseInt(ScoreCardTwo.tfp1.getText()) > Integer.parseInt(ScoreCardTwo.tfp2.getText()))
            {
                new GameOverTwo("player1");
                Main.crowd.stop();
                GamePageTwo.frameTwo.setVisible(false);
            }
            else if (Integer.parseInt(ScoreCardTwo.tfp1.getText()) < Integer.parseInt(ScoreCardTwo.tfp2.getText())) {

                new GameOverTwo("player2");
                Main.crowd.stop();
                GamePageTwo.frameTwo.setVisible(false);
            }
            else {
                new GameOverTwo("draw");
                Main.crowd.stop();
                GamePageTwo.frameTwo.setVisible(false);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (ballX != triggerX && ballY != triggerY) {
            if (keeperX < moveX)
                keeperX += 50;
            if (keeperX > moveX)
                keeperX -= 50;
            if (keeperY < moveY)
                keeperY += 50;
            if (keeperY > moveY)
                keeperY -= 50;
        }
        if (click == 1)
        {
            if (ballX > triggerX)
                ballX-=4;
            if (ballX < triggerX)
                ballX+=4;
            if (ballY > triggerY)
                ballY-=4;
            if (ballY < triggerY)
                ballY+=4;

        }
        if (click == 2) {
            if (ballX >= keeperX + 5 && ballX <= keeperX + 55 && ballY >= keeperY - 20 && ballY <= keeperY + 40) {
                result = "Not Goal";
                int a = Integer.parseInt(ScoreCardTwo.tfbl.getText());
                a--;
                ScoreCardTwo.tfbl.setText(String.valueOf(a));
                time2.stop();
            }
            else if(ballX >= barXL && ballX <= barXR && ballY >= barYU && ballY <= barYD)
            {
                result = "Goal";
                int a = Integer.parseInt(ScoreCardTwo.tfbl.getText());
                a--;
                ScoreCardTwo.tfbl.setText(String.valueOf(a));

                if (gameO == 1)
                {
                    int b = Integer.parseInt(ScoreCardTwo.tfp2.getText());
                    b++;
                    ScoreCardTwo.tfp2.setText(String.valueOf(b));
                }
                if (gameO == 0)
                {
                    int b = Integer.parseInt(ScoreCardTwo.tfp1.getText());
                    b++;
                    ScoreCardTwo.tfp1.setText(String.valueOf(b));

                }

                time2.stop();

            }
            else
            {
                result = "Not Goal";
                int a = Integer.parseInt(ScoreCardTwo.tfbl.getText());
                a--;
                ScoreCardTwo.tfbl.setText(String.valueOf(a));
                time2.stop();
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (gameO == 0) {

            if (e.getKeyCode() == KeyEvent.VK_D)
                moveX += 50;
            if (e.getKeyCode() == KeyEvent.VK_A)
                moveX -= 50;
            if (e.getKeyCode() == KeyEvent.VK_W)
                moveY -= 50;
            if (e.getKeyCode() == KeyEvent.VK_S)
                moveY += 50;
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                moveX = 226;
                moveY = 170;
            }
            if (e.getKeyCode() == KeyEvent.VK_E) {
                moveX = 528;
                moveY = 170;
            }
            if (e.getKeyCode() == KeyEvent.VK_C) {
                moveX = 528;
                moveY = 270;
            }
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                moveX = 226;
                moveY = 270;
            }
            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                moveX -= 150;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                moveX += 150;
            }

            if(e.getKeyCode() == KeyEvent.VK_P)
            {
                if(showTrigger == 1)
                    showTrigger = 0;
                else
                    showTrigger = 1;
            }

            if (e.getKeyCode() == KeyEvent.VK_UP)
                triggerY -= 50;
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                triggerY += 50;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                triggerX += 50;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                triggerX -= 50;

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                click++;

                if (click == 2) {
                    System.out.println(ballX + " " + ballY);
                }
                if (click == 3) {
                    ballX = 380;
                    ballY = 450;
                    keeperX = 360;
                    keeperY = 220;
                    moveX = 360;
                    moveY = 220;
                    triggerX = 375;
                    triggerY = 220;
                    click = 0;
                    time2.start();
                }

            }
        }
        if (gameO == 1)
        {

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                moveX -= 50;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                moveX += 50;
            if (e.getKeyCode() == KeyEvent.VK_UP)
                moveY -= 50;
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                moveY += 50;
            if (e.getKeyCode() == KeyEvent.VK_INSERT) {
                moveX = 226;
                moveY = 170;
            }
            if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
                moveX = 528;
                moveY = 170;
            }
            if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
                moveX = 528;
                moveY = 270;
            }
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                moveX = 226;
                moveY = 270;
            }
            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                moveX -= 150;
            }
            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                moveX += 150;
            }

            if(e.getKeyCode() == KeyEvent.VK_P)
            {
                if(showTrigger == 1)
                    showTrigger = 0;
                else
                    showTrigger = 1;
            }

            if (e.getKeyCode() == KeyEvent.VK_W)
                triggerY -= 50;
            if (e.getKeyCode() == KeyEvent.VK_S)
                triggerY += 50;
            if (e.getKeyCode() == KeyEvent.VK_D)
                triggerX += 50;
            if (e.getKeyCode() == KeyEvent.VK_A)
                triggerX -= 50;

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                click++;

                if (click == 2) {
                    System.out.println(ballX + " " + ballY);
                }
                if (click == 3) {
                    ballX = 380;
                    ballY = 450;
                    keeperX = 360;
                    keeperY = 220;
                    moveX = 360;
                    moveY = 220;
                    triggerX = 375;
                    triggerY = 220;
                    click = 0;
                    time2.start();
                }

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        player = 0;
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
