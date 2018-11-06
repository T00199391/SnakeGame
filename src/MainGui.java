import javax.swing.*;
import java.awt.*;

//Class that makes a temp gui and extends the JFrame class
public class MainGui extends JFrame {

    //Variable used to store the heading value
    public String heading;
    //Declare the JPanel
    JPanel panel = new JPanel();

    //Mutator method to set the heading
    public void setHeading(String heading) {
        this.heading = heading;
    }

    //Accessor method to get the heading
    public String getHeading() {
        return heading;
    }

    //Method that makes the gui
    public void Gui(){
        //Frame
        setTitle(getHeading());
        setLocation(200,200);
        setSize(350,500);

        //Panel
        panel.setBackground(Color.black);
        setContentPane(panel);
    }

}
