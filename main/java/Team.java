/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * Team class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Team {
    private String color;
    private ArrayList<Piece> pieces = new ArrayList<Piece>(Arrays.asList());

    /**
     * team constructor
     * @param color
     * @param pieces
     */
    public Team(String color, java.util.ArrayList<Piece> pieces){
        this.color = color;
        this.pieces = pieces;
    }


    public String getTeamColor(){
        return this.color;
    }

    public java.util.ArrayList<Piece> getTeamPieces(){
        return this.pieces;
    }

    /**
     * returns piece
     * @param piece
     */
    public void removePieceFromTeam(Piece piece){
        this.pieces.remove(piece);
    }

    /**
     * adds piece
     * @param piece
     */
    public void addPieceToTeam(Piece piece){
        piece.teamColor = this.color;
        this.pieces.add(piece);
    }

    @Override
    public String toString(){
        Collections.sort(pieces);
        String result = "Team " + this.color + " Pieces :\n";
        int i;
        for (i = 0; i < pieces.size(); ++i){
            result = result + pieces.get(i).toString() + " ";
        }
        return result;
    }
}
