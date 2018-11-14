//https://www.youtube.com/watch?v=S_n3lryyGZM

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class PlayMenu extends MainGui implements ActionListener, KeyListener {

    PlayPanel panel;
    Timer timer = new Timer(20,this);
    public Point head;
    public static final int UP=0,LEFT=1,DOWN=2,RIGHT=3;
    public int direction=DOWN;
    public int ticks=0;

    public PlayMenu(){
        startGame();
    }

    public void setMenu(){
        setHeading("Snake Game");
        JFameGui();
        add(panel = new PlayPanel());
        addKeyListener(this);
        startGame();
    }

    public void startGame(){
        head = new Point(3,3);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();

        if(ticks%10==0){
            if(direction==UP)
                head = new Point(head.x,head.y);
            if(direction==LEFT)
                head = new Point(head.x,head.y);
            if(direction==DOWN)
                head = new Point(head.x,head.y+1);
            if(direction==RIGHT)
                head = new Point(head.x,head.y);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if(i==KeyEvent.VK_W){
            direction=UP;
        }
        if(i==KeyEvent.VK_A){
            direction=LEFT;
        }
        if(i==KeyEvent.VK_S){
            direction=DOWN;
        }
        if(i==KeyEvent.VK_D){
            direction=RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}