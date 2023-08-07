/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * Prints the game board
 */
import java.lang.Math;

public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    /**
     * Constructor for GameBoard with column and row parameter
     * @param numRows - number of row
     * @param numColumns - number of columns
     */
    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    /**
     * Gets num Rows
     * @return
     */
    public int getNumRows(){
        return this.numRows;
    }

    /**
     * get num Columns
     * @return
     */
    public int getNumColumns(){
        return this.numColumns;
    }

    /**
     * returns The squares that make up the board
     * @return
     */
    public BoardSquare[][] getSquares(){
        return this.squares;
    }

    /**
     * Tests if a row and column is in Board
     * @param row
     * @param column
     * @return
     */
    public boolean inBounds(int row, int column){
        return ((row < this.numRows && row >= 0) && (column < this.numColumns && column >= 0));
    }

    /**
     * Sets up an empty board
     */
    private void setUpEmptyBoard(){
        int i;
        int j;
        for (i = 0; i < this.numRows; ++i){
            for (j = 0; j < this.numColumns; ++j){
                this.squares[i][j] = new BoardSquare("White");
            }
        }
    }

    /**
     * Returns A square with nothing on it
     * @return
     */
    public BoardSquare findRandomEmptySpace(){
        int randomRow = (int) (Math.random() * numRows);
        int randomColumn = (int) (Math.random() * numColumns);
        while (!this.squares[randomRow][randomColumn].isEmpty()){
            randomRow = (int) (Math.random() * numRows);
            randomColumn = (int) (Math.random() * numColumns);
        }
        return this.squares[randomRow][randomColumn];
    }

    /**
     * Overrides toString method to print the board created
     * @return
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
