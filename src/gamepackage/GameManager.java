package gamepackage;

import boardpackage.GameBoard;
import inputpackage.InputHandler;
import outputpackage.SystemOut;
import playerpackage.Player;
import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList;

public class GameManager {
    private static final String ANSI_RESET = "\u001B[0m";
    ArrayList<Player> players = new ArrayList<>();
    Player player1;
    Player player2;

    private int numberOfVictoriesOfPlayer1 = 0;
    private int numberOfVictoriesOfPlayer2 = 0;
    boolean isLoggedIn = false;
    boolean doesWantToPlay = true;

    public void startGame() {
        players.add(new Player("f", "f", "f"));
        boolean areTheSamePlayers = false;
        if (player1 != null && player2 != null) {
            SystemOut.printQuestionAboutPlayers();
            areTheSamePlayers = InputHandler.getAnswer();
        }

        if (!areTheSamePlayers) {
            player1 = null;
            player2 = null;
            showUserOptionsAndPlay("1");
            if (doesWantToPlay) {
                showUserOptionsAndPlay("2");
            }
            if (doesWantToPlay) {
                startRounds();
            }
        } else {
            if (doesWantToPlay) {
                startRounds();
            }
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
                    playAsGuest(numberOfPlayer);
                    isLoggedIn = true;
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

    private void playAsGuest(String numberOfPlayer) {
        if (numberOfPlayer.equals("1")) {
            player1 = new Player("guest 1");
        } else {
            player2 = new Player("guest 2");
        }
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
        int round = 1;
        do {
            GameBoard gameBoard = new GameBoard();
            gameBoard.fillBoard();
            rounds(gameBoard, round);
            round++;
        } while (player1.getNumberOfRoundVictories() +player2.getNumberOfRoundVictories() != 3 && player1.getNumberOfRoundVictories() != 2 && player2.getNumberOfRoundVictories() != 2);
        player1.setNumberOfRoundVictories(0);
        player2.setNumberOfRoundVictories(0);
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

    private void rounds(GameBoard gameBoard, int round) {
        boolean isRoundOverBecauseEveryPlaceGotFilled = false;
        Player player1Copy;
        Player player2Copy;
        String letterOfPlayer1;
        String letterOfPlayer2;
        int numberOfVictoriesOfPlayer1Copy;
        int numberOfVictoriesOfPlayer2Copy;
        int delay = 10000;
        if (round % 2 == 1) {
            player1Copy = player1;
            player2Copy = player2;
            letterOfPlayer1 = "X";
            letterOfPlayer2 = "O";
            numberOfVictoriesOfPlayer1Copy = numberOfVictoriesOfPlayer1;
            numberOfVictoriesOfPlayer2Copy = numberOfVictoriesOfPlayer2;
        } else {
            player1Copy = player2;
            player2Copy = player1;
            letterOfPlayer1 = "O";
            letterOfPlayer2 = "X";
            numberOfVictoriesOfPlayer1Copy = numberOfVictoriesOfPlayer2;
            numberOfVictoriesOfPlayer2Copy = numberOfVictoriesOfPlayer1;
        }
        do {
            round(gameBoard, letterOfPlayer1, player1Copy, round + "");
            if (gameBoard.isRoundOverBecauseSomeoneWon()) {
                gameBoard.showBoard();
                if (numberOfVictoriesOfPlayer1Copy != 2) {
                    SystemOut.printPlayerWinningRoundAnnouncement(player1Copy, round);
                    player1Copy.addRoundVictory();
                }
                break;
            }
            if (gameBoard.isRoundOverBecauseEveryPlaceGotFilled()) {
                isRoundOverBecauseEveryPlaceGotFilled = gameBoard.isRoundOverBecauseEveryPlaceGotFilled();
                break;
            }
            round(gameBoard, letterOfPlayer2, player2Copy, round + "");
            if (gameBoard.isRoundOverBecauseSomeoneWon()) {
                gameBoard.showBoard();
                if (numberOfVictoriesOfPlayer2Copy != 2) {
                    SystemOut.printPlayerWinningRoundAnnouncement(player2Copy, round);
                    player2Copy.addRoundVictory();
                }
                break;
            }
            isRoundOverBecauseEveryPlaceGotFilled = gameBoard.isRoundOverBecauseEveryPlaceGotFilled();
        } while (!gameBoard.isRoundOverBecauseSomeoneWon() && !isRoundOverBecauseEveryPlaceGotFilled);
        numberOfVictoriesOfPlayer1 = numberOfVictoriesOfPlayer1Copy;
        numberOfVictoriesOfPlayer2 = numberOfVictoriesOfPlayer2Copy;
        if (isRoundOverBecauseEveryPlaceGotFilled) {
            SystemOut.printTieAnnouncement();
        }
    }

    private void round(GameBoard gameBoard, String letter, Player player, String round) {
        boolean needsToRepeat = false;
        int row;
        int column;
        do {
            if (!needsToRepeat) {
                SystemOut.printPlayerTurn(player, letter, round);
                System.out.print(ANSI_RESET);
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
