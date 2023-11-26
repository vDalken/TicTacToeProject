package gamepackage;

import inputpackage.InputHandler;
import outputpackage.SystemOut;
import playerpackage.Player;

import java.util.ArrayList;

public class GameManager {
    ArrayList<Player> players = new ArrayList<>();

    public void startGame() {


    }

    private void showUserOptionsAndPlay() {
        final String GO_BACK_TO_MAIN_MENU = "0";
        final String PLAY_AS_GUEST = "1";
        final String CREATE_ACCOUNT = "2";
        final String LOG_IN = "3";
        SystemOut.printStartOfTheGameMenu();
        String selectedOption = InputHandler.getString();
        switch (selectedOption) {
            case GO_BACK_TO_MAIN_MENU:
                SystemOut.printGoBackToMainMenuOption();
                break;
            case PLAY_AS_GUEST:
                playAsGuest();
                break;
            case CREATE_ACCOUNT:
                createAccount();
                break;
            case LOG_IN:
                logIn();
                break;
            default:
                SystemOut.printSelectedOptionError();
                break;
        }
    }

    private void playAsGuest() {
        Player guest = new Player("guest");
    }

    private void createAccount() {
        SystemOut.printUsernameOption();
        String username = InputHandler.getString();
        SystemOut.printGameNameOption();
        String gameName = InputHandler.getString();
        SystemOut.printPasswordOption();
        String password = InputHandler.getString();
        players.add(new Player(username, gameName, password));
    }

    private void logIn() {
        SystemOut.printUsernameOption();
        String username = InputHandler.getString();
        SystemOut.printPasswordOption();
        String password = InputHandler.getString();
        if (isAccountValid(username, password)) {
            
        }
    }

    private boolean isAccountValid(String username, String password) {
        for (Player player : players) {
            if (player.getUserName().equals(username) && player.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
