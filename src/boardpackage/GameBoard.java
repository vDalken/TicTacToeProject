package boardpackage;

public class GameBoard {
    private StringBuilder[][] board;
    private final int ROWS = 3;
    private final int COLUMNS = 3;

    public GameBoard() {
        board = new StringBuilder[ROWS][COLUMNS];
        initializeGameBoard();
    }

    private void initializeGameBoard(){
        for(int row=0;row<ROWS; row++){
            for(int column = 0; column<ROWS; column++){
                board[row][column]= new StringBuilder();
            }
        }
    }

    public void fillBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                char rowChar = (char) ('a' + row);
                char colChar = (char) ('1' + column);
                board[row][column].append(rowChar).append(colChar);
            }
        }
    }

    public void showBoard() {
        for (int row = 0; row < ROWS; row++) {
            System.out.println();
            for (int column = 0; column < COLUMNS; column++) {
                System.out.print(board[row][column]+" ");
            }
        }
        System.out.println("\n");
    }
}
