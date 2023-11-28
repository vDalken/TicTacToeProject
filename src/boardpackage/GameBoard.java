package boardpackage;

public class GameBoard {
    private StringBuilder[][] board;
    private final int ROWS = 3;
    private final int COLUMNS = 3;

    private final String X = "X";
    private final String O = "O";

    public GameBoard() {
        board = new StringBuilder[ROWS][COLUMNS];
        initializeGameBoard();
    }

    private void initializeGameBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < ROWS; column++) {
                board[row][column] = new StringBuilder();
            }
        }
    }

    public void fillBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                char rowChar = (char) ('A' + row);
                char colChar = (char) ('1' + column);
                board[row][column].append(rowChar).append(colChar);
            }
        }
    }

    public void showBoard() {
        for (int row = 0; row < ROWS; row++) {
            System.out.println();
            for (int column = 0; column < COLUMNS; column++) {
                System.out.print("\t" + board[row][column]);
            }
        }
        System.out.println("\n");
    }

    public void fillBoardWithLetter(int row, int column, String letter) {
        board[row][column].replace(0, board[row][column].length(), letter);
    }

    public boolean isPlaceToPlayValid(int row, int column) {
        if (board[row][column].length() == 1) {
            return false;
        }
        return true;
    }

    public boolean isRoundOverBecauseEveryPlaceGotFilled() {
        for (StringBuilder[] place : board) {
            if (place.length != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isRoundOverBecauseSomeoneWon() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (compareLine(row)) {
                    return true;
                }
                if (compareUpAndDown(column)) {
                    return true;
                }
            }
        }

        return compareLeftDiagonal() || compareRightDiagonal();
    }

    private boolean compareLine(int row) {
        for (int column = 1; column < COLUMNS; column++) {
            if (!(board[row][0].compareTo(board[row][column]) == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareUpAndDown(int column) {
        for (int row = 0; row < ROWS; row++) {
            if (!(board[0][column].compareTo(board[row][column]) == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareLeftDiagonal() {
        int row = 0;
        for (int column = 1; column < COLUMNS; column++) {
            row++;
            if (!(board[0][0].compareTo(board[row][column]) == 0)) {
                return false;
            }

        }
        return true;
    }

    private boolean compareRightDiagonal() {
        int row = 0;
        for (int column = 1; column >= 0; column--) {
            row++;
            if (!(board[0][2].compareTo(board[row][column]) == 0)) {
                return false;
            }

        }
        return true;
    }
}
