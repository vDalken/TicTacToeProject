package inputpackage;
import java.util.Scanner;

public class InputHandler {
    public static String getString(){
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        return string.trim();
    }
}
