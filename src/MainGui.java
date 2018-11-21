import javax.swing.*;
import java.awt.*;

/**
 * This class creates a template gui for the whole game
 * It extends JFrame and uses a JPanel
 */
public class MainGui extends JFrame {

    Dimension dim;

    JPanel panel = new JPanel();

    public MainGui(){
        /**
         * This variable is used to hold the size of the screen
         * Toolkit will return the complete resolution of the screen
         */
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,500);
        //This will make the gui be at the center of the screen no matter what resolution it is played on
        setLocation(dim.width/2-getWidth()/2,dim.height/2-getHeight()/2);
        setVisible(true);
        //This will make sure that the user can't increase the size of the gui
        setResizable(false);
        panel.setBackground(Color.black);
        add(panel);
    }
}
