import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * This method will create the game board
 * It will create the snake and the cherries
 * It extends the MainGui class and implements ActionListener, KeyListener and HideMenu
 */
public class PlayMenu extends MainGui implements ActionListener, KeyListener,HideMenu{

    PlayPanel playPanel;

    GameOver gameOver;

    /**
     * This creates a timer so the game can run
     */
    public Timer timer = new Timer(20,this);

    /**
     * This creates the variable for the head and the cherry
     * It will make it of type Point
     */
    public static Point head,cherry;

    //This creates the scale of the snake and cherries and gives each direction there own number so you can ref them when controlling the game
    public static final int SCALE=10,UP=0,LEFT=1,DOWN=2,RIGHT=3;

    public int direction,ticks;

    //This will set a default speed and tail value at the start of the game unless you set the difficulty in the settings
    public static int speed = 8,tail = 5,score;

    public boolean over,start;

    public Random random;

    public static ArrayList<Point> parts = new ArrayList<Point>();

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
        increaseSpeed();


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

        if(i==KeyEvent.VK_W && direction!=DOWN){
            direction = UP;
        }
        if(i==KeyEvent.VK_A && direction!=RIGHT){
            direction = LEFT;
        }
        if(i==KeyEvent.VK_S && direction!=UP){
            direction = DOWN;
        }
        if(i==KeyEvent.VK_D && direction!=LEFT){
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

        for(Point point : parts){
            if(head.equals(point)){
                over = !over;
            }
        }

        if(over){
            timer.stop();
            gameOver = new GameOver();
            hideMenu();
        }
    }

    public static void increaseSpeed(){

        ControlSpeed controlSpeed = new ControlSpeed();

        if(SettingsMenu.speedChoice==1){
            controlSpeed.easySpeed();
        }
        if(SettingsMenu.speedChoice==2){
            controlSpeed.normalSpeed();
        }
        if(SettingsMenu.speedChoice==3){
            controlSpeed.hardSpeed();
        }
    }
}
