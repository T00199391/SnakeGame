import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class will display the game over screen when called from the PlayMenu
 * @author Emma Fitzgerald T00199391
 */
public class GameOver implements ActionListener{

    JButton close = new JButton("Close");

    JLabel gameOver = new JLabel("GAME OVER");

    JLabel nameLabel = new JLabel("Please Enter Name(4 characters)");

    MainGui gui = new MainGui();

    PlayersInfo leader;

    String fileName;

    JTextField textBox = new JTextField(4);

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
        nameTextLabel();
        textBox();
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
        gameOver.setBounds(30,50,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        gui.panel.add(gameOver);
    }//end method

    public void nameTextLabel(){
        nameLabel.setBounds(30,200,300,60);
        nameLabel.setFont(new Font("monospaced",Font.PLAIN,15));
        nameLabel.setForeground(Color.white);
        gui.panel.add(nameLabel);
    }//end method

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close) {
            if (textBox.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
                return;
            }
            else if(textBox.getText().length()>4){
                JOptionPane.showMessageDialog(null, "Name must be 4 characters or less");
                return;
            }
            else{
                enterScore();
                System.exit(0);
            }//end if
        }//end if
    }//end method

    public void textBox(){
        textBox.setBounds(90,250,150,20);
        gui.panel.add(textBox);
    }

    public void enterScore(){
        leader = new PlayersInfo(textBox.getText(),PlayMenu.score);

        if(SettingsMenu.numChoice==1){
            fileName = "src/Resources/easyScore.txt";
        }
        if(SettingsMenu.numChoice==2){
            fileName = "src/Resources/normalScore.txt";
        }
        if(SettingsMenu.numChoice==3){
            fileName = "src/Resources/hardScore.txt";
        }

        //https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
        try {
            FileWriter fw = new FileWriter(fileName,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(leader.toString());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}//end class
