import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends MainGui implements ActionListener,SetMenu,HideMenu{
    //Declares a confirm button
    JButton confirm = new JButton("Confirm");
    //Set the dimension size of the buttons
    Dimension dim = new Dimension(200,40);
    //Declares a JComboBox
    JComboBox diff = new JComboBox();
    
    //A method to set up the menu using the temp gui
    public void setMenu(){
        setHeading("Settings");
        Gui();
        panel.setLayout(new BorderLayout());
        addButtons();
    }

    public void hideMenu(){
        setVisible(false);
    }

    public void addButtons(){
        confirm.addActionListener(this);
        confirm.setPreferredSize(dim);
        panel.add(confirm, BorderLayout.SOUTH);
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
