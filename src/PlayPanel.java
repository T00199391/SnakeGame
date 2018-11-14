import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PlayPanel extends JPanel
{


    @Override
    protected void paintComponent(Graphics g) {
        PlayMenu game = new PlayMenu();
        //This will paint the componment
        super.paintComponent(g);
        //This sets the color of the panel
        g.setColor(Color.black);
        //This will fill in the bounds of the panel
        g.fillRect(0, 0, 350, 500);
        //This will set the color of the snake
        g.setColor(Color.white);
        //This will set the point of the head
        g.fillRect(game.head.x,game.head.y,10,10);
    }
}