package outputpackage;

import playerpackage.Player;

public class SystemOut {
    // ANSI escape codes for colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static void printMainMenu() {
        System.out.println(ANSI_CYAN + "0. Exit" + ANSI_RESET);
        System.out.println(ANSI_YELLOW +"1. Player Versus Player" + ANSI_RESET);
        System.out.println(ANSI_GREEN +"2. Leaderboard" + ANSI_RESET);
    }

    public static void printExitOfTheGame() {
        System.out.println(ANSI_RED + "You're exiting the game" + ANSI_RESET);
    }

    public static void printSelectedOptionError() {
        System.out.println(ANSI_RED + "Selected option non-existent, please type in one of the shown options" + ANSI_RESET);
    }

    public static void printStartOfTheGameMenu(String numberOfPlayer) {
        System.out.println("\n" + ANSI_CYAN + "It's player number " + numberOfPlayer + " time to choose\n");
        System.out.println("0. Go back to the main menu" + ANSI_RESET + ANSI_YELLOW);
        System.out.println("1. Play as a guest");
        System.out.println("2. Create account");
        System.out.println("3. Log in" + ANSI_RESET + "\n");
    }

    public static void printGoBackToMainMenuOption() {
        System.out.println(ANSI_YELLOW + "You're returning to the main menu" + ANSI_RESET);
    }

    public static void printUsernameOption() {
        System.out.println(ANSI_CYAN + "Please type in your username" + ANSI_RESET);
    }

    public static void printGameNameOption() {
        System.out.println(ANSI_CYAN + "Type in your game name (name visible to all players)" + ANSI_RESET);
    }

    public static void printPasswordOption() {
        System.out.println(ANSI_CYAN + "Please type in your password" + ANSI_RESET);
    }

    public static void printUsernameNotFound() {
        System.out.println(ANSI_RED + "Username not found in our database" + ANSI_RESET);
    }

    public static void printWrongPassword() {
        System.out.println(ANSI_RED + "Wrong password, maybe try with another account" + ANSI_RESET);
    }

    public static void printUsernameAlreadyExists() {
        System.out.println(ANSI_RED + "Username already exists, please write another one" + ANSI_RESET);
    }

    public static void printGameNameAlreadyExists() {
        System.out.println(ANSI_RED + "Game name already exists, please type in another one" + ANSI_RESET);
    }

    public static void printSuccessfulLogIn() {
        System.out.println("\n" + ANSI_GREEN + "Log in successful" + ANSI_RESET);
    }

    public static void printUnsuccessfulLogIn() {
        System.out.println("\n" + ANSI_RED + "Log in unsuccessful, player1 already logged in with that account\n" + ANSI_RESET);
    }

    public static void printPlaceToPlay() {
        System.out.println(ANSI_CYAN + "Choose where you want to place your symbol" + ANSI_RESET);
    }

    public static void printPlayerTurn(Player player, String letter, String round) {
        String name = player.getGameName() == null ? "guest" : player.getGameName();
        System.out.println("\n" + ANSI_CYAN + name + ", it's your turn\nLetter: " + letter + "\nRound: " + round);
        if (!(player.getNumberOfRoundVictories() == 0)) {
            System.out.println("Rounds won: " + player.getNumberOfRoundVictories() + ANSI_RESET);
        }
    }

    public static void printPlaceError() {
        System.out.println("\n" + ANSI_RED + "That place was already picked, pick another one\n" + ANSI_RESET);
    }

    public static void printPlayerWinningRoundAnnouncement(Player player, int round) {
        System.out.println(ANSI_GREEN + player.getGameName() + " won round " + round + "\n" + ANSI_RESET);
    }

    public static void printTieAnnouncement() {
        System.out.println("\n" + ANSI_YELLOW + "There was a tie, we will need to retry" + ANSI_RESET);
    }

    public static void printPlayerWinningGameAnnouncement(Player player) {
        System.out.println(ANSI_GREEN + player.getGameName() + " won the game\n" + ANSI_RESET);
    }

    public static void printQuestionAboutPlayers() {
        System.out.println(ANSI_CYAN + "Are the same players from before still going to play? (write yes or no)" + ANSI_RESET);
    }

    public static void printYesOrNo() {
        System.out.println(ANSI_CYAN + "Write yes or no please" + ANSI_RESET);
    }
}
