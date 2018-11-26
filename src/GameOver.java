import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GameOver implements ActionListener{

    private JButton close = new JButton("Close");

    private JLabel gameOver = new JLabel("GAME OVER");

    private JLabel nameLabel = new JLabel("Please Enter Name(4 characters)");

    private MainGui gui = new MainGui();

    private PlayersInfo leader;

    private String fileName;

    private JTextField textBox = new JTextField(4);

    private ArrayList<String> names = new ArrayList<String>();

    private ArrayList<Integer> scores = new ArrayList<Integer>();

    private int count=0,curScore=PlayMenu.score,increment,updateCount=0;


    public GameOver(){
        gui.setTitle("Game Over");
        gui.panel.setBackground(Color.black);
        gui.panel.setLayout(null);
        closeGame();
        gameOverLabel();
        nameTextLabel();
        textBox();
    }//end constructor

    private void closeGame(){
        close.setBounds(68,400,200,40);
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        close.addActionListener(this);
        gui.panel.add(close);
    }//end method

    private void gameOverLabel(){
        gameOver.setBounds(30,50,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        gui.panel.add(gameOver);
    }//end method

    private void nameTextLabel(){
        nameLabel.setBounds(30,200,300,60);
        nameLabel.setFont(new Font("monospaced",Font.PLAIN,15));
        nameLabel.setForeground(Color.white);
        gui.panel.add(nameLabel);
    }//end method

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close) {
            if (textBox.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
                return;
            }
            else if(textBox.getText().length()>4){
                JOptionPane.showMessageDialog(null, "Name must be 4 characters or less");
                return;
            }
            else{
                enterScore();
                System.exit(0);
            }//end if
        }//end if
    }//end method

    private void textBox(){
        textBox.setBounds(90,250,150,20);
        gui.panel.add(textBox);
    }//end method

    private void enterScore(){
        leader = new PlayersInfo(textBox.getText(),curScore);

        if(SettingsMenu.numChoice==1){
            fileName = "src/Resources/easyScore.txt";
        }//end if
        if(SettingsMenu.numChoice==2){
            fileName = "src/Resources/normalScore.txt";
        }//end if
        if(SettingsMenu.numChoice==3){
            fileName = "src/Resources/hardScore.txt";
        }//end if

        names.clear();
        scores.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;

            while ((line = br.readLine()) != null){
                count++;
                if(count%2==0)
                    scores.add(Integer.parseInt(line));
                else
                    names.add(line);
            }//end while loop
            count=0;
        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }//end catch
        catch (IOException e) {
            e.printStackTrace();
        }//end catch

        increment=names.size();
        if(scores.size()==0){
            scores.add(curScore);
            names.add(textBox.getText());
        }
        else {
            for (int i = 0; i < names.size(); i++) {
                if (curScore >= scores.get(i) && updateCount==0) {
                    while (increment-1 >= i) {
                        names.add(names.set(increment - 1, names.get(increment - 1)));
                        scores.add(scores.set(increment - 1, scores.get(increment - 1)));
                        names.set(increment, names.get(increment - 1));
                        scores.set(increment, scores.get(increment - 1));
                        increment--;

                    }//end while loop
                    scores.set(i, curScore);
                    names.set(i, textBox.getText());
                    updateCount++;
                }//end if

                if (names.size() > 5) {
                    names.remove(names.size() - 1);
                    scores.remove(scores.size() - 1);
                }//end if
            }//end for loop
        }
        //https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<names.size();i++){
                pw.println(names.get(i));
                pw.println(scores.get(i));
            }//end for loop
            pw.close();
        } //end try
        catch (IOException e) {
            e.printStackTrace();
        }//end catch
    }//end method
}//end class
