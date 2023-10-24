import java.util.Random;

public class Mines {
    Random random = new Random();
    private String symbol = "X";
    private int quantity = 10;

    public Mines () {
        setupField();
    }

    public void setupField(){
        while (quantity != 0) {
            int row = random.nextInt(10);
            int col = random.nextInt(10);
            System.out.println(row + " + " + col);
            quantity--;
        }
    }

}
