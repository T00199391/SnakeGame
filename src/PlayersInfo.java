public class PlayersInfo {
    public String userName;
    public int userScore;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public PlayersInfo(String userName, int userScore){
        setUserName(userName);
        setUserScore(userScore);
    }

    public String toString(){
        return getUserName() + "\n" + getUserScore();
    }
}
