public class ActionRecruit extends Action{
    public ActionRecruit(GameS22 game, int fromy, int fromx, int toy, int tox){
        super(game,fromy,fromx,toy,tox);
    }

    public void performAction(){
        this.game.getBoardSquares()[this.fromy][this.fromx].getPiece().speak();
        Piece opponentPiece = this.game.getBoardSquares()[this.toy][this.tox].getPiece();
        this.game.getOpponentTeam().removePieceFromTeam(opponentPiece);
        this.game.getCurrentTeam().addPieceToTeam(opponentPiece);
        this.game.changeTurn();

    }
}
