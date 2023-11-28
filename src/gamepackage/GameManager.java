package gamepackage;

import boardpackage.GameBoard;
import inputpackage.InputHandler;
import outputpackage.SystemOut;
import playerpackage.Player;

import java.util.ArrayList;

public class GameManager {
    ArrayList<Player> players = new ArrayList<>();
    Player player1;
    Player player2;

    private int numberOfVictoriesOfPlayer1 = 0;
    private int numberOfVictoriesOfPlayer2 = 0;
    boolean isLoggedIn = false;
    boolean doesWantToPlay = true;

    public void startGame() {
        players.add(new Player("f", "f", "f"));
        showUserOptionsAndPlay("1");
        if (doesWantToPlay) {
            showUserOptionsAndPlay("2");
        }
        if (doesWantToPlay) {
            startRounds();
        }

    }

    private void showUserOptionsAndPlay(String numberOfPlayer) {
        final String GO_BACK_TO_MAIN_MENU = "0";
        final String PLAY_AS_GUEST = "1";
        final String CREATE_ACCOUNT = "2";
        final String LOG_IN = "3";
        isLoggedIn = false;
        doesWantToPlay = true;
        while (!isLoggedIn && doesWantToPlay) {
            SystemOut.printStartOfTheGameMenu(numberOfPlayer);
            String selectedOption = InputHandler.getString();
            switch (selectedOption) {
                case GO_BACK_TO_MAIN_MENU:
                    SystemOut.printGoBackToMainMenuOption();
                    doesWantToPlay = false;
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
        String username = InputHandler.getNewUsername(players);
        String gameName = InputHandler.getGameName(players);

        SystemOut.printPasswordOption();
        String password = InputHandler.getString();

        Player newPlayer = new Player(username.trim(), gameName.trim(), password.trim());
        players.add(newPlayer);

        if (numberOfPlayer.equals("1")) {
            player1 = newPlayer;
        } else {
            player2 = newPlayer;
        }
        isLoggedIn = true;
    }

    private void logIn(String numberOfPlayer) {
        String username;
        String password;
        boolean isAccountValid;
        boolean isTheSameReference = false;

        do {
            username = InputHandler.getUserName(players);
            SystemOut.printPasswordOption();
            password = InputHandler.getString();
            isAccountValid = isAccountValid(username, password);
            if (!isAccountValid) {
                SystemOut.printWrongPassword();
            }
        } while (!isAccountValid);

        Player loggedInPlayer = findPlayer(username);
        isTheSameReference = player1 == loggedInPlayer;

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


    private void startRounds() {
        do {
            GameBoard gameBoard = new GameBoard();
            gameBoard.fillBoard();
            rounds(gameBoard);
        } while (numberOfVictoriesOfPlayer1 + numberOfVictoriesOfPlayer2 != 3 && numberOfVictoriesOfPlayer1 != 2 && numberOfVictoriesOfPlayer2 != 2);
        if (numberOfVictoriesOfPlayer1 > numberOfVictoriesOfPlayer2) {
            SystemOut.printPlayerWinningGameAnnouncement(player1);
            player1.addVictory();
        } else {
            SystemOut.printPlayerWinningGameAnnouncement(player2);
            player2.addVictory();
        }
        numberOfVictoriesOfPlayer1 = 0;
        numberOfVictoriesOfPlayer2 = 0;
    }

    private void rounds(GameBoard gameBoard) {
        int round = 1;
        boolean isRoundOverBecauseEveryPlaceGotFilled = false;
        do {
            round(gameBoard, "X", "1");
            if (gameBoard.isRoundOverBecauseSomeoneWon()) {
                gameBoard.showBoard();
                numberOfVictoriesOfPlayer1++;
                if (numberOfVictoriesOfPlayer1 != 2) {
                    SystemOut.printPlayerWinningRoundAnnouncement(player1, round);
                }
                round++;
                break;
            }
            round(gameBoard, "O", "2");
            if (gameBoard.isRoundOverBecauseSomeoneWon()) {
                gameBoard.showBoard();
                numberOfVictoriesOfPlayer2++;
                if (numberOfVictoriesOfPlayer2 != 2) {
                    SystemOut.printPlayerWinningRoundAnnouncement(player2, round);
                }
                round++;
                break;
            }
            isRoundOverBecauseEveryPlaceGotFilled = gameBoard.isRoundOverBecauseEveryPlaceGotFilled();
        } while (!gameBoard.isRoundOverBecauseSomeoneWon() || !isRoundOverBecauseEveryPlaceGotFilled);
        if (isRoundOverBecauseEveryPlaceGotFilled) {
            SystemOut.printTieAnnouncement();
        }
    }

    private void round(GameBoard gameBoard, String letter, String numberOfPlayer) {
        boolean needsToRepeat = false;
        int row;
        int column;
        do {
            if (!needsToRepeat) {
                SystemOut.printPlayerTurn(numberOfPlayer, letter);
                gameBoard.showBoard();
            }
            String placeToPlay = InputHandler.getPlaceToPlay();
            String[] placeToPlaySplit = placeToPlay.split("");
            row = Integer.parseInt(placeToPlaySplit[0]);
            column = Integer.parseInt(placeToPlaySplit[1]);
            if (gameBoard.isPlaceToPlayValid(row, column)) {
                gameBoard.fillBoardWithLetter(row, column, letter);
                needsToRepeat = false;
            } else {
                SystemOut.printPlaceError();
                needsToRepeat = true;
            }
        } while (needsToRepeat);

    }

    private Player findPlayer(String username) {
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
}
