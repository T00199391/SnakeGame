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
 * @author Emma Fitzgerald T00199391
 */
public class PlayMenu extends MainGui implements ActionListener, KeyListener,HideMenu{

    private PlayPanel playPanel;

    private GameOver gameOver;

    /**
     * This creates a timer so the game can run
     */
    private Timer timer = new Timer(20,this);

    /**
     * This creates the variable for the head and the cherry
     * It will make it of type Point
     */
    public static Point head,cherry;

    //This creates the scale of the snake and cherries and gives each direction there own number so you can ref them when controlling the game
    private static boolean up=false,left=false,down=true,right=false;

    //This variable will set te scale which will be used to set the size of the snake and the cherries
    //This variable is also used to make the snake movement be like its in a grid
    public static final int SCALE=10;

    //The ticks variable is used to hold the value of the timer and is then used to help control the speed of the game
    public int ticks;

    //This will set a default speed and tail value at the start of the game unless you set the difficulty in the settings
    //This will create a variable to hold the score for the player
    public static int speed = 8,tail = 5,score;

    //The variable over will be used to see if the user gets a game over
    //The variable start will make the game begin wen the user presses a certain button
    private boolean over;

    //This variable is used to start the game. When the space bar is pressed the variable will turn to true and the game will begin
    public static boolean start;

    //This variable is used to make sure the game can only be started once
    private int startCount=0;

    public Random random;

    //This will create a list of snake parts of type point
    public static ArrayList<Point> parts = new ArrayList<Point>();

    /**
     * PlayMenu Constructor
     * It wil set the title of the gui
     * It will add the PlayPanel class as the default panel for this gui
     * It will add a keyListener to the gui
     * It calls the gameBegins method
     */
    public PlayMenu(){
        setTitle("Snake Game");
        add(playPanel = new PlayPanel());
        addKeyListener(this);
        gameBegins();
    }//end constructor

    /**
     * This method sets all the variables at the start of the game
     * It will clear any extra parts of the snake at the beginning of the game
     * It will set a start point for the head and cherry
     * It will start the timer so the ame can begin
     */
    public void gameBegins(){
        head = new Point(0,0);
        random = new Random();
        cherry = new Point(random.nextInt(29),random.nextInt(44));
        parts.clear();
        start=true;
        ticks=0;
        over=false;
        score =0;
        timer.start();
    }//end method

    /**
     *This method will run every game loop because it is tied to the timer
     * It will repaint the whole panel every game loop
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        playPanel.repaint();

        //This increments the ticks variable every game loop
        ticks++;

        if(ticks%speed==0 && !over && !start){

            parts.add(new Point(head.x,head.y));

            if(up)
                head = new Point(head.x,head.y-1);

            if(left)
                head = new Point(head.x-1,head.y);

            if(down)
                head = new Point(head.x,head.y+1);

            if(right)
                head = new Point(head.x+1,head.y);


            if(parts.size()>tail){
                parts.remove(0);
            }//end if

        }//end if

        collisionWithCherry();
        gameOver();
        increaseSpeed();

    }//end actionPerformed

    @Override
    public void hideMenu() {
        setVisible(false);
    }//end method

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if(startCount==0) {
            if (i == KeyEvent.VK_SPACE) {
                start = !start;
            }
            startCount++;
        }

        if((i==KeyEvent.VK_W || i==KeyEvent.VK_UP) && !down ){
            up = true;
            left = false;
            down = false;
            right = false;
        }
        if((i==KeyEvent.VK_A || i==KeyEvent.VK_LEFT) && !right){
            up = false;
            left = true;
            down = false;
            right = false;
        }
        if((i==KeyEvent.VK_S || i==KeyEvent.VK_DOWN) && !up){
            up = false;
            left = false;
            down = true;
            right = false;
        }
        if((i==KeyEvent.VK_D || i==KeyEvent.VK_RIGHT) && !left){
            up = false;
            left = false;
            down = false;
            right = true;
        }
    }//end keyPressed

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * This method is used to increase the score and the tail length when the snake collects a cherry
     * It will also move the cherry to a new random location on the map
     */
    private void collisionWithCherry(){
        if(head.equals(cherry)){
            score++;
            tail++;
            cherry.setLocation(random.nextInt(29),random.nextInt(44));
        }//end if
    }//end method

    /**
     * This method is used to determine when the game is over
     */
    private void gameOver(){
        if(head.x<0)
            over = !over;

        if(head.x>32)
            over = !over;

        if(head.y<0)
            over = !over;

        if(head.y>45)
            over = !over;

        for(Point point : parts){
            if(head.equals(point))
                over = !over;
        }//end for loop

        if(over){
            timer.stop();
            gameOver = new GameOver();
            hideMenu();
        }//end if
    }//end method

    /**
     * This method will call the methods from the ControlSpeed class to determine the
     * speed of the snake when the score increases.
     * It will cal different methods depending on the difficulty level
     */
    private static void increaseSpeed(){

        ControlSpeed controlSpeed = new ControlSpeed();

        if(SettingsMenu.speedChoice==1)
            controlSpeed.easySpeed();

        if(SettingsMenu.speedChoice==2)
            controlSpeed.normalSpeed();

        if(SettingsMenu.speedChoice==3)
            controlSpeed.hardSpeed();

    }//end method
}//end class
