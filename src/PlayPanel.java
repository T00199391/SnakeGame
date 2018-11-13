import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PlayPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics g) {
        //This will paint the componment
        super.paintComponent(g);
        //This sets the color of the panel
        g.setColor(Color.black);
        //This will fill in the bounds of the panel
        g.fillRect(0, 0, 350, 500);
    }
}