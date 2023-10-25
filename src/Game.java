public class Game {

    GameBoard gameBoard = new GameBoard();
    Mines mines = new Mines();

    //                         timer funktion
    // long start = System.currentTimeMillis(); // anropa programmets start

    // long stop = System.currentTimeMillis(); // anropa programmets slut
    //   long totalTime = stop - start;
    //  System.out.println("Time: " + totalTime + " s");


    public Game() {
        gameBoard.updateBoardLayout();

        System.out.println(gameBoard.getBoardLayout());



        makeMove("a1", mines);  // just a test
    }



    public void makeMove(String choice, Mines mine) {

        char rowNumber = choice.charAt(0);
        int row = Character.toUpperCase(rowNumber) - 65;
        int col = Integer.parseInt(choice.substring(1, 2)) -1;
     //    mine.isMine(row, col);
        GameBoard solutionBoard = mines.getSolutionBoard();
        char chosenCell = solutionBoard.getCell(row, col);
        // if (chosenCell == X)  game end
        // else if (chosenCell != "    ")    update gameBoard to show the given number from solutionBoard
        // else  (chosen>Cell)   ==  ( "     ")     call method openAdjacentCells  ( väldigt lik countAdjacentCells)
        // när vi kollar om en granncell också är "tom" kommer vi kalla på samma metod som vi är i med den cellens index

        // checkWin(mine);



    }
    public boolean checkWin(Mines mine) {
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] ==' ' && !mine.isMine(i, j)){
                    return false;
                }
            }
        }
        return true;
    }

}
