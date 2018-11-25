import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends MainGui implements ActionListener,HideMenu {

    private JButton confirm = new JButton("Confirm");

    private String[] difficulty = new String[]{"Easy","Normal","Hard"};

    private JComboBox<String> diff = new JComboBox<String>(difficulty);

    private String choice;

    private JLabel titleLabel = new JLabel("Choose Difficulty");

    private JLabel diffLabel = new JLabel();

    public static int numChoice = 2;

    public SettingsMenu(){
        setTitle("Settings");
        panel.setLayout(null);
        addButtons();
        addDiffComboBox();
        addTitleLabel();
        addDifficultyLabel();
    }//end constructor

    private void addButtons(){
        confirm.addActionListener(this);
        confirm.setBounds(68,400,200,40);
        confirm.setBackground(Color.white);
        confirm.setForeground(Color.black);
        panel.add(confirm);
    }//end method

    private void addDiffComboBox(){
        diff.setBounds(68,100,200,40);
        diff.setFont(new Font("monospaced",Font.PLAIN,15));
        diff.addActionListener(this);
        diff.setSelectedIndex(1);
        diff.setBackground(Color.white);
        diff.setForeground(Color.black);
        panel.add(diff);
    }//end method

    private void addTitleLabel(){
        titleLabel.setBounds(40,20,300,40);
        titleLabel.setFont(new Font("monospaced",Font.PLAIN,25));
        titleLabel.setForeground(Color.white);
        titleLabel.setVisible(true);
        panel.add(titleLabel);
    }//end method

    private void addDifficultyLabel(){
        diffLabel.setBounds(60,200,300,130);
        diffLabel.setFont(new Font("monospaced",Font.PLAIN,15));
        diffLabel.setForeground(Color.white);
        diffLabel.setVisible(true);
        panel.add(diffLabel);
    }//end method

    public void hideMenu(){
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirm){
            MainMenu menu = new MainMenu();
            hideMenu();
        }
        else{
            //https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html#listeners
            JComboBox cb = (JComboBox)e.getSource();
            choice = (String)cb.getSelectedItem();
            difficultyChoice();
        }//end if
    }//end actionPerformed

    //https://stackoverflow.com/questions/1090098/newline-in-jlabel
    private void difficultyChoice(){

        if(choice.equals("Easy")){
            diffLabel.setText("<html>Easy Mode<br/>Start speed Of Snake: Slow<br/>Length Of Snake: Small<br><br>This mode is when you just<br> want a chill game of snake</html>");
            PlayMenu.speed = 10;
            PlayMenu.tail = 3;
            diff.setSelectedIndex(0);
            numChoice =1;

        }
        else if(choice.equals("Normal")){
            diffLabel.setText("<html>Normal Mode<br/>Start speed Of Snake: Normal<br/>Length Of Snake: Medium<br><br>This mode is for everyone</html>");
            PlayMenu.speed = 8;
            PlayMenu.tail = 5;
            diff.setSelectedIndex(1);
            numChoice =2;
        }
        else{
            diffLabel.setText("<html>Hard Mode<br/>Start speed Of Snake: Fast<br/>Length Of Snake: Large<br><br>This mode will be for people<br>who want a challenge</html>");
            PlayMenu.speed = 6;
            PlayMenu.tail = 7;
            diff.setSelectedIndex(2);
            numChoice =3;
        }//end if
    }//end method
}//end class
