//https://www.youtube.com/watch?v=S_n3lryyGZM

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class PlayMenu extends MainGui implements ActionListener,SetMenu
{
    //Creates a snake object using the Snake class
    public static PlayMenu snake;
    //Creates a panel object using the RenderPanel class
    public PlayPanel panel;
    //This creates a timer
    public Timer timer = new Timer(20, this);

    public void setMenu(){
        setHeading("Snake Game");
        JFameGui();
        add(panel = new PlayPanel());
    }


    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        //This will repaint the panel
        panel.repaint();
    }
}