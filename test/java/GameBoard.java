import java.lang.Math;

public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows(){
        return this.numRows;
    }

    public int getNumColumns(){
        return this.numColumns;
    }

    public BoardSquare[][] getSquares(){
        return this.squares;
    }

    public boolean inBounds(int row, int column){
        return ((row < this.numRows && row >= 0) && (column < this.numColumns && column >= 0));
    }

    private void setUpEmptyBoard(){
        int i;
        int j;
        for (i = 0; i < this.numRows; ++i){
            for (j = 0; j < this.numColumns; ++j){
                this.squares[i][j] = new BoardSquare("White");
            }
        }
    }

    public BoardSquare findRandomEmptySpace(){
        int randomRow = (int) (Math.random() * numRows);
        int randomColumn = (int) (Math.random() * numColumns);
        while (!this.squares[randomRow][randomColumn].isEmpty()){
            randomRow = (int) (Math.random() * numRows);
            randomColumn = (int) (Math.random() * numColumns);
        }
        return this.squares[randomRow][randomColumn];
    }

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
