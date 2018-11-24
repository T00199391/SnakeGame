import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderBoardMenu extends MainGui implements ActionListener,HideMenu{

    private JButton ok = new JButton("OK");

    private String[] difficulty = new String[]{"Easy","Normal","Hard"};

    private JComboBox<String> diff = new JComboBox<String>(difficulty);

    private String choice;

    public LeaderBoardMenu(){
        setTitle("LeaderBoardMenu");
        panel.setLayout(null);
        addButtons();
        addDiffComboBox();
    }//end constructor

    private void addButtons(){
        ok.addActionListener(this);
        ok.setBounds(68,400,200,40);
        ok.setBackground(Color.white);
        ok.setForeground(Color.black);
        panel.add(ok);
    }//end method

    private void addDiffComboBox(){
        diff.setBounds(68,50,200,40);
        diff.setFont(new Font("monospaced",Font.PLAIN,15));
        diff.addActionListener(this);
        diff.setSelectedIndex(1);
        diff.setBackground(Color.white);
        diff.setForeground(Color.black);
        panel.add(diff);
    }//end method

    public void hideMenu(){
        setVisible(false);
    }

    private void leaderDifficulty(){

        if(choice.equals("Easy")){
            System.out.println("hi e");
        }
        else if(choice.equals("Normal")){
            System.out.println("hi n");
        }
        else{
            System.out.println("hi h");
        }//end if
    }//end method

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            MainMenu menu = new MainMenu();
            hideMenu();
        }
        else{
            JComboBox cb = (JComboBox)e.getSource();
            choice = (String)cb.getSelectedItem();
            leaderDifficulty();
        }//end if
    }//end actionPerformed
}
