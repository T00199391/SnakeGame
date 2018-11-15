import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver implements ActionListener{
    //Declares a JButton that that takes you back to the main menu when you lose the game
    JButton close = new JButton("Close");
    //Declares a JLabel that shows the Game Over text
    JLabel gameOver = new JLabel("GAME OVER");

    MainGui gui = new MainGui();

    //Method that sets the menu
    public GameOver(){
        gameOver();
    }

    //Method that sets the game over screen
    public void gameOver(){
        gui.panel.setBackground(Color.black);
        gui.add(gui.panel);
        gui.panel.setLayout(null);
        closeGame();
        gameOverLabel();
    }

    //Method that alters the close button adn adds it to the panel
    public void closeGame(){
        close.setBounds(68,400,200,40);
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        close.addActionListener(this);
        gui.panel.add(close);
    }

    //Method that alters the gameOver label and adds it to the panel
    public void gameOverLabel(){
        gameOver.setBounds(30,150,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        gui.panel.add(gameOver);
    }

    //Method will determine what will happen when you press the close button
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            System.exit(0);
        }
    }
}
