package playerpackage;

public class Player {
    private String userName;
    private String gameName;
    private String password;
    private int numberOfGames;

    private int numberOfVictories;

    private int numberOfDefeats;

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

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public String getGameName() {
        return gameName;
    }

    public String getPassword() {
        return password;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }
}
