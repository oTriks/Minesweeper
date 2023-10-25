public class Game {

    GameBoard gameBoard = new GameBoard();
    Mines mines = new Mines(gameBoard);


    //                         timer funktion
    // long start = System.currentTimeMillis(); // anropa programmets start
    // long stop = System.currentTimeMillis(); // anropa programmets slut
    //   long totalTime = stop - start;
    //  System.out.println("Time: " + totalTime + " s");


    public Game() {

        //TODO: ************ TA BORT INNAN PUSH!!!! ****************
        gameBoard.setCell(3, 3, 'Ä');
        if(!mines.isMine(3, 3)){
            System.out.println("hejhjehje");
        }
        mines.showAllMines();
        //TODO: ***********************************

        makeMove("a1", mines);

    }



    public void makeMove(String choice, Mines mine) {

        char row = choice.charAt(0);
        int rowNumber = Character.toUpperCase(row) - 65;
        int column = Integer.parseInt(choice.substring(1, 2)) -1;
        mine.isMine(rowNumber, column);
        checkWin(mine);
         // if valid choice etc ....
        // valid choice?
        // anrop siffra avstånd till mina

      /*   int number = 0; // anropet
        gameboard[rowNumber][column] = number;
        if(number == 0){
            // anropa öppna tomma rutor automatiskt
        } */
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
