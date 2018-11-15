import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu  extends MainGui implements ActionListener,HideMenu {
    private JButton play = new JButton("Play");

    private JButton settings = new JButton("Settings");

    private JButton exit = new JButton("Exit");

    private JLabel title = new JLabel("Snake Game");

    public MainMenu(){
        setTitle("Main Menu");
        panel.setLayout(null);
        addingButtons();
        addLabel();
    }

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

    public void hideMenu() {
        setVisible(false);
    }


    //https://stackoverflow.com/questions/5936261/how-to-add-action-listener-that-listens-to-multiple-buttons
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            PlayMenu menu = new PlayMenu();
            hideMenu();
        }
        else if(e.getSource() == settings){
            SettingsMenu menu = new SettingsMenu();
            hideMenu();
        }
        else{
            System.exit(0);
        }
    }
}