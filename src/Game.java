import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    GameBoard gameBoard = new GameBoard();
    Mines mines = new Mines();

    //                         timer funktion
    // long start = System.currentTimeMillis(); // anropa programmets start

    // long stop = System.currentTimeMillis(); // anropa programmets slut
    //   long totalTime = stop - start;
    //  System.out.println("Time: " + totalTime + " s");

    public Game() {
        System.out.println(gameBoard.getBoardLayout());
        mines.showSolutionBoard();
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
            mines.showSolutionBoard();
            //gameOver();
        }
        System.out.println(gameBoard.getBoardLayout());
        System.out.println(col);
        System.out.println(row);
        //TODO ************** TEST TEST TEST *****************
        //GameBoard solutionBoard = mines.getSolutionBoard();
        //char chosenCell = solutionBoard.getCell(row, col);
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

    public void isValidChoice(String input) {
        try {
                char rowNumber = input.charAt(0);
                int row = Character.toUpperCase(rowNumber) - 65;
                int col = Integer.parseInt(input.substring(1, 2)) -1;

                //If it's not a '?'

        } catch (StringIndexOutOfBoundsException | NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid input. Please enter a valid move in the format 'A1', 'B2', etc.");
        }
        //Is the choice within the board? (row and column indices between 0 and 8?)
        //Has the selected cell already been opened? (if it's not a '?')
        //Is the input choice in the correct format? (is input letter followed by a number?)
    }

}
