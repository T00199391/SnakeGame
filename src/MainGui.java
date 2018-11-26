import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {

    public Dimension dim;

    public JPanel panel = new JPanel();

    public MainGui(){
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
    }//end constructor
}//end class
