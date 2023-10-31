public class GameBoard {
    private char[][] board;
    public String boardLayout;

    public GameBoard() {
        board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '?';
            }
        }
        updateBoardLayout();
    }


    public void updateBoardLayout() {
        boardLayout = "\n    " + Colours.colourNumber(11) + "        1     2     3     4     5     6     7     8     9 " + Colours.colourReset + "\n";
        boardLayout += "          _____ _____ _____ _____ _____ _____ _____ _____ _____ \n";
        for (int i = 0; i < 9; i++) {
            boardLayout += "       " + Colours.colourBoard + (char) ('A' + i) + Colours.colourReset + " |";
            for (int j = 0; j < 9; j++) {
                char numberValue = board[i][j];
                String colourCode = Colours.colourMap.get(numberValue);
                boardLayout += "  " + colourCode + "  |";
            }
            boardLayout += "\n         |_____|_____|_____|_____|_____|_____|_____|_____|_____| \n";
        }
    }

    public String getBoardLayout() {
        return boardLayout;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, char value) {
        board[row][col] = value;
        updateBoardLayout();
    }

    public char[][] getBoard() {
        return board;
    }

}