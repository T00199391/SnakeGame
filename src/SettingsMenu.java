import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends MainGui implements ActionListener,SetMenu,HideMenu{
    //Declares a confirm button
    JButton confirm = new JButton("Confirm");
    //Set the dimension size of the buttons
    Dimension dim = new Dimension(200,40);
    //Creates an array of difficulties
    String[] difficulty = new String[]{"Easy","Normal","Hard"};
    //Declares a JComboBox
    JComboBox<String> diff = new JComboBox<String>(difficulty);
    //Variable that stores the value of the choose difficulty
    public String choice;
    //Declares a JLabel for title
    JLabel titleLabel = new JLabel("Choose Difficulty");
    //Declares a JLabel
    JLabel diffLabel = new JLabel();


    //A method to set up the menu using the temp gui
    public void setMenu(){
        setHeading("Settings");
        Gui();
        panel.setLayout(null);
        addButtons();
        addDiffComboBox();
        addTitleLabel();
        addDifficultyLabel();
    }

    public void hideMenu(){
        setVisible(false);
    }

    public void addButtons(){
        confirm.addActionListener(this);
        confirm.setBounds(68,400,200,40);
        confirm.setBackground(Color.white);
        confirm.setForeground(Color.black);
        panel.add(confirm);
    }

    public void addDiffComboBox(){
        diff.setBounds(68,100,200,40);
        diff.setFont(new Font("monospaced",Font.PLAIN,15));
        diff.addActionListener(this);
        diff.setSelectedIndex(1);
        diff.setBackground(Color.white);
        diff.setForeground(Color.black);
        panel.add(diff);
    }

    public void addTitleLabel(){
        titleLabel.setBounds(40,20,300,40);
        titleLabel.setFont(new Font("monospaced",Font.PLAIN,25));
        titleLabel.setForeground(Color.white);
        titleLabel.setVisible(true);
        panel.add(titleLabel);
    }

    public void addDifficultyLabel(){
        diffLabel.setBounds(68,160,300,70);
        diffLabel.setFont(new Font("monospaced",Font.PLAIN,15));
        diffLabel.setForeground(Color.white);
        diffLabel.setVisible(true);
        panel.add(diffLabel);
    }

    public void addInvertedColour(){
        
    }
    @Override
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
    public void difficultyChoice(){
        if(choice.equals("Easy")){
            diffLabel.setText("<html>Easy Mode<br/>Speed Of Snake: Slow<br/>Length Of Snake: Small</html>");
        }
        else if(choice.equals("Normal")){
            diffLabel.setText("<html>Normal Mode<br/>Speed Of Snake: Normal<br/>Length Of Snake: Medium</html>");
        }
        else{
            diffLabel.setText("<html>Hard Mode<br/>Speed Of Snake: Fast<br/>Length Of Snake: Large</html>");
        }
    }
}
