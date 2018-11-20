import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PlayMenu extends MainGui implements ActionListener, KeyListener,HideMenu{

    PlayPanel playPanel;

    GameOver gameOver;

    public Timer timer = new Timer(20,this);

    public static Point head,cherry;

    public static final int SCALE=10,UP=0,LEFT=1,DOWN=2,RIGHT=3;

    public int direction,ticks;

    public static int speed = 10;

    public boolean over,start;

    public Random random;

    public PlayMenu(){
        setTitle("Snake Game");
        add(playPanel = new PlayPanel());
        addKeyListener(this);
        gameBegins();
    }

    public void gameBegins(){
        start=true;
        ticks=0;
        direction=DOWN;
        over=false;
        head = new Point(0,0);
        random = new Random();
        cherry = new Point(random.nextInt(31),random.nextInt(46));
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        playPanel.repaint();

        ticks++;

        if(ticks%10==0 && !over && !start){
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
        }

        collisionWithCherry();
        gameOver();

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

        if(i==KeyEvent.VK_SPACE) {

        }

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
            cherry.setLocation(random.nextInt(31),random.nextInt(45));
        }
    }

    public void gameOver(){
        if(head.x<0)
            over = !over;
        if(head.x>31)
            over = !over;
        if(head.y<0)
            over = !over;
        if(head.y>44)
            over = !over;
    }
}
