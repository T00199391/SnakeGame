import javax.swing.*;
import java.awt.*;

/**
 * The PlayPanel class will set up the layout of the panel for the PlayMenu class
 * It will set the color of the snake and the cherries and paint them on the panel
 * It will extend JPanel
 */
public class PlayPanel extends JPanel {

    /**
     * This method will create the paint the panel
     * It will paint the snake and the cherries
     * It will paint the score at the top of the panel
     * It will paint the message to start the game once the space bar is pressed it will disappear
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,350,500);

        g.setColor(Color.green);
        g.fillRect(PlayMenu.head.x*10,PlayMenu.head.y*10,PlayMenu.SCALE,PlayMenu.SCALE);

        g.setColor(Color.white);
        for(Point point : PlayMenu.parts){
            g.fillRect(point.x*10,point.y*10,PlayMenu.SCALE,PlayMenu.SCALE);
        }

        g.setColor(Color.red);
        g.fillRect(PlayMenu.cherry.x*10,PlayMenu.cherry.y*10,PlayMenu.SCALE,PlayMenu.SCALE);

        String scoreText = "Score: " + PlayMenu.score;
        g.setColor(Color.green);
        g.drawString(scoreText,150,10);

        String startGameText = "Press Space To Begin";
        if(PlayMenu.start){
            g.setColor(Color.green);
            g.drawString(startGameText,110,200);
        }//end if
    }//end paintComponent
}//end class
