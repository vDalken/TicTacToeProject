import gamepackage.GameManager;
import inputpackage.InputHandler;
import outputpackage.SystemOut;

public class Main {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        GameManager game = new GameManager();
        final String EXIT_GAME = "0";
        final String PLAYER_VERSUS_PLAYER = "1";
        final String LEADERBOARD = "2";
        final String HANDBOOK = "3";
        String userInput;
        SystemOut.printGameName();
        do {
            SystemOut.printMainMenu();
            userInput = InputHandler.getString();
            switch (userInput) {
                case EXIT_GAME:
                    SystemOut.printExitOfTheGame();
                    break;
                case PLAYER_VERSUS_PLAYER:
                    game.startGame();
                    break;
                case LEADERBOARD:
                    if(!GameManager.players.isEmpty()){
                        SystemOut.printLeaderboardNames();
                        showLeaderboardNames();
                    }else{
                        System.out.println(ANSI_RED+"\nNo accounts found\n"+ANSI_RESET);
                    }
                    break;
                case HANDBOOK:
                    SystemOut.printHandbook();
                    break;
                default:
                    SystemOut.printSelectedOptionError();
                    break;
            }
        } while (!userInput.equals("0"));
    }

    private static void showLeaderboardNames(){
        for(int i=0; i<GameManager.players.size();i++){
            System.out.println(GameManager.players.get(i).toString());
        }
    }

}