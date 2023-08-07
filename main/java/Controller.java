import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private GameS22 game;
    private TextView text;

    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",0,0,
                true,false,true));
        piecesTeamA.add(new PieceBobaFett('F',"Blu",0,0,
                true,false,true,false));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",0,
                0,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",0,
                0,0,false, true));
        piecesTeamA.add(new PieceGreenKnight('G',"Blu",false,true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",0,
                0,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",0,0,
                true,false,true));
        piecesTeamB.add(new PieceBobaFett('F',"Red",0,0,
                true,false,true,false));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",0,
                0,0,false, true));
        piecesTeamB.add(new PieceGreenKnight('G',"Red",false,true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller(){
        this.game = setUpGameModel();
        this.text = new TextView();
        this.text.updateView(this.game);
    }

    public void carryOutAction(int fromRow, int fromColumn, int toRow, int toColumn, char action){
        if (action == 'M'){
            ActionMove move = new ActionMove(this.game,fromRow,fromColumn,toRow,toColumn);
            move.performAction();
        }
        else if (action == 'S'){
            ActionSpawn spawn = new ActionSpawn(this.game,fromRow,fromColumn,toRow,toColumn);
            spawn.performAction();
        }
        else if (action == 'R'){
            ActionRecruit recruit = new ActionRecruit(this.game,fromRow,fromColumn,toRow,toColumn);
            recruit.performAction();
        }
        else if (action == 'L') {
            ActionRocket rocket = new ActionRocket(this.game, fromRow, fromColumn, toRow, toColumn);
            rocket.performAction();
        }
        else {
            ActionAttack attack = new ActionAttack(this.game,fromRow,fromColumn,toRow,toColumn);
            attack.performAction();
        }
    }

    public void playGame(){
        int turns = 1;
        Random rand = new Random();
        int rowS = rand.nextInt(game.getGameBoard().getNumRows());
        int colS = rand.nextInt(game.getGameBoard().getNumColumns());
        while(!this.game.isGameEnded()){
            boolean valid = false;
            while (!valid){
                this.text.getNextPlayersAction(this.game);
                valid = Rules.checkValidAction(this.game,this.text.getFromRow(),this.text.getFromColumn(),this.text.getToRow(),this.text.getToColumn(),this.text.getAction());
            }
            carryOutAction(this.text.getFromRow(),this.text.getFromColumn(),this.text.getToRow(),this.text.getToColumn(),this.text.getAction());
            // New Rule Modification : This new rules Shuffles all the pieces
            //    to new random board squares every ten turns
            if (turns % 12 == 0 && turns != 0){
                System.out.println("EARTHQUAKE!!!");
                this.game = new GameS22(8,8,this.game.getCurrentTeam(),this.game.getOpponentTeam());
            }
            if (turns % 6 == 0 || turns == 1){
                game.getBoardSquares()[rowS][colS].toggleSticky();
            }
            if (turns % 12 == 0&& turns!= 0){
                for(int i = 0; i<game.getCurrentTeam().getTeamPieces().size();i++) {
                    if (game.getCurrentTeam().getTeamPieces().get(i) instanceof PieceGreenKnight) {
                        if (((PieceGreenKnight) game.getCurrentTeam().getTeamPieces().get(i)).getDead()) {
                            ((PieceGreenKnight) game.getCurrentTeam().getTeamPieces().get(i)).revive();
                        }
                    }
                }
                for(int i = 0; i<game.getOpponentTeam().getTeamPieces().size();i++) {
                    if (game.getOpponentTeam().getTeamPieces().get(i) instanceof PieceGreenKnight){
                        if (((PieceGreenKnight) game.getOpponentTeam().getTeamPieces().get(i)).getDead()){
                            ((PieceGreenKnight) game.getOpponentTeam().getTeamPieces().get(i)).revive();
                        }
                    }
                }
            }
            turns = turns + 1;
            System.out.println("Turn: " + turns);
            this.text.updateView(this.game);
        }
        this.text.printEndOfGameMessage(this.game);

    }

    public static void main (String args[]){
        Controller controller = new Controller();
        controller.playGame();
    }
}
