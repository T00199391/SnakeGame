import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeaderBoardMenu extends MainGui implements ActionListener,HideMenu{

    private JButton ok = new JButton("OK");

    private String[] difficulty = new String[]{"Easy","Normal","Hard"};

    private JComboBox<String> diff = new JComboBox<String>(difficulty);

    private String choice,labelName,labelScore,labelString,fileName;

    private JLabel scoreLabel = new JLabel();

    private JLabel textLabel = new JLabel("Leader Board");

    int count = 0;

    public LeaderBoardMenu(){
        setTitle("LeaderBoardMenu");
        panel.setLayout(null);
        addOkButton();
        addDiffComboBox();
        addScoreLabel();
        addTextLabel();
    }//end constructor

    private void addOkButton(){
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
    }//end method

    private void addScoreLabel(){
        scoreLabel.setBounds(80,200,300,200);
        scoreLabel.setFont(new Font("monospaced",Font.PLAIN,15));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setVisible(true);
        panel.add(scoreLabel);
    }//end method

    private void addTextLabel(){
        textLabel.setBounds(75,100,300,200);
        textLabel.setFont(new Font("monospaced",Font.PLAIN,25));
        textLabel.setForeground(Color.white);
        textLabel.setVisible(true);
        panel.add(textLabel);
    }//end method

    private void leaderDifficulty(){

        if(choice.equals("Easy")){
            labelString="";
            labelName="";
            labelScore="";
            fileName = "src/Resources/easyScore.txt";
        }
        else if(choice.equals("Normal")){
            labelString="";
            labelName="";
            labelScore="";
            fileName = "src/Resources/normalScore.txt";
        }
        else{
            labelString="";
            labelName="";
            labelScore="";
            fileName = "src/Resources/hardScore.txt";
        }//end if

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;

            while ((line = br.readLine()) != null && count!=10){
                count++;
                if(count%2==0)
                    labelScore += "Score: " + line + "<br>";
                else
                    labelName += "Name: " + line;

                labelString += String.format("%-15s%-15s",labelName,labelScore);

                labelScore="";
                labelName="";
            }//end while
            count=0;

        } //end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }//end catch
        catch (IOException e) {
            e.printStackTrace();
        }//end catch
        scoreLabel.setText("<html>" + labelString + "</html>");
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
}//end class
