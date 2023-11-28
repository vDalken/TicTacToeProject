package inputpackage;

import outputpackage.SystemOut;
import playerpackage.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
    public static String getString() {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        return string.trim();
    }

    public static String getNewUsername(ArrayList<Player> players) {
        String username = "";
        boolean doesUsernameExist;
        do {
            if (!doesUsernameAlreadyExist(username, players)) {
                SystemOut.printUsernameOption();
            } else {
                SystemOut.printUsernameAlreadyExists();
            }

            username = InputHandler.getString();
            doesUsernameExist = doesUsernameAlreadyExist(username, players);
        } while (doesUsernameExist);
        return username;
    }

    public static String getPlaceToPlay() {
        boolean repeat = true;
        String validPlaceToPlay = "";
        while (repeat) {
            SystemOut.printPlaceToPlay();
            String placeToPlay = getString();
            if (isPlaceToPlayValid(placeToPlay.trim())) {
                repeat = false;
                validPlaceToPlay = substituteTheLetter(placeToPlay.trim());
            }
        }
        return validPlaceToPlay;
    }

    private static String substituteTheLetter(String placeToPlay) {
        placeToPlay = placeToPlay.replace('1', '0').replace('2', '1').replace('3', '2');
        placeToPlay = placeToPlay.replace('a', '0').replace('b', '1').replace('c', '2');
        return placeToPlay;
    }

    private static boolean isPlaceToPlayValid(String placeToPlay) {
        return placeToPlay.matches("^[abcABC][123]$");
    }

    private static boolean doesUsernameAlreadyExist(String username, ArrayList<Player> players) {
        for (Player player : players) {
            if (player.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static String getGameName(ArrayList<Player> players) {
        String gameName = "";
        do {
            if (!doesGameNameAlreadyExists(gameName, players)) {
                SystemOut.printGameNameOption();
            } else {
                SystemOut.printGameNameAlreadyExists();
            }

            gameName = InputHandler.getString();
        } while (doesGameNameAlreadyExists(gameName, players));
        return gameName;
    }

    private static boolean doesGameNameAlreadyExists(String gameName, ArrayList<Player> players) {
        for (Player player : players) {
            if (player.getGameName().equals(gameName)) {
                return true;
            }
        }
        return false;
    }

    public static String getUserName(ArrayList<Player> players) {
        String username = "";
        while (!isUsernameValid(username, players)) {
            SystemOut.printUsernameOption();
            username = InputHandler.getString();
            if (!isUsernameValid(username, players)) {
                SystemOut.printUsernameNotFound();
            }
        }
        return username;
    }

    private static boolean isUsernameValid(String username, ArrayList<Player> players) {
        for (Player player : players) {
            if (player.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
