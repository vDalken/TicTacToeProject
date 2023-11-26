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

    public static void printStartOfTheGameMenu() {
        System.out.println("0. Go back to main menu");
        System.out.println("1. Play as a guest");
        System.out.println("2. Create account");
        System.out.println("3. Log in");
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
        System.out.println("Wrong password");
    }
}
