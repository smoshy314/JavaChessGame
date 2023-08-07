import java.util.ArrayList;

public class Rules {
    public static boolean checkValidAction(GameS22 Game, int row, int col, int row2, int col2, char action) {
        boolean valid = false;
        if (!Game.getBoardSquares()[row][col].getSticky()) {
            if (action == 'M') {
                //Both squares are in bounds
                if (Game.getGameBoard().inBounds(row, col) && Game.getGameBoard().inBounds(row2, col2)) {
                    //Starting square has piece
                    if (!(Game.getBoardSquares()[row][col].isEmpty())) {
                        //Piece on Start in current team
                        if (Game.getBoardSquares()[row][col].getPiece().getTeamColor().equals(Game.getCurrentTeam().getTeamColor())) {
                            //To Square is Empty
                            if (Game.getBoardSquares()[row2][col2].isEmpty()) {
                                //Is valid move path
                                if (Game.getBoardSquares()[row][col].getPiece().validMovePath(row, col, row2, col2)) {
                                    if (Game.getBoardSquares()[row2][col2].getPiece() instanceof PieceGreenKnight){
                                        if(!(((PieceGreenKnight) Game.getBoardSquares()[row2][col2].getPiece()).getDead())) {
                                            valid = true;
                                        }
                                    } else {
                                        valid = true;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (action == 'S') {
                //Both squares are in bounds
                if (Game.getGameBoard().inBounds(row, col) && Game.getGameBoard().inBounds(row2, col2)) {
                    //Starting square has piece
                    if (!(Game.getBoardSquares()[row][col].isEmpty())) {
                        //Piece on Start in current team
                        if (Game.getBoardSquares()[row][col].getPiece().getTeamColor().equals(Game.getCurrentTeam().getTeamColor())) {
                            //To Square is Empty
                            if (Game.getBoardSquares()[row2][col2].isEmpty()) {
                                //Valid spawn path
                                if (Game.getBoardSquares()[row][col].getPiece().validSpawnPath(row, col, row2, col2)) {
                                    //is original
                                    if (Game.getBoardSquares()[row][col].getPiece().isOriginal()) {
                                        //Is PIece mininon path
                                        if (Game.getBoardSquares()[row][col].getPiece() instanceof PieceMinion && !(Game.getBoardSquares()[row][col].getPiece() instanceof PieceEvilMinion)) {
// Action Spawn for PIece Minion account for Nearest Corner but not Nearest EMPTY corner
                                            int rows = Game.getGameBoard().getNumRows() - 1;
                                            int cols = Game.getGameBoard().getNumColumns() - 1;

                                            if (col2 == 0 && row2 == 0) {
                                                if (row <= rows / 2 && col <= cols / 2) {
                                                    valid = true;
                                                }
                                            } else if (col2 == 0 && row2 == rows) {
                                                if (rows >= rows / 2 && col <= cols / 2) {
                                                    valid = true;
                                                }
                                            } else if (row2 == 0 && col2 == cols) {
                                                if (col >= cols / 2 && row <= rows / 2) {
                                                    valid = true;
                                                }
                                            } else if (row2 == rows && col2 == cols) {
                                                if (col >= cols / 2 && row >= rows / 2) {
                                                    valid = true;
                                                }
                                            }
                                        } else {
                                            valid = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (action == 'R') {
                //Both squares are in bounds
                if (Game.getGameBoard().inBounds(row, col) && Game.getGameBoard().inBounds(row2, col2)) {
                    //Starting square has piece
                    if (!(Game.getBoardSquares()[row][col].isEmpty())) {
                        //Piece on Start in current team
                        if (Game.getBoardSquares()[row][col].getPiece().getTeamColor().equals(Game.getCurrentTeam().getTeamColor())) {
                            //To Square has Piece
                            if (!(Game.getBoardSquares()[row2][col2].isEmpty())) {
                                //To Square Piece is opponent team
                                if (Game.getBoardSquares()[row2][col2].getPiece().getTeamColor().equals(Game.getOpponentTeam().getTeamColor())) {
                                    //Valid Recruit path
                                    if (Game.getBoardSquares()[row][col].getPiece() instanceof Recruiter && ((Recruiter) Game.getBoardSquares()[row][col].getPiece()).validRecruitPath(row, col, row2, col2)) {
                                        if (!(Game.getBoardSquares()[row2][col2].getPiece() instanceof PieceGreenKnight && ((PieceGreenKnight) Game.getBoardSquares()[row2][col2].getPiece()).getDead())) {
                                            valid = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (action == 'A') {
                //Both squares are in bounds
                if (Game.getGameBoard().inBounds(row, col) && Game.getGameBoard().inBounds(row2, col2)) {
                    //Starting square has piece
                    if (!(Game.getBoardSquares()[row][col].isEmpty())) {
                        //Piece on Start in current team
                        if (Game.getBoardSquares()[row][col].getPiece().getTeamColor().equals(Game.getCurrentTeam().getTeamColor())) {
                            //To Square has Piece
                            if (!(Game.getBoardSquares()[row2][col2].isEmpty())) {
                                //Checks opponent team
                                if (Game.getBoardSquares()[row2][col2].getPiece().getTeamColor().equals(Game.getOpponentTeam().getTeamColor())) {
                                    //checks if buzz
                                    if ((Game.getBoardSquares()[row][col].getPiece() instanceof PieceBuzz && ((PieceBuzz) Game.getBoardSquares()[row][col].getPiece()).canAttack() && ((PieceBuzz) Game.getBoardSquares()[row][col].getPiece()).validAttackPath(row, col, row2, col2)) || (Game.getBoardSquares()[row][col].getPiece() instanceof PieceEvilMinion && ((PieceEvilMinion) Game.getBoardSquares()[row][col].getPiece()).canAttack() && ((PieceEvilMinion) Game.getBoardSquares()[row][col].getPiece()).validAttackPath(row, col, row2, col2)) || Game.getBoardSquares()[row][col].getPiece() instanceof PieceBlueHen && ((PieceBlueHen) Game.getBoardSquares()[row][col].getPiece()).validAttackPath(row, col, row2, col2)) {
                                        valid = true;
                                    }
                                    if (Game.getBoardSquares()[row][col].getPiece() instanceof PieceGreenKnight && ((PieceGreenKnight) Game.getBoardSquares()[row][col].getPiece()).validAttackPath(row,col,row2,col2)){
                                        valid = true;
                                    }
                                } else {
                                    if (Game.getBoardSquares()[row][col].getPiece() instanceof PieceEvilMinion && ((PieceEvilMinion) Game.getBoardSquares()[row][col].getPiece()).canAttack()) {
                                        valid = true;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (action == 'L') {
                if (Game.getGameBoard().inBounds(row, col) && Game.getGameBoard().inBounds(row2, col2)) {
                    //Starting square has piece
                    if (!(Game.getBoardSquares()[row][col].isEmpty())) {
                        //Piece on Start in current team
                        if (Game.getBoardSquares()[row][col].getPiece().getTeamColor().equals(Game.getCurrentTeam().getTeamColor())) {
                            //To Square has Piece
                            if (!(Game.getBoardSquares()[row2][col2].isEmpty())) {
                                //Checks if evil Minion
                                if (Game.getBoardSquares()[row2][col2].getPiece().getTeamColor().equals(Game.getOpponentTeam().getTeamColor())) {
                                    //checks if buzz
                                    if ((Game.getBoardSquares()[row][col].getPiece() instanceof PieceBobaFett && ((PieceBobaFett) Game.getBoardSquares()[row][col].getPiece()).canAttack()) && ((PieceBobaFett) Game.getBoardSquares()[row][col].getPiece()).getWorkingRocket()) {
                                        if (!(Game.getBoardSquares()[row2][col2].getPiece() instanceof PieceGreenKnight && ((PieceGreenKnight) Game.getBoardSquares()[row2][col2].getPiece()).getDead())) {
                                            valid = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }else{
            System.out.println("This Piece is Stuck!");
        }
        return valid;
    }

    public static void main(String[] arg) {
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M', "Blu",
                0, 0, false, true));
        piecesTeamA.add(new PieceBuzz('B', "Blu", 2, 1,
                true, false, true));
        piecesTeamA.add(new PieceBlueHen('H', "Blu", 3,
                9, false, true));
        piecesTeamA.add(new PieceEvilMinion('E', "Blu", 1,
                1, 4, false, true));
        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M', "Red",
                0, 0, false, true));
        piecesTeamB.add(new PieceBlueHen('H', "Red", 3,
                9, false, true));
        piecesTeamB.add(new PieceBuzz('B', "Red", 2, 1,
                true, false, true));
        piecesTeamB.add(new PieceEvilMinion('E', "Red", 1,
                1, 4, false, true));
        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);

        // create a game
        GameS22 game = new GameS22(6, 6, teamA, teamB);

        // clear Piece off the board
        for (int row = 0; row < game.getGameBoard().getNumRows(); row++) {
            for (int col = 0; col < game.getGameBoard().getNumColumns(); col++) {
                game.getGameBoard().getSquares()[row][col].removePiece();
            }
        }
        System.out.println(game);

        // load your pieces in specific locations of your choice
        game.getGameBoard().getSquares()[0][0].setPiece(piecesTeamA.get(0));
        game.getGameBoard().getSquares()[0][1].setPiece(piecesTeamA.get(1));
        game.getGameBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getGameBoard().getSquares()[0][3].setPiece(piecesTeamA.get(3));
        game.getGameBoard().getSquares()[2][0].setPiece(piecesTeamB.get(0));
        game.getGameBoard().getSquares()[2][1].setPiece(piecesTeamB.get(1));
        game.getGameBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getGameBoard().getSquares()[2][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        // Test some moves that should be valid
        // Test some moves that are invalid

        // This should be a valid move
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                1, 4, 'M'));

        // To Square isn't empty - should not be a valid move
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 1, 'M'));
        // This isn't current team's piece - should not be valid
        System.out.println(Rules.checkValidAction(game,
                2, 0,
                0, 5, 'M'));


        // You can change the turn to test the other team pieces
        game.changeTurn();

        System.out.println(Rules.checkValidAction(game,
                2, 0,
                0, 5, 'M'));


    }
}

