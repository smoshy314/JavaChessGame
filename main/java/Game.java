/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * Runs the whole game
 */
import java.util.Collections;

public abstract class Game {
    private GameBoard board;
    private Team currentTeam;
    private Team opponentTeam;
    private String turn;

    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

    /**
     * creates and initializes game board
     * @param rows
     * @param columns
     */
    private void initializeGameBoard(int rows, int columns){
        this.board = new GameBoard(rows,columns);
        int i;
        for (i = 0; i < this.currentTeam.getTeamPieces().size(); ++i){
            this.board.findRandomEmptySpace().setPiece(this.currentTeam.getTeamPieces().get(i));
        }
        for (i = 0; i < this.opponentTeam.getTeamPieces().size(); ++i){
            this.board.findRandomEmptySpace().setPiece(this.opponentTeam.getTeamPieces().get(i));
        }
    }

    /**
     * Constuctor for game
     * @param rows
     * @param columns
     * @param team1
     * @param team2
     */
    public Game(int rows, int columns, Team team1, Team team2){
        this.currentTeam = team1;
        this.opponentTeam = team2;
        this.turn = this.currentTeam.getTeamColor();
        initializeGameBoard(rows,columns);
    }

    /**
     * returns game board
     * @return
     */
    public GameBoard getGameBoard(){
        return this.board;
    }

    /**
     * returns current team
     * @return
     */
    public Team getCurrentTeam(){
        return this.currentTeam;
    }

    /**
     * returns opponent teams
     * @return
     */
    public Team getOpponentTeam(){
        return this.opponentTeam;
    }

    /**
     * returns is turn
     * @param team
     * @return
     */
    public boolean isTurn(Team team){
        return this.currentTeam == team;
    }

    /**
     * returns board squared
     * @return
     */
    public BoardSquare[][] getBoardSquares(){
        return this.board.getSquares();
    }

    /**
     * Changes turn
     */
    public void changeTurn(){
        Team middle = this.currentTeam;
        this.currentTeam = this.opponentTeam;
        this.opponentTeam = middle;
    }

    /**
     * Overides to string
     * @return
     */
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
}
