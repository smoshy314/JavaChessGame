public class GameS22 extends Game{


    /**
     * Constuctor for game
     *
     * @param rows
     * @param columns
     * @param team1
     * @param team2
     */
    public GameS22(int rows, int columns, Team team1, Team team2) {
        super(rows, columns, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        if (getCurrentTeam().getTeamPieces().isEmpty() || !getOpponentTeam().getTeamPieces().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Team getWinner() {
        Team test = null;
        for(int i = 0; i<getCurrentTeam().getTeamPieces().size();i++) {
            if (getCurrentTeam().getTeamPieces().get(i) instanceof PieceBlueHen) {
                test = getCurrentTeam();
            }
        }
        for (int i = 0; i<getOpponentTeam().getTeamPieces().size();i++) {
            if (getOpponentTeam().getTeamPieces().get(i) instanceof PieceBlueHen) {
                test = getOpponentTeam();
            }
        }
        return test;
    }
    // New Objective Modification : To win the game one team must remove all of
    //    The other teams PieceBlueHens. In hindsite this objective is a bit to easy
    //    To make it more difficult we could probably start both Teams with more than one pieceBlueHen
    @Override
    public boolean isGameEnded() {
        boolean flag = true;
        boolean flag1 = true;
        for(int i = 0; i<getCurrentTeam().getTeamPieces().size();i++) {
            if (getCurrentTeam().getTeamPieces().get(i) instanceof PieceBlueHen) {
                flag1 = false;
            }
        }
        for (int i = 0; i<getOpponentTeam().getTeamPieces().size();i++) {
            if (getOpponentTeam().getTeamPieces().get(i) instanceof PieceBlueHen) {
                flag = false;
            }
        }
        return flag || flag1;
    }
}
