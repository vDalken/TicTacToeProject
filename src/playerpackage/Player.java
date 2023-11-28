package playerpackage;

public class Player {
    private String userName;
    private String gameName;
    private String password;
    private int numberOfGames=0;

    private int numberOfVictories=0;

    private int numberOfDefeats=0;

    public Player(String userName) {
        this.userName = userName;
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

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }
}
