import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class will display the game over screen when called from the PlayMenu
 * @author Emma Fitzgerald T00199391
 */
public class GameOver implements ActionListener{

    JButton close = new JButton("Close");

    JLabel gameOver = new JLabel("GAME OVER");

    MainGui gui = new MainGui();

    /**
     * GameOver Constructor that will display the game over gui
     * It will call the methods closeGame and gameOverLabel
     */
    public GameOver(){
        gui.setTitle("Game Over");
        gui.panel.setBackground(Color.black);
        gui.panel.setLayout(null);
        closeGame();
        gameOverLabel();
    }//end constructor

    /**
     * This method will create a close button
     * It will add an ActionListener to the button
     * It will add the button to the panel
     */
    public void closeGame(){
        close.setBounds(68,400,200,40);
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        close.addActionListener(this);
        gui.panel.add(close);
    }//end method

    /**
     * This method will create the label that displays the game over dialog
     * It will add the label to the panel
     */
    public void gameOverLabel(){
        gameOver.setBounds(30,150,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        gui.panel.add(gameOver);
    }//end method

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close)
            System.exit(0);

    }//end method
}//end class
