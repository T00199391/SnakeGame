import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends MainGui implements ActionListener,SetMenu,HideMenu{
    //Declares a JButton that when clicked will confirm the settings the user choose and take you back to the main menu
    private JButton confirm = new JButton("Confirm");
    //Creates an array of difficulties for the game
    private String[] difficulty = new String[]{"Easy","Normal","Hard"};
    //Declares a JComboBox that will let the user choose the difficulty they want to play the game
    private JComboBox<String> diff = new JComboBox<String>(difficulty);
    //Variable that stores the value of the choose difficulty
    private String choice;
    //Declares a JLabel that displays what to do in th settings
    private JLabel titleLabel = new JLabel("Choose Difficulty");
    //Declares a JLabel that will display what each difficulty will do
    private JLabel diffLabel = new JLabel();


    //A method to sets the menu
    public void setMenu(){
        setHeading("Settings");
        JFameGui();
        JPanelGui();
        panel.setLayout(null);
        addButtons();
        addDiffComboBox();
        addTitleLabel();
        addDifficultyLabel();
    }

    //Method that will hide the previous gui
    public void hideMenu(){
        setVisible(false);
    }

    //Method that will alter the confirm button and add it to the panel
    private void addButtons(){
        confirm.addActionListener(this);
        confirm.setBounds(68,400,200,40);
        confirm.setBackground(Color.white);
        confirm.setForeground(Color.black);
        panel.add(confirm);
    }

    //Method that will alter the combo box and will add it to the panel
    private void addDiffComboBox(){
        diff.setBounds(68,100,200,40);
        diff.setFont(new Font("monospaced",Font.PLAIN,15));
        diff.addActionListener(this);
        diff.setSelectedIndex(1);
        diff.setBackground(Color.white);
        diff.setForeground(Color.black);
        panel.add(diff);
    }

    //Method that will alter the title label and add it to the panel
    private void addTitleLabel(){
        titleLabel.setBounds(40,20,300,40);
        titleLabel.setFont(new Font("monospaced",Font.PLAIN,25));
        titleLabel.setForeground(Color.white);
        titleLabel.setVisible(true);
        panel.add(titleLabel);
    }

    //Method that will alter the difficulty description and add it to the panel
    private void addDifficultyLabel(){
        diffLabel.setBounds(68,160,300,70);
        diffLabel.setFont(new Font("monospaced",Font.PLAIN,15));
        diffLabel.setForeground(Color.white);
        diffLabel.setVisible(true);
        panel.add(diffLabel);
    }

    //Method will determine what will happen when you press the confirm button and when you choose one of the difficulties in the combo box
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirm){
            MainMenu menu = new MainMenu();
            menu.setMenu();
            hideMenu();
        }
        else{
            //https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html#listeners
            JComboBox cb = (JComboBox)e.getSource();
            choice = (String)cb.getSelectedItem();
            difficultyChoice();
        }
    }

    //https://stackoverflow.com/questions/1090098/newline-in-jlabel
    //Method that will display what each difficulty will do
    private void difficultyChoice(){
        if(choice.equals("Easy")){
            diffLabel.setText("<html>Easy Mode<br/>Start speed Of Snake: Slow<br/>Length Of Snake: Small</html>");
        }
        else if(choice.equals("Normal")){
            diffLabel.setText("<html>Normal Mode<br/>Start speed Of Snake: Normal<br/>Length Of Snake: Medium</html>");
        }
        else{
            diffLabel.setText("<html>Hard Mode<br/>Start speed Of Snake: Fast<br/>Length Of Snake: Large</html>");
        }
    }

    /*private void difficultyChoice(){
        char ch = choice.charAt(0);
        switch(ch){
            case 'E':
                diffLabel.setText("<html>Easy Mode<br/>Start speed Of Snake: Slow<br/>Length Of Snake: Small</html>");
            case 'N':
                diffLabel.setText("<html>Normal Mode<br/>Start speed Of Snake: Normal<br/>Length Of Snake: Medium</html>");
            case 'H':
                diffLabel.setText("<html>Hard Mode<br/>Start speed Of Snake: Fast<br/>Length Of Snake: Large</html>");
        }
    }*/
}
