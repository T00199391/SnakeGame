import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,350,500);

        g.setColor(Color.white);
        g.fillRect(PlayMenu.head.x,PlayMenu.head.y,PlayMenu.SCALE,PlayMenu.SCALE);
    }
}
