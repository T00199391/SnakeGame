import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends MainGui implements ActionListener,SetMenu,HideMenu {
    //Declares a JButton that that takes you back to the main menu when you lose the game
    JButton close = new JButton("Close");
    //Declares a JLabel that shows the Game Over text
    JLabel gameOver = new JLabel("GAME OVER");

    //Method that sets the menu
    public void setMenu() {
        setHeading("Snake Game");
        JFameGui();
        JPanelGui();
        gameOver();
    }

    //Method that will hide the previous gui
    public void hideMenu() {
        setVisible(false);
    }

    //Method that sets the game over screen
    public void gameOver(){
        panel.setLayout(null);
        closeGame();
        gameOverLabel();
    }

    //Method that alters the close button adn adds it to the panel
    public void closeGame(){
        close.setBounds(68,400,200,40);
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        close.addActionListener(this);
        panel.add(close);
    }

    //Method that alters the gameOver label and adds it to the panel
    public void gameOverLabel(){
        gameOver.setBounds(30,150,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        panel.add(gameOver);
    }

    //Method will determine what will happen when you press the close button
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            MainMenu menu = new MainMenu();
            menu.setMenu();
            hideMenu();
        }
    }
}
