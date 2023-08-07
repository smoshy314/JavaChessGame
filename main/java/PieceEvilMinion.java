import static java.lang.Math.abs;

/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * Evil version of piece minion
 */
public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter{
    private int numAttacks;
    private boolean hungry;

    public final static int MAX_ATTACKS = 4;

    /**
     * Constructor with all parameters
     * @param symbol
     * @param teamColor
     * @param numRecruits
     * @param numAttacks
     * @param numTimesSpawned
     * @param hidden
     * @param original
     */
    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original){
        super(symbol,teamColor,numRecruits,numTimesSpawned,hidden,original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    /**
     * Zero param constructor
     */
    public PieceEvilMinion(){
        this('E',"NON",0,0,0,false,true);
    }

    /**
     * get number attacks
     * @return
     */
    public int getNumAttacks(){
        return this.numAttacks;
    }

    /**
     * Returns if can attack
     * @return
     */
    public boolean canAttack(){
        return this.hungry;
    }

    /**
     * sets teh symbol
     * @param symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Sets the team color
     * @param teamColor
     */
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * sets num attacks
     * @param numAttacks
     */
    public void setNumAttacks(int numAttacks){
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return validMovePath(fromSquareRow,fromSquareCol,toSquareRow,toSquareCol);
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                  int toSquareRow, int toSquareCol) {
       return validMovePath(fromSquareRow,fromSquareCol,toSquareRow,toSquareCol);
    }
    /**
     * sets number of times spawned
     * @param numTimesSpawned
     */
    public void setNumTimesSpawned(int numTimesSpawned){
        this.numTimesSpawned = numTimesSpawned;
    }

    /**
     * updates if has too little attacks
     */
    public void updateHungry(){
        this.hungry = this.numAttacks < MAX_ATTACKS;
    }

    /**
     * Overrides speak
     */
    @Override
    public void speak(){
        System.out.println("Roar!");
    }


    /**
     * Overrides Evil Minion
     * @return
     */
    @Override
    public PieceEvilMinion spawn(){
        this.numTimesSpawned = this.numTimesSpawned + 1;
        return new PieceEvilMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,0,
                false,
                false);

    }
}
