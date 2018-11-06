import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends MainGui implements ActionListener,SetMenu{
    //Declares a confirm button
    JButton confirm = new JButton("Confirm");

    //A method to set up the menu using the temp gui
    public void setMenu(){
        setHeading("Settings");
        Gui();
        panel.setLayout(null);
        setVisible(true);
        addButtons();
    }

    public void addButtons(){
        confirm.setBounds(68,100,200,40);
        confirm.addActionListener(this);
        panel.add(confirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainMenu menu = new MainMenu();
        menu.setMenu();
    }
}
