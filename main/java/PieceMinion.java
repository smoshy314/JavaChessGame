import static java.lang.Math.abs;

/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 *
 * Minion Piece that extends abstract piece
 */
public class PieceMinion extends Piece implements Recruiter{
    protected int numRecruits;
    protected int numTimesSpawned;

    public final static int MAX_NUM_SPAWNED = 3;

    /**
     * @param symbol the symbol to be set to the piece
     * @param teamColor the team color to be set to the piece
     * @param numRecruits the number of recruits value to be set to the piece
     * @param numTimesSpawned the number of spawns value to be set to the piece
     * @param hidden the truth value of hidden to be set to the piece
     * @param original the truth value of original to be set to the piece
     * This function constructs a PieceMinion with the attributes borrowed from the parameters
     * and using the constructor from the Piece class
     */
    public PieceMinion(char symbol, String teamColor,
                       int numRecruits, int numTimesSpawned,
                       boolean hidden, boolean original) {
        super(symbol,teamColor,hidden,original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    /**
     * This function constructs a PieceMinion with no parameters and thus default attributes
     */
    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }

    /**
     * gets recruits
     * @return
     */
    public int getNumRecruits() {
        return numRecruits;
    }

    /**
     * gets number of times spawned
     * @return
     */
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    /**
     * Sets the number of recruites
     * @param numRecruits
     */
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    public boolean validRecruitPath(int rowR, int colR, int rowA, int colA) {
       return validMovePath(rowR,colR,rowA,colA);
    }

    /**
     * Overrides the speak function
     */
    @Override
    public void speak(){
        System.out.println("Bello!");
    }

    /**
     * Overrides valid move path
     * @param fromSquareRow
     * @param fromSquareCol
     * @param toSquareRow
     * @param toSquareCol
     * @return
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        if (toSquareCol - fromSquareCol == 0) {
            return true;
        }
        else if ((toSquareRow - fromSquareRow == 0) && abs(toSquareCol - fromSquareCol) == 2){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                  int toSquareRow, int toSquareCol) {
        return true;
    }
    /**
     * @return a new minion piece with some shared attributes and some different
     * Increments the amount of pieces spawned by one and creates a new piece with
     * a lower case symbol and original set to false
     * In the process it overrides the abstract spawn function in the Piece class
     */
    @Override
    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(this.symbol), this.teamColor,1, 0, false, false);
    }
    /**
     * @return if the piece can spawn another piece
     * checks if the piece is original and if the number of times it has spawned is
     * less than the maximum number of spawns alowed
     * In the process it overrides the abstract canSpawn function in the Piece class
     */
    @Override
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }
}
