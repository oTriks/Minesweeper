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
        makeMove();

    }

    public void makeMove() {
        mines.showSolutionBoard();   // ska tas bort, bara facit för felsökning
        System.out.println(gameBoard.getBoardLayout());
        System.out.println("Skriv in vilken ruta du vill öppna:");
        String choice = sc.nextLine();
        char rowNumber = choice.charAt(0);
        int row = Character.toUpperCase(rowNumber) - 65;

        int col = Integer.parseInt(choice.substring(1, 2)) - 1;

        if (mines.isMine(row, col)) {
            System.out.println("Game over!");
            mines.showSolutionBoard();
        } else {
            openCells(row, col);
            checkWin();
            makeMove();
        }

    }

    public void openCells(int row, int col) {
        gameBoard.setCell(row, col, mines.getSolutionBoard().getCell(row, col));
        if (mines.getSolutionBoard().getCell(row, col) == Character.forDigit(0, 10)){
            int[][] neighbors = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},          {0, 1},
                    {1, -1}, {1, 0}, {1, 1}
            };
            for (int[] neighbor : neighbors) {
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];
                if (newRow >= 0 && newRow < 9 && newCol >= 0 && newCol < 9) {
                    if (mines.solutionBoard.getCell(newRow, newCol) == Character.forDigit(0, 10) && gameBoard.getCell(newRow, newCol) == '?') {
                        openCells(newRow, newCol);
                    }else{
                        gameBoard.setCell(newRow, newCol, mines.getSolutionBoard().getCell(newRow, newCol));

                    }
                }
            }
        }


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
