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
        char rowNumber = choice.charAt(0);
        int row = Character.toUpperCase(rowNumber) - 65;
        int col = Integer.parseInt(choice.substring(1, 2)) -1;


   
        //TODO ************** TEST TEST TEST *****************
        //Placing a mine to test if it writes out game over when opening D4

        char symbol = mines.getSymbol();
        gameBoard.setCell(3, 3, symbol);

        if (mines.isMine(row, col)) {
            System.out.println("Game over!");
            mines.showAllMines();
            //gameOver();
        }
        System.out.println(col);
        System.out.println(row);
        //TODO ************** TEST TEST TEST *****************
        GameBoard solutionBoard = mines.getSolutionBoard();
        char chosenCell = solutionBoard.getCell(row, col);
         // if (chosenCell == X)  game end
        // else if (chosenCell != "    ")    update gameBoard to show the given number from solutionBoard
        // else  (chosen>Cell)   ==  ( "     ")     call method openAdjacentCells  ( väldigt lik countAdjacentCells)
        // när vi kollar om en granncell också är "tom" kommer vi kalla på samma metod som vi är i med den cellens index
      
        checkWin();




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
