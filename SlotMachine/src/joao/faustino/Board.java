package joao.faustino;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int boardColumns;
    private final int boardRows;
    private Symbol[][] board;

    /**
    Creates a new board with a given rows and columns
    the board is filled with Symbols
     */
    Board(int rows, int columns){
        this.boardRows = rows;
        this.boardColumns = columns;
        board = new Symbol[boardRows][boardColumns];
    }

    /**
    Sets the given Symbol in the given row and column
     */
    public void setBoard(Symbol symbol, int row, int column){
        if(row >= boardRows || column >= boardColumns)
            return;
        board[row][column] = symbol;
    }

    /**
    Returns the name of the Symbol in the given row and column
     */
    public String getSymbolNameInBoard(int row, int column){
        if(row >= boardRows || column >= boardColumns)
            return null;
        return board[row][column].getName();
    }

    /**
    Returns the Symbol in the given row and column
     */
    public Symbol getSymbolInBoard(int row, int column){
        if(row >= boardRows || column >= boardColumns)
            return null;
        return board[row][column];
    }

    /**
    Returns a String with the board's state
     */
    public String printBoard(){
        StringBuilder print = new StringBuilder();
        for(int i = 0; i < boardRows; i++){
            for(int j = 0; j < boardColumns; j++){
                if(j == boardColumns - 1) {
                    print.append(getSymbolNameInBoard(i, j)).append("\n");
                }
                else
                    print.append(getSymbolNameInBoard(i,j)).append(" | ");
            }
        }
        print.deleteCharAt(print.length()-1);
        return print.toString();
    }

    /**
    Returns the total Rows of the board
     */
    public int getBoardRows(){
        return boardRows;
    }

    /**
    Returns the total Columns of the board
     */
    public int getBoardColumns(){
        return boardColumns;
    }


/*
    public int getPointsInRow(int row){
        if(row >= boardRows)
            return -1;
        int rowPoints = 0;
        for(int i = 0; i < boardColumns; i++){
            rowPoints += board[row][i].getPoints();
        }
        return rowPoints;
    }

    public int getPointsInColumn(int column){
        if(column >= boardColumns)
            return -1;
        int columnPoints = 0;
        for(int i = 0; i < boardRows; i++){
            columnPoints += board[i][column].getPoints();
        }
        return columnPoints;
    }

 */

}
