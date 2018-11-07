import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class that makes the main menu
public class MainMenu extends MainGui implements ActionListener,SetMenu,HideMenu{

    //Declares the play button
    JButton play = new JButton("Play");
    //Declares the settings button
    JButton settings = new JButton("Settings");
    //Declares an exit button
    JButton exit = new JButton("Exit");
    //Declares a label
    JLabel title = new JLabel("Snake Game");

    //Method to set the menu using the temp gui
    public void setMenu(){
        setHeading("Main Menu");
        Gui();
        panel.setLayout(null);
        addingButtons();
        setTitle("Snake Game");
        addLabel();
    }

    //A method that will hide the previous gui
    public void hideMenu() {
        setVisible(false);
    }

    //This method adds the buttons and their action listeners
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

    public void addLabel(){
        title.setBounds(90,50,200,40);
        title.setFont(new Font("monospaced",Font.PLAIN,25));
        title.setForeground(Color.white);
        title.setVisible(true);
        panel.add(title);
    }

    //https://stackoverflow.com/questions/5936261/how-to-add-action-listener-that-listens-to-multiple-buttons
    //This method will determine what will happen when you press one of the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            JOptionPane.showMessageDialog(null,"Play");
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
