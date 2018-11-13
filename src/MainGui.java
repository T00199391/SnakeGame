import javax.swing.*;
import java.awt.*;

//Class that makes a temp gui and extends the JFrame class
public class MainGui extends JFrame {

    //The heading variable is used to store the value of the title for each Gui
    public String heading;
    //This is to declare the JPanel
    JPanel panel = new JPanel();
    //This will create a dimension object
    public Dimension dim;

    //Mutator method to set the value of heading
    public void setHeading(String heading) {
        this.heading = heading;
    }

    //Accessor method that gets the value of heading
    public String getHeading() {
        return heading;
    }

    //Method that makes the temp gui for all the menu's
    public void JFameGui(){
        //This sets the dimension object to be of the size of the screen
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        //This alters the frame for the Gui
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(getHeading());
        setSize(350,500);
        //This will make the jframes location be at the center of the screen
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        setVisible(true);
        setResizable(false);
    }

    public void JPanelGui(){
        //This alters the panel for the Gui
        panel.setBackground(Color.black);
        add(panel);
    }
}