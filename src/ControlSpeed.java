public class ControlSpeed {

    public void easySpeed(){
        if(PlayMenu.score>=3 && PlayMenu.score<6)
        {
                PlayMenu.speed-=1;
        }
        else if(PlayMenu.score>=6 && PlayMenu.score<9)
        {
            PlayMenu.speed-=1;
        }
        else if(PlayMenu.score>=9 && PlayMenu.score<12)
        {
            PlayMenu.speed-=1;
        }
        else if(PlayMenu.score>=12 && PlayMenu.score<15)
        {
            PlayMenu.speed-=1;
        }
        else if(PlayMenu.score>=15 && PlayMenu.score<18)
        {
            PlayMenu.speed-=1;
        }
        else{
            PlayMenu.speed-=1;
        }
    }

    public void NormalSpeed(){
        if(PlayMenu.score>=3 && PlayMenu.score<6)
        {
            PlayMenu.speed-=2;
        }
        else if(PlayMenu.score>=6 && PlayMenu.score<9)
        {
            PlayMenu.speed-=2;
        }
        else if(PlayMenu.score>=9 && PlayMenu.score<12)
        {
            PlayMenu.speed-=2;
        }
        else if(PlayMenu.score>=12 && PlayMenu.score<15)
        {
            PlayMenu.speed-=2;
        }
        else if(PlayMenu.score>=15 && PlayMenu.score<18)
        {
            PlayMenu.speed-=2;
        }
        else{
            PlayMenu.speed-=2;
        }
    }
}
