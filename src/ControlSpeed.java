/**
 * This class will determine the speed of the snake when the score increase
 */
public class ControlSpeed {

    /**
     * This methods determines the speed of the snake when the game is played on easy mode
     */
    public void easySpeed(){
        if(PlayMenu.score>=3 && PlayMenu.score<6)
        {
            PlayMenu.speed = 9;
        }
        if(PlayMenu.score>=6 && PlayMenu.score<9)
        {
            PlayMenu.speed=8;
        }
        if(PlayMenu.score>=9 && PlayMenu.score<12)
        {
            PlayMenu.speed=7;
        }
        if(PlayMenu.score>=12 && PlayMenu.score<15)
        {
            PlayMenu.speed=6;
        }
        if(PlayMenu.score>=15 && PlayMenu.score<18)
        {
            PlayMenu.speed=5;
        }
        if(PlayMenu.score>=18){
            PlayMenu.speed=4;
        }
    }

    /**
     * This methods determines the speed of the snake when the game is played on normal mode
     */
    public void normalSpeed(){
        if(PlayMenu.score>=5 && PlayMenu.score<10)
        {
            PlayMenu.speed=6;
        }
        if(PlayMenu.score>=10 && PlayMenu.score<15)
        {
            PlayMenu.speed=4;
        }
        if(PlayMenu.score>=15 && PlayMenu.score<20){
            PlayMenu.speed=2;
        }
    }

    /**
     * This methods determines the speed of the snake when the game is played on hard mode
     */
    public void hardSpeed(){
        if(PlayMenu.score>=3 && PlayMenu.score<6)
        {
            PlayMenu.speed=4;
        }
        if(PlayMenu.score>=6 && PlayMenu.score<9)
        {
            PlayMenu.speed=2;
        }
        if(PlayMenu.score>=9){
            PlayMenu.speed=1;
        }
    }
}
