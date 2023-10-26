import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    GameBoard gameBoard = new GameBoard();
    Mines mines = new Mines(gameBoard);

    //                         timer funktion
    // long start = System.currentTimeMillis(); // anropa programmets start
    // long stop = System.currentTimeMillis(); // anropa programmets slut
    //   long totalTime = stop - start;
    //  System.out.println("Time: " + totalTime + " s");

    public Game() {
        System.out.println("Skriv in vilken ruta du vill öppna:");
        makeMove();
    }

    public void makeMove() {
        String choice = sc.nextLine();
        char row = choice.charAt(0);
        int rowNumber = Character.toUpperCase(row) - 65;
        int column = Integer.parseInt(choice.substring(1, 2)) - 1;

        //TODO ************** TEST TEST TEST *****************
        //Placing a mine to test if it writes out game over when opening D4

        char symbol = mines.getSymbol();
        gameBoard.setCell(3, 3, symbol);

        if (mines.isMine(rowNumber, column)) {
            System.out.println("Game over!");
            mines.showAllMines();
            //gameOver();
        }
        System.out.println(column);
        System.out.println(rowNumber);
        //TODO ************** TEST TEST TEST *****************

        checkWin();

        // if valid choice etc ....
        // valid choice?
        // anrop siffra avstånd till mina

        /* int number = 0; // anropet
        gameboard[rowNumber][column] = number;
        if(number == 0){
            // anropa öppna tomma rutor automatiskt
        } */
    }

    public boolean checkWin() {
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == ' ' && !mines.isMine(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
