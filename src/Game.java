import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    GameBoard gameBoard = new GameBoard();
    Mines mines = new Mines();
    int moves = 0;
    double start;
    double stop;


    public Game() {
        makeMove();
    }

    // scans users input, starts game timer and calls methods to validate input and make the move on the board
    public void makeMove() {
        moves++;

        mines.showSolutionBoard();   // TODO ska tas bort, bara facit för felsökning

        System.out.println(gameBoard.getBoardLayout());
        System.out.println("Skriv in vilken ruta du vill öppna:");
        String input = sc.nextLine();
        if (moves == 1) {
            start = System.currentTimeMillis();
        }

        int[] result = isCellValidChoice(input);


        if (result != null) {
            int row = result[0];
            int col = result[1];
            openCells(row, col);
            checkGameStatus(row, col);

        } else {
            makeMove();
        }
    }

    // takes cell as input and opens one or multiple cells
    public void openCells(int row, int col) {
        gameBoard.setCell(row, col, mines.getSolutionBoard().getCell(row, col));
        if (mines.getSolutionBoard().getCell(row, col) == Character.forDigit(0, 10)) {
            int[][] neighbors = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1}, {0, 1},
                    {1, -1}, {1, 0}, {1, 1}
            };
            for (int[] neighbor : neighbors) {
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];
                if (newRow >= 0 && newRow < 9 && newCol >= 0 && newCol < 9) {
                    if (mines.solutionBoard.getCell(newRow, newCol) == Character.forDigit(0, 10) && gameBoard.getCell(newRow, newCol) == '?') {
                        openCells(newRow, newCol);
                    } else {
                        gameBoard.setCell(newRow, newCol, mines.getSolutionBoard().getCell(newRow, newCol));

                    }
                }
            }
        }


    }


    public boolean checkWin() { // checkwin method is to check if the player wins the game or not
        char[][] board = gameBoard.getBoard(); //calling current board
        for (int i = 0; i < 9; i++) { // loop going through rows
            for (int j = 0; j < 9; j++) { // loop going through cols
                if (board[i][j] == '?' && !mines.isMine(i, j)) { //if the cell is empty or marked with "?" then return false which means no win


    public boolean checkWin() {
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '?' && !mines.isMine(i, j)) {

                    return false;
                }
            }
        }
        return true; // if the loop has gone through the entire board without returning false then return true which means its a win
    }

    public int[] isCellValidChoice(String input) {
        int row;
        int col;

        try {
            char rowNumber = input.charAt(0);
            row = Character.toUpperCase(rowNumber) - 65;
            col = Integer.parseInt(input.substring(1)) - 1;

            if (row < 0 || row >= 9 || col < 0 || col >= 9) {
                System.out.println("Ogiltig inmatning. Ruta finns inte på brädet.");
                return null;
            }

            if (gameBoard.getCell(row, col) != '?') {
                System.out.println("Du har redan öppnat denna ruta. Skriv in en annan ruta.");
                return null;
            }

        } catch (StringIndexOutOfBoundsException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ogiltig inmatning. Skriv i formatet 'A1', 'B2', etc.");
            return null;
        }
        int[] result = new int[2];
        result[0] = row;
        result[1] = col;

        return result;
    }

    public void checkGameStatus(int row, int col) { // this method is to check if the chosen cell is a mine or if the player win,
        if (mines.isMine(row, col)) { //if the chosen cell is a mine
            mines.showSolutionBoard(); //showing the solution board with mine
            stop = System.currentTimeMillis(); // stop the timerb
            System.out.println("Game over! Du har träffat en mina! ");

            askToPlayAgain(); // ask if play again
        } else if (checkWin()) { // if the player won the game
            mines.showSolutionBoard();
            stop = System.currentTimeMillis();
            System.out.println("Grattis! Du har vunnit spelet! ");

            System.out.println("Tid: " + (stop - start) + " s"); // a message to show the total time taken to finish the game

            System.out.println("Tid: " + (stop - start) / 1000 + " s");
            askToPlayAgain();

        } else if (checkWin()) {
            mines.showSolutionBoard();
            stop = System.currentTimeMillis();
            System.out.println("Grattis! Du har vunnit spelet! ");
            System.out.println("Tid: " + (stop - start) / 1000 + " s");

            askToPlayAgain();

        } else {
            makeMove(); // if the game still going, continue with the next move
        }
    }


    public void askToPlayAgain() {
      
   
          // If the user wants to play again, reset the game by creating new instances of GameBoard and Mines
          System.out.print("Vill du spela igen? (ja/nej): ");
        String playAgain = sc.nextLine();

        if (playAgain.trim().equalsIgnoreCase("ja")) {  
            moves = 0;
            gameBoard = new GameBoard();
            mines = new Mines();
            System.out.println("Spelet har återställts. Lycka till!");
            makeMove();
        } else if (playAgain.trim().equalsIgnoreCase("nej")) {
            System.out.println("Tack för att du spelade!");
            System.exit(0);
        } else {
            System.out.println("Ogiltig inmatning. Vänligen svara med ja/nej.");
            askToPlayAgain();

        }
    }
}


