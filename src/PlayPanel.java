import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,350,500);

        g.setColor(Color.green);
        g.fillRect(PlayMenu.head.x*10,PlayMenu.head.y*10,PlayMenu.SCALE,PlayMenu.SCALE);

        g.setColor(Color.red);
        g.fillRect(PlayMenu.cherry.x*10,PlayMenu.cherry.y*10,PlayMenu.SCALE,PlayMenu.SCALE);

        String scoreText = "Score: " + PlayMenu.score;
        g.setColor(Color.green);
        g.drawString(scoreText,(getWidth()/2)-20,10);

        g.setColor(Color.white);
        for(Point point : PlayMenu.parts){
            g.fillRect(point.x*10,point.y*10,10,10);
        }
    }
}
