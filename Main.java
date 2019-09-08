package Hideo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main {

    public static Clip clip;
    public static Clip clip1;
    public static Clip ball;
    public static Clip crowd;
    public static Clip goal;
    public static Clip notGoal;

    public static void music() {

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("click.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void music1() {

        try {

            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("back_music.wav"));
            clip1 = AudioSystem.getClip();
            clip1.open(audio);
            clip1.start();
            clip1.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void music2() {

        try {

            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("ole.wav"));
            crowd = AudioSystem.getClip();
            crowd.open(audio);
            crowd.start();
            crowd.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void music3() {

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("ballHit.wav"));
            ball = AudioSystem.getClip();
            ball.open(audio);
            ball.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void music4() {

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("goalCheer.wav"));
            goal = AudioSystem.getClip();
            goal.open(audio);
            goal.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void music5() {

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("boo.wav"));
            notGoal = AudioSystem.getClip();
            notGoal.open(audio);
            notGoal.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        new StartingPage();
        music1();
    }
}
