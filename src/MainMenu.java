import javax.swing.*;

//Class that makes the main menu
public class MainMenu extends MainGui{

    //Declares the play button
    JButton play = new JButton("Play");

    //Method to set the menu using the temp gui
    public void setMenu(){
        setHeading("Main Menu");
        setVisible(true);
        Gui();
        playButton();
    }

    //Method to make the play button
    public void playButton(){
        panel.add(play);
    }
}
