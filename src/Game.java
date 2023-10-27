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

        //TODO ************** TEST TEST TEST *****************
        //Placing a mine to test if it writes out game over when opening D4

        char symbol = mines.getSymbol();
        gameBoard.setCell(3, 3, symbol);

        if (mines.isMine(row, col)) {
            System.out.println("Game over!");
            mines.showSolutionBoard();
            //gameOver();
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

}
