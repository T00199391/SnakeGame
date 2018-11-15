import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayMenu extends MainGui implements ActionListener, KeyListener,HideMenu{

    PlayPanel playPanel;

    Timer timer = new Timer(0,this);

    public static Point head;

    public static final int SCALE=10,UP=0,LEFT=1,DOWN=2,RIGHT=3;

    public int direction,ticks;

    public static int speed =70;

    public boolean over;

    public PlayMenu(){
        setTitle("Snake Game");
        remove(panel);
        add(playPanel = new PlayPanel());
        addKeyListener(this);
        gameBegins();
    }

    public void gameBegins(){
        ticks=0;
        direction=DOWN;
        over=false;
        head = new Point(3,3);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playPanel.repaint();

        ticks++;

        if(ticks%speed==0 && !over){
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
    }

    @Override
    public void hideMenu() {
        setVisible(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if(i==KeyEvent.VK_SPACE) {
            GameOver gameOver = new GameOver();
            hideMenu();
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
}
