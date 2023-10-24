import java.util.Random;

public class Mines {
    Random random = new Random();
    int randomRow;
    int randomCol;
    private String symbol = "X";
    private int quantity = 10;

    public Mines() {
        setupField();
    }

    public void setupField() {
        while (quantity != 0) {
            randomRow = random.nextInt(10);
            randomCol = random.nextInt(10);
            //System.out.println(randomRow + " + " + randomCol);
            if (!isMine()){
                placeMine();
                quantity--;
            }
        }
    }

    public boolean isMine() {
        return GameBoard[randomRow][randomCol].equals("X");
    }

    public void placeMine() {
        GameBoard[randomRow][randomCol] = "X";
    }

}