/**
 * This class will determine the speed of the snake when the score increase depending on the difficulty settings
 * @author Emma Fitzgerald T00199391
 */
public class ControlSpeed {

    /**
     * This methods determines the speed of the snake when the score increases on easy difficulty
     */
    public void easySpeed(){
        if(PlayMenu.score>=3 && PlayMenu.score<6)
            PlayMenu.speed = 9;

        if(PlayMenu.score>=6 && PlayMenu.score<9)
            PlayMenu.speed=8;

        if(PlayMenu.score>=9 && PlayMenu.score<12)
            PlayMenu.speed=7;

        if(PlayMenu.score>=12 && PlayMenu.score<15)
            PlayMenu.speed=6;

        if(PlayMenu.score>=15 && PlayMenu.score<18)
            PlayMenu.speed=5;

        if(PlayMenu.score>=18)
            PlayMenu.speed=4;

    }//end method

    /**
     * This methods determines the speed of the snake when the score increases on normal difficulty
     */
    public void normalSpeed(){
        if(PlayMenu.score>=5 && PlayMenu.score<10)
            PlayMenu.speed=6;

        if(PlayMenu.score>=10 && PlayMenu.score<15)
            PlayMenu.speed=4;

        if(PlayMenu.score>=15 && PlayMenu.score<20)
            PlayMenu.speed=2;

    }//end method

    /**
     * This methods determines the speed of the snake when the score increases on hard difficulty
     */
    public void hardSpeed(){
        if(PlayMenu.score>=3 && PlayMenu.score<6)
            PlayMenu.speed=4;

        if(PlayMenu.score>=6 && PlayMenu.score<9)
            PlayMenu.speed=2;

        if(PlayMenu.score>=9)
            PlayMenu.speed=1;

    }//end method
}//end class
