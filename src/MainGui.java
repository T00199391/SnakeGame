import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {

    Dimension dim;

    JPanel panel = new JPanel();

    public MainGui(){
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,500);
        setLocation(dim.width/2-getWidth()/2,dim.height/2-getHeight()/2);
        setVisible(true);
        setResizable(false);
        panel.setBackground(Color.black);
        add(panel);
    }
}
