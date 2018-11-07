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
    //Declares a JLabel
    JLabel titleLabel = new JLabel("Choose Difficulty");


    //A method to set up the menu using the temp gui
    public void setMenu(){
        setHeading("Settings");
        Gui();
        panel.setLayout(null);
        addButtons();
        addComboBox();
        addTitleLabel();
    }

    public void hideMenu(){
        setVisible(false);
    }

    public void addButtons(){
        confirm.addActionListener(this);
        confirm.setBounds(68,400,200,40);
        panel.add(confirm);
    }

    public void addComboBox(){
        diff.setBounds(100,100,100,100);
        diff.addActionListener(this);
        diff.setSelectedIndex(1);
        panel.add(diff);
    }

    public void addTitleLabel(){
        titleLabel.setBounds(40,20,300,40);
        titleLabel.setFont(new Font("monospaced",Font.PLAIN,25));
        titleLabel.setForeground(Color.white);
        titleLabel.setVisible(true);
        panel.add(titleLabel);
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

    public void difficultyChoice(){
        if(choice.equals("Easy")){
            System.out.print("Easy Mode");
        }
        else if(choice.equals("Normal")){
            System.out.print("Normal Mode");
        }
        else{
            System.out.print("Hard Mode");
        }
    }
}
