import java.util.Random;

public class Mines {
    Random random = new Random();
    private String symbol = "X";
    private int quantity = 10;

    public Mines() {
        setupField();
    }

    public void setupField() {
        while (quantity != 0) {
            int randomRow = random.nextInt(10);
            int randomCol = random.nextInt(10);
            //System.out.println(randomRow + " + " + randomCol);
            if ( !isMine();){
                quantity--;
            }

        }
    }

    //Put into GameBoard class and change names when merged
    public boolean isMine() {
        if (GameBoard[row][col] == "X") {
            return true;
        } else {
            return false;
        }
    }

}
