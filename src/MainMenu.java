import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu  extends MainGui implements ActionListener,HideMenu {

    private JButton play = new JButton("Play");

    private JButton settings = new JButton("Settings");

    private JButton leaderBoard = new JButton("LeaderBoard");

    private JButton exit = new JButton("Exit");

    private JLabel title = new JLabel("Snake Game");

    public MainMenu(){
        setTitle("Main Menu");
        panel.setLayout(null);
        addingButtons();
        addLabel();
    }//end constructor

    private void addingButtons(){
        play.setBounds(68,100,200,40);
        play.addActionListener(this);
        play.setBackground(Color.white);
        play.setForeground(Color.black);

        settings.setBounds(68,200,200,40);
        settings.addActionListener(this);
        settings.setBackground(Color.white);
        settings.setForeground(Color.black);

        leaderBoard.setBounds(68,300,200,40);
        leaderBoard.addActionListener(this);
        leaderBoard.setBackground(Color.white);
        leaderBoard.setForeground(Color.black);

        exit.setBounds(68,400,200,40);
        exit.addActionListener(this);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);

        panel.add(play);
        panel.add(settings);
        panel.add(leaderBoard);
        panel.add(exit);
    }//end method

    private void addLabel(){
        title.setBounds(90,20,200,40);
        title.setFont(new Font("monospaced",Font.PLAIN,25));
        title.setForeground(Color.white);
        title.setVisible(true);
        panel.add(title);
    }//end method

    //This method will hide the current gui when called
    public void hideMenu() {
        setVisible(false);
    }//end method


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
        else if(e.getSource() == leaderBoard){
            LeaderBoardMenu menu = new LeaderBoardMenu();
            hideMenu();
        }
        else{
            System.exit(0);
        }//end if
    }//end actionPerformed
}//end class