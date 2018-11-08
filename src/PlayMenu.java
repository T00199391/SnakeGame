import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenu extends MainGui implements ActionListener,SetMenu,HideMenu {
    //Declares a JButton that closes the game when you lose
    JButton close = new JButton("Close");
    //Declares a JLabel that shows the Game Over text
    JLabel gameOver = new JLabel("GAME OVER");

    public void setMenu() {
        setHeading("Snake Game");
        Gui();
        gameOver();
    }

    public void hideMenu() {
        setVisible(false);
    }

    public void gameOver(){
        panel.setLayout(null);
        closeGame();
        gameOverLabel();
    }

    public void closeGame(){
        close.setBounds(68,400,200,40);
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        close.addActionListener(this);
        panel.add(close);
    }

    public void gameOverLabel(){
        gameOver.setBounds(30,150,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        panel.add(gameOver);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            MainMenu menu = new MainMenu();
            menu.setMenu();
            hideMenu();
        }
    }
}
