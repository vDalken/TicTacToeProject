package playerpackage;

public class Player {
    private String userName;
    private String gameName;
    private String password;
    private int numberOfGames=0;

    private int numberOfVictories=0;

    private int numberOfRoundVictories=0;

    public Player(String gameName) {
        this.gameName=gameName;
    }

    public Player(String userName, String gameName, String password) {
        this.userName = userName;
        this.gameName = gameName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void addVictory(){
        this.numberOfVictories++;
    }

    public void setNumberOfRoundVictories(int numberOfRoundVictories) {
        this.numberOfRoundVictories = numberOfRoundVictories;
    }

    public void addRoundVictory(){
        this.numberOfRoundVictories++;
    }

    public int getNumberOfRoundVictories() {
        return numberOfRoundVictories;
    }
}
