import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class PlayMenu extends MainGui implements ActionListener, KeyListener,HideMenu{

    PlayPanel playPanel;

    GameOver gameOver;

    public Timer timer = new Timer(20,this);

    public static Point head,cherry;

    public static final int SCALE=10,UP=0,LEFT=1,DOWN=2,RIGHT=3;

    public int direction,ticks;

    public static int speed = 7;

    public boolean over,start;

    public Random random;

    public static int score;

    public static ArrayList<Point> parts = new ArrayList<Point>();

    public static int tail = 5;

    public PlayMenu(){
        setTitle("Snake Game");
        add(playPanel = new PlayPanel());
        addKeyListener(this);
        gameBegins();
    }

    public void gameBegins(){
        parts.clear();
        start=true;
        ticks=0;
        direction=DOWN;
        over=false;
        head = new Point(0,0);
        random = new Random();
        cherry = new Point(random.nextInt(31),random.nextInt(46));
        score =0;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        playPanel.repaint();

        ticks++;

        if(ticks%speed==0 && !over && !start){

            parts.add(new Point(head.x,head.y));

            if(direction==UP)
            {
                head = new Point(head.x,head.y-1);
            }
            if(direction==LEFT)
            {
                head = new Point(head.x-1,head.y);
            }
            if(direction==DOWN)
            {
                head = new Point(head.x,head.y+1);
            }
            if(direction==RIGHT)
            {
                head = new Point(head.x+1,head.y);
            }

            if(parts.size()>tail){
                parts.remove(0);
            }
        }

        collisionWithCherry();
        gameOver();
        //speedIncrease();

        if(over){
            timer.stop();
            gameOver = new GameOver();
            hideMenu();
        }
    }

    @Override
    public void hideMenu() {
        setVisible(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if(i==KeyEvent.VK_ENTER){
            System.out.print(head.x);
            start = !start;
        }

        if(i==KeyEvent.VK_W){
            direction = UP;
        }
        if(i==KeyEvent.VK_A){
            direction = LEFT;
        }
        if(i==KeyEvent.VK_S){
            direction = DOWN;
        }
        if(i==KeyEvent.VK_D){
            direction = RIGHT;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void collisionWithCherry(){
        if(head.equals(cherry)){
            score++;
            tail++;
            cherry.setLocation(random.nextInt(31),random.nextInt(45));
        }
    }

    public void gameOver(){
        if(head.x<0)
            over = !over;
        if(head.x>32)
            over = !over;
        if(head.y<0)
            over = !over;
        if(head.y>45)
            over = !over;
    }

    /*public void speedIncrease(){
        if(score>=3 && score<6){
            speed-=2;
        }
        else if(score>=6 && score<9){
            speed-=2;
        }
        else if(score>=9 && score<12){
            speed-=2;
        }
        else if(score>=12 && score<20){
            speed-=2;
        }
        else{
            speed-=2;
        }
    }*/
}
