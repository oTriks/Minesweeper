public class GameBoard {
    private final char[][] board;
    public String boardLayout;

    public GameBoard() {
        board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void updateBoardLayout() {
        boardLayout = "\n            A    B    C    D    E    F    G    H    I\n";
        boardLayout += "          ____ ____ ____ ____ ____ ____ ____ ____ ____ \n";
        for (int i = 0; i < 9; i++) {
            boardLayout += "       " + (i + 1) + " |";
            for (int j = 0; j < 9; j++) {
                boardLayout += "  " + board[i][j] + " |";
            }
            boardLayout += "\n         |____|____|____|____|____|____|____|____|____|\n";
        }
    }

    public String getBoardLayout() {
        return boardLayout;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col,char value) {
        board[row][col] = value;
    }

    public char[][] getBoard() {
        return board;
    }
}