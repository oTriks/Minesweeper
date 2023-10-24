public class checkWin() {
    private GameBoard gameBoard;

    public checkWin(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean checkWin() {
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board)[i][j] ==' ' && !isMine(i, j)){
                    return false;
                }

            }
        }
        return true;
    }

}
//Wed kommenterar controll klassen