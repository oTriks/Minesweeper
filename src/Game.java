public class Game {



    // long start = System.currentTimeMillis(); // anropa programmets start
    // long stop = System.currentTimeMillis(); // anropa programmets slut
    //   long totalTime = stop - start;
    //  System.out.println("Time: " + totalTime + " s");



    public void makeMove(String choice){

        char row = choice.charAt(0);
        int column = Integer.parseInt(choice.substring(1, 2)) -1;
        int rowNumber = Character.toUpperCase(row) - 65;
        this.board[rowNumber][column];
        // kontroll valdes en mina
        // valid choice?
        // anrop siffra avstånd till mina
        int number = 0; // anropet
        this.board[rowNumber][column] = number;
        if(number == 0){
            // anropa öppna tomma rutor automatiskt
        }
    }
}
