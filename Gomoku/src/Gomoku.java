/**
 * @author Alexander Leon
 */

import cs251.lab2.*;
import static cs251.lab2.GomokuInterface.Square.CROSS;
import static cs251.lab2.GomokuInterface.Square.RING;
import static cs251.lab2.GomokuInterface.Square.EMPTY;

public class Gomoku implements GomokuInterface{
    private GomokuInterface.Square[][] board;
    private Square currentTurn = CROSS;
    private static boolean computerEnabled = false;
    public int getNumRows() {
        return DEFAULT_NUM_ROWS;
    }
    public int getNumCols() {
        return DEFAULT_NUM_COLS;
    }
    public int getNumInLineForWin() {
        return SQUARES_IN_LINE_FOR_WIN;
    }
    public void initializeGame() {
        board = new Square[getNumRows()][getNumCols()];
        for (int row = 0; row < getNumRows(); row++) {
            for (int col = 0; col < getNumCols(); col++) {
                board[row][col] = Square.EMPTY;
            }
        }
    }
    public GomokuInterface.TurnResult handleClickAt(int row, int col) {
        if (board[row][col] != Square.EMPTY) {
            return GomokuInterface.TurnResult.GAME_NOT_OVER;
        } else {
            board[row][col] = currentTurn;
            if (checkWin(row, col)) {
                TurnResult result = (currentTurn == Square.CROSS) ?
                        TurnResult.CROSS_WINS : TurnResult.RING_WINS;
                initializeGame();
                currentTurn = (result == GomokuInterface.TurnResult.CROSS_WINS)
                        ? Square.CROSS : Square.RING;
                return result;
            }
            if (checkDraw()) return TurnResult.DRAW;
        }

        // Make a move for the computer player (if enabled)
        if (computerEnabled) {
            currentTurn = getCurrentTurn();
            computerMove(row,col);
            if (checkWin(row, col)) {
                TurnResult result = (currentTurn == Square.RING) ?
                        TurnResult.RING_WINS : TurnResult.CROSS_WINS;
                initializeGame();
                currentTurn = (result == GomokuInterface.TurnResult.RING_WINS)
                        ? Square.RING : Square.CROSS;
                return result;
            }
            if (checkDraw()){
                return TurnResult.DRAW;
            }
        } else {
            currentTurn = getCurrentTurn();
        }
        return TurnResult.GAME_NOT_OVER;
    }

    /**
     * The computerMove method fills in a value for the computer player. The
     * strategy is to use any of the 8 potential surrounding spaces. If there
     * is not any available space, it would choose the first available square
     * of the board.
     * @param row last row used by the player
     * @param col last column used by the player
     */
    private void computerMove(int row,int col) {
        //Potential 8 directions relative to a point
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        //Choose a new position and check if it is between the board and if the
        //square is empty
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPosition(newRow,newCol) && board[newRow][newCol]
                    == Square.EMPTY) {
                board[newRow][newCol] = currentTurn;
                currentTurn = getCurrentTurn();
                return; // Exit after making one move
            }
        }
        //If no surrounding box is available, any empty space is filled
        for (int row0 = 0; row0 < getNumRows(); row0++) {
            for (int col0 = 0; col0 < getNumCols(); col0++) {
                if (board[row0][col0] == Square.EMPTY) {
                    board[row0][col0] = currentTurn;
                    currentTurn = getCurrentTurn();
                    return; // Exit after making one move
                }
            }
        }
    }
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols();
    }
    private boolean checkDraw() {
        for(int i = 0; i < getNumRows(); i++){
            for(int j = 0;j < getNumCols(); j++){
                if (board[i][j]==Square.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkWin (int row,int col){
        Square play = board[row][col];
        // Check horizontal line
        int count = 1;
        for (int c = col - 1; c >= 0 && board[row][c] == play; c--) {
            count++;
        }
        for (int c = col + 1;c< getNumCols() && board[row][c]==play; c++){
            count++;
        }
        if (count >= getNumInLineForWin()) {
            return true;
        }
        // Check vertical line
        count = 1;
        for (int r = row - 1; r >= 0 && board[r][col] == play; r--) {
            count++;
        }
        for (int r = row + 1; r < getNumRows() && board[r][col] == play; r++) {
            count++;
        }
        if (count >= getNumInLineForWin()) {
            return true;
        }
        // Check first diagonal line
        count = 1;
        for (int r = row - 1, c = col + 1; r >= 0 && c < getNumCols() &&
                board[r][c] == play; r--, c++) {
            count++;
        }
        for (int r = row + 1, c = col - 1; r < getNumRows() && c >= 0 &&
                board[r][c] == play; r++, c--) {
            count++;
        }
        if (count >= getNumInLineForWin()) {
            return true;
        }
        // Check second diagonal line
        count = 1;
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0 &&
                board[r][c] == play; r--, c--) {
            count++;
        }
        for (int r = row + 1, c = col + 1; r < getNumRows() && c < getNumCols()
                && board[r][c] == play; r++, c++) {
            count++;
        }
        return count >= getNumInLineForWin();
    }
    public String getCurrentBoardAsString() {
        // Generate and return a string representation of the game board
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                sb.append(board[row][col].toChar());
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    public GomokuInterface.Square getCurrentTurn() {
        // Determine and return whose turn it is
        currentTurn = (currentTurn == GomokuInterface.Square.CROSS)
                ? GomokuInterface.Square.RING : GomokuInterface.Square.CROSS;
        return currentTurn;
    }
    public void initComputerPlayer(String opponent) {
        if (opponent.equalsIgnoreCase("COMPUTER")) {
            computerEnabled = true;
        } else if (opponent.equalsIgnoreCase("NONE")){
            computerEnabled = false;
        }
    }
    public static void main (String [] args) {
        Gomoku game =  new Gomoku();
        if (args.length > 0) {
            game.initComputerPlayer(args[0]);
        }
        GomokuGUI.showGUI(game);
    }
}