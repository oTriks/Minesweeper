import java.util.Random;

public class Mines {
    Random random = new Random();
    private GameBoard gameboard;
    int randomRow;
    int randomCol;
    private char symbol = '☢';
    private int quantity = 10;

    public Mines(GameBoard gameboard) {
        this.gameboard = gameboard;
        setupField();
    }

    public void setupField() {
        while (quantity != 0) {
            randomRow = random.nextInt(9);
            randomCol = random.nextInt(9);
            //System.out.println(randomRow + " + " + randomCol);
            if (!isMine(randomRow, randomCol)){
                placeMine();
                quantity--;
            }
        }
    }

    public void showAllMines(){
        System.out.println(gameboard.getBoardLayout());
    }

    public boolean isMine(int row, int col) {
        return gameboard.getCell(row, col) == symbol;
    }

    public void placeMine() {
        gameboard.setCell(randomRow, randomCol, symbol);
    }
}
