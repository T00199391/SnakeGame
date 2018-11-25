import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GameOver implements ActionListener{

    JButton close = new JButton("Close");

    JLabel gameOver = new JLabel("GAME OVER");

    JLabel nameLabel = new JLabel("Please Enter Name(4 characters)");

    MainGui gui = new MainGui();

    PlayersInfo leader;

    String fileName;

    JTextField textBox = new JTextField(4);

    public ArrayList<String> names = new ArrayList<String>();

    public ArrayList<Integer> scores = new ArrayList<Integer>();

    int count=0,curScore=PlayMenu.score,increment;


    public GameOver(){
        gui.setTitle("Game Over");
        gui.panel.setBackground(Color.black);
        gui.panel.setLayout(null);
        closeGame();
        gameOverLabel();
        nameTextLabel();
        textBox();
    }//end constructor

    public void closeGame(){
        close.setBounds(68,400,200,40);
        close.setBackground(Color.white);
        close.setForeground(Color.black);
        close.addActionListener(this);
        gui.panel.add(close);
    }//end method

    public void gameOverLabel(){
        gameOver.setBounds(30,50,300,60);
        gameOver.setFont(new Font("monospaced",Font.PLAIN,50));
        gameOver.setForeground(Color.white);
        gui.panel.add(gameOver);
    }//end method

    public void nameTextLabel(){
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

    public void textBox(){
        textBox.setBounds(90,250,150,20);
        gui.panel.add(textBox);
    }

    public void enterScore(){
        leader = new PlayersInfo(textBox.getText(),curScore);

        if(SettingsMenu.numChoice==1){
            fileName = "src/Resources/easyScore.txt";

        }
        if(SettingsMenu.numChoice==2){
            fileName = "src/Resources/normalScore.txt";
        }
        if(SettingsMenu.numChoice==3){
            fileName = "src/Resources/hardScore.txt";
        }

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
            }
            count=0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        increment=names.size();
        if(scores.size()==0){
            scores.add(curScore);
            names.add(textBox.getText());
        }
        else {
            for (int i = 0; i < names.size(); i++) {
                if (curScore >= scores.get(i)) {
                    while (increment > i) {
                        if (increment == names.size()) {
                            names.add(names.set(increment - 1, names.get(increment - 1)));
                            scores.add(scores.set(increment - 1, scores.get(increment - 1)));
                        }
                        System.out.println(increment + "\n" + i);
                        names.set(increment - 1, names.get(increment - 1));
                        scores.set(increment - 1, scores.get(increment - 1));
                        increment--;

                    }
                    scores.set(i, curScore);
                    names.set(i, textBox.getText());
                }

                if (names.size() > 5) {
                    names.remove(names.size() - 1);
                    scores.remove(scores.size() - 1);
                }
            }
        }
        //https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<names.size();i++){
                pw.println(names.get(i));
                pw.println(scores.get(i));
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}//end class
