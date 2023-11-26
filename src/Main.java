import inputpackage.InputHandler;
import outputpackage.SystemOut;

public class Main {
    public static void main(String[] args) {
        final String EXIT_GAME = "0";
        final String PLAYER_VERSUS_PLAYER = "1";
        final String LEADERBOARD = "2";
        String userInput;
        do {
            SystemOut.printMainMenu();
            userInput = InputHandler.getString();
            switch (userInput) {
                case EXIT_GAME:
                    SystemOut.printExitOfTheGame();
                    break;
                case PLAYER_VERSUS_PLAYER:

                    break;
                case LEADERBOARD:
                    break;
                default:
                    SystemOut.printSelectedOptionError();
                    break;
            }
        } while (!userInput.equals("0"));
    }
}