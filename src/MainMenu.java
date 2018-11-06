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
    //Declares the dimensions of the buttons
    Dimension dim = new Dimension(200,40);

    //Method to set the menu using the temp gui
    public void setMenu(){
        setHeading("Main Menu");
        Gui();
        addingButtons();
        addTitle();
    }

    public void hideMenu() {
        setVisible(false);
    }

    //This method will add the title label
    public void addTitle(){
        title.setLocation(93,50);
        title.setSize(200,40);
        title.setFont(new Font("monospaced",Font.PLAIN,25));
        title.setForeground(Color.white);
        title.setVisible(true);
        panel.add(title);
    }

    //This method adds the buttons and their action listeners
    public void addingButtons(){
        play.setPreferredSize(dim);
        play.addActionListener(this);

        settings.setPreferredSize(dim);
        settings.addActionListener(this);

        exit.setPreferredSize(dim);
        exit.addActionListener(this);

        panel.add(play);
        panel.add(settings);
        panel.add(exit);
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
