import java.util.Random;

public class Mines {
    Random random = new Random();
    GameBoard gameboard = new GameBoard();
    int randomRow;
    int randomCol;
    private char symbol = 'X';
    private int quantity = 10;

    public Mines() {
        setupField();
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
        return gameboard.getCell(row, col) == symbol;
    }

    public void placeMine() {
        gameboard.setCell(randomRow, randomCol, symbol);
    }





}
