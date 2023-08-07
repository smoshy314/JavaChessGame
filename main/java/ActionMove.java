public class ActionMove extends Action{
    public ActionMove(GameS22 game, int fromy, int fromx, int toy, int tox){
        super(game,fromy,fromx,toy,tox);
    }

    public void performAction(){
        this.game.getBoardSquares()[this.fromy][this.fromx].getPiece().speak();
        Piece piece = this.game.getBoardSquares()[this.fromy][this.fromx].removePiece();
        this.game.getBoardSquares()[this.toy][this.tox].setPiece(piece);
        this.game.changeTurn();
    }
}
