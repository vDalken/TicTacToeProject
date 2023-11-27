package gamepackage;

import inputpackage.InputHandler;
import outputpackage.SystemOut;
import playerpackage.Player;

import java.util.ArrayList;

public class GameManager {
    ArrayList<Player> players = new ArrayList<>();
    Player player1;
    Player player2;

    boolean isLoggedIn = false;

    public void startGame() {
        players.add(new Player("f", "f", "f"));
        showUserOptionsAndPlay("1");
        showUserOptionsAndPlay("2");
    }

    private void showUserOptionsAndPlay(String numberOfPlayer) {
        final String GO_BACK_TO_MAIN_MENU = "0";
        final String PLAY_AS_GUEST = "1";
        final String CREATE_ACCOUNT = "2";
        final String LOG_IN = "3";
        isLoggedIn = false;

        while (!isLoggedIn) {
            SystemOut.printStartOfTheGameMenu(numberOfPlayer);
            String selectedOption = InputHandler.getString();
            switch (selectedOption) {
                case GO_BACK_TO_MAIN_MENU:
                    SystemOut.printGoBackToMainMenuOption();
                    break;
                case PLAY_AS_GUEST:
                    playAsGuest();
                    break;
                case CREATE_ACCOUNT:
                    createAccount(numberOfPlayer);
                    break;
                case LOG_IN:
                    logIn(numberOfPlayer);
                    break;
                default:
                    SystemOut.printSelectedOptionError();
                    break;
            }
        }
    }

    private void playAsGuest() {
        Player guest = new Player("guest");
    }

    private void createAccount(String numberOfPlayer) {
        String username = "";
        String gameName = "";
        boolean doesUsernameExist;

        do {
            if (!doesUsernameAlreadyExist(username)) {
                SystemOut.printUsernameOption();
            } else {
                SystemOut.printUsernameAlreadyExists();
            }

            username = InputHandler.getString();
            doesUsernameExist = doesUsernameAlreadyExist(username);
        } while (doesUsernameExist);

        do {
            if (!doesGameNameAlreadyExists(gameName)) {
                SystemOut.printGameNameOption();
            } else {
                SystemOut.printGameNameAlreadyExists();
            }

            gameName = InputHandler.getString();
        } while (doesGameNameAlreadyExists(gameName));

        SystemOut.printPasswordOption();
        String password = InputHandler.getString();

        Player newPlayer = new Player(username.trim(), gameName.trim(), password.trim());
        players.add(newPlayer);

        if (numberOfPlayer.equals("1")) {
            player1 = newPlayer;
        } else {
            player2 = newPlayer;
        }
    }

    private boolean doesUsernameAlreadyExist(String username) {
        for (Player player : players) {
            if (player.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesGameNameAlreadyExists(String gameName) {
        for (Player player : players) {
            if (player.getGameName().equals(gameName)) {
                return true;
            }
        }
        return false;
    }

    private void logIn(String numberOfPlayer) {
        String username;
        String password;
        boolean isAccountValid;
        boolean isTheSameReference = false;

        do {
            username = "";
            while (!isUsernameValid(username)) {
                SystemOut.printUsernameOption();
                username = InputHandler.getString();
                if (!isUsernameValid(username)) {
                    SystemOut.printUsernameNotFound();
                }
            }
            SystemOut.printPasswordOption();
            password = InputHandler.getString();
            isAccountValid = isAccountValid(username, password);
            if (!isAccountValid) {
                SystemOut.printWrongPassword();
            }
        } while (!isAccountValid);

        Player loggedInPlayer = findPlayer(username, password);
        isTheSameReference = player1 == loggedInPlayer || player2 == loggedInPlayer;

        if (isTheSameReference) {
            SystemOut.printUnsuccessfulLogIn();
            isLoggedIn = false;
        } else {
            SystemOut.printSuccessfulLogIn();
            isLoggedIn = true;
        }

        if (numberOfPlayer.equals("1") && !isTheSameReference) {
            player1 = loggedInPlayer;
        }
        if (numberOfPlayer.equals("2") && !isTheSameReference) {
            player2 = loggedInPlayer;
        }

    }

    private Player findPlayer(String username, String password) {
        for (Player player : players) {
            if (player.getUserName().equals(username)) {
                return player;
            }
        }
        return null;
    }

    private boolean isAccountValid(String username, String password) {
        for (Player player : players) {
            if (player.getUserName().equals(username) && player.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameValid(String username) {
        for (Player player : players) {
            if (player.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
