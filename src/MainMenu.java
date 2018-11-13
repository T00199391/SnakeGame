import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class that makes the main menu
public class MainMenu extends MainGui implements ActionListener,SetMenu,HideMenu{

    //Declares a Jbutton that wen clicked will take you to the play screen
    JButton play = new JButton("Play");
    //Declares a JButton that when clicked will take you to the settings menu
    JButton settings = new JButton("Settings");
    //Declares a JButton that when clicked will exit the game
    JButton exit = new JButton("Exit");
    //Declares a JLabel that will display the name of the game
    JLabel title = new JLabel("Snake Game");

    //Method that sets the menu
    public void setMenu(){
        setHeading("Main Menu");
        JFameGui();
        JPanelGui();
        panel.setLayout(null);
        addingButtons();
        addLabel();
    }

    //Method that will hide the previous gui
    public void hideMenu() {
        setVisible(false);
    }

    //Metjod that will alter the play,settings and exit buttons and add them to the panel
    public void addingButtons(){
        play.setBounds(68,150,200,40);
        play.addActionListener(this);
        play.setBackground(Color.white);
        play.setForeground(Color.black);

        settings.setBounds(68,250,200,40);
        settings.addActionListener(this);
        settings.setBackground(Color.white);
        settings.setForeground(Color.black);

        exit.setBounds(68,350,200,40);
        exit.addActionListener(this);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);

        panel.add(play);
        panel.add(settings);
        panel.add(exit);
    }

    //Method that will alter the title label and add it to the panel
    public void addLabel(){
        title.setBounds(90,50,200,40);
        title.setFont(new Font("monospaced",Font.PLAIN,25));
        title.setForeground(Color.white);
        title.setVisible(true);
        panel.add(title);
    }

    //https://stackoverflow.com/questions/5936261/how-to-add-action-listener-that-listens-to-multiple-buttons
    //Method will determine what will happen when you press one of the buttons
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            PlayMenu menu = new PlayMenu();
            menu.setMenu();
            hideMenu();
        }
        else if(e.getSource() == settings){
            SettingsMenu menu = new SettingsMenu();
            menu.setMenu();
            hideMenu();
        }
        else{
            System.exit(0);
        }
    }
}
