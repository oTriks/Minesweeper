import java.util.Random;

public class Mines {   // byta namn?
    Random random = new Random();
    GameBoard solutionBoard = new GameBoard();
    int randomRow;
    int randomCol;
    private char symbol = 'X';
    private int quantity = 10;

    public Mines() {
        setupField();
        calculateAdjacentMines(solutionBoard);
    }

    public void setupField() {
        while (quantity != 0) {
            randomRow = random.nextInt(10);
            randomCol = random.nextInt(10);
            //System.out.println(randomRow + " + " + randomCol);
            if (!isMine(randomRow, randomCol)){
                placeMine();
                quantity--;
            }
        }
    }

    public boolean isMine(int row, int col) {
        return solutionBoard.getCell(row, col) == symbol;
    }

    public void placeMine() {
        solutionBoard.setCell(randomRow, randomCol, symbol);
    }

    // en gång
    public void calculateAdjacentMines(GameBoard solutionBoard) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isMine(i, j)) {
                    solutionBoard.setCell(i, j, countAdjacentMines(solutionBoard, i, j));
                }
            }
        }
    }

    public char countAdjacentMines(GameBoard solutionBoard, int row, int col) {
        int count = 0;

        int[][] neighbors = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];

            if (newRow >= 0 && newRow < 9 && newCol >= 0 && newCol < 9) {
                if (solutionBoard.getCell(newRow, newCol) == symbol){
                    count++;
                }
            }
        }
        return (char)count;
    }

    public GameBoard getSolutionBoard() {  // används i game klassen för att kolla spelarens val mot lösningen
        return solutionBoard;
    }
}
