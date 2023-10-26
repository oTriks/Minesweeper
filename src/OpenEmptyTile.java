public class OpenEmptyTile {

    public static int[][] calculateAdjacentMines(int[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;
        int[][] result = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == 1) {
                    // If the current cell is a mine, don't count
                    result[i][j] = -1;
                } else {
                    // Otherwise, calculate the number of adjacent mines
                    result[i][j] = countAdjacentMines(board, i, j);
                }
            }
        }
        return result;
    }

    public static int countAdjacentMines(int[][] board, int row, int col) {
        int count = 0;
        int numRows = board.length;
        int numCols = board[0].length;

        int[][] neighbors = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];

            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                if (board[newRow][newCol] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}