package outputpackage;

public class SystemOut {
    public static void printMainMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Player Versus Player");
        System.out.println("2. Leaderboard");
    }

    public static void printExitOfTheGame() {
        System.out.println("You're exiting the game");
    }

    public static void printSelectedOptionError() {
        System.out.println("Selected option non existent, please type in one of the shown options");
    }

    public static void printStartOfTheGameMenu(String numberOfPlayer) {
        System.out.println("\nIt's player "+ numberOfPlayer+ " turn\n");
        System.out.println("0. Go back to main menu");
        System.out.println("1. Play as a guest");
        System.out.println("2. Create account");
        System.out.println("3. Log in\n");
    }

    public static void printGoBackToMainMenuOption() {
        System.out.println("You're returning to the main menu");
    }

    public static void printUsernameOption() {
        System.out.println("Please type in your username");
    }

    public static void printGameNameOption() {
        System.out.println("Type in your game name (name visible to all players)");
    }

    public static void printPasswordOption() {
        System.out.println("Please type in your password");
    }

    public static void printUsernameNotFound() {
        System.out.println("Username not found in our database");
    }

    public static void printWrongPassword() {
        System.out.println("Wrong password, maybe try with another account");
    }

    public static void printUsernameAlreadyExists(){
        System.out.println("Username already exists, please write another one");
    }

    public static void printGameNameAlreadyExists(){
        System.out.println("Game name already exists, please type in another one");
    }

    public static void printSuccessfulLogIn(){
        System.out.println("\nLog in successful");
    }

    public static void printUnsuccessfulLogIn(){
        System.out.println("\nLog in unsuccessful, player1 already logged in with that account\n");
    }

    public static void printPlaceToPlay(){
        System.out.println("Choose where you want to place your symbol");
    }

    public static void printPlaceToPlayError(){System.out.println("That position doesn't exist, try another one");};

    public static void printPlayerTurn(String numberOfPlayer){
        System.out.println("\nIt's player "+ numberOfPlayer+ " turn");
    }
}
