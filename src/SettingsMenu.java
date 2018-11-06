import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends MainGui implements ActionListener,SetMenu,HideMenu{
    //Declares a confirm button
    JButton confirm = new JButton("Confirm");
    //Declares an array of difficulties
    String[] difficulty = {"easy","Normal","Hard"};
    //Declares a combobox
    JComboBox<String> diff = new JComboBox<String>(difficulty);
    //A variable that stores the choice from the comboBox
    String choice;

    //A method to set up the menu using the temp gui
    public void setMenu(){
        setHeading("Settings");
        Gui();
        panel.setLayout(null);
        addButtons();
    }

    public void hideMenu(){
        setVisible(false);
    }

    public void addButtons(){
        confirm.setBounds(68,100,200,40);
        confirm.addActionListener(this);
        panel.add(confirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirm){
            MainMenu menu = new MainMenu();
            menu.setMenu();
            hideMenu();
        }
    }


}
