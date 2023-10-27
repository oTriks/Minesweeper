public class Colours {
    public static String colour1 = "\033[0;34m"; //code for blue colour.
    public static String colour2 = "\033[0;32m"; //code for green colour.
    public static String colour3 = "\033[38;5;88m"; //code for dark red colour.
    public static String colour4 = "\033[0;35m"; //code for purple colour.
    public static String colour5 = "\033[38;5;125m"; //code for maroon colour.
    public static String colour6 = "\033[38;5;121m"; //code for turquoise colour.
    public static String colour7 = "\033[38;5;16m"; //code for black colour.
    public static String colour8 = "\033[0;37m"; //code for gray colour.
    public static String colourMine = "\033[38;5;196m"; //code for the mines' colour. Sharp red.
    public static String colourPickedMine = "\033[48;5;52m"; //code for the background colour of picked mine.
    public static String colourBoard = "\033[38;5;226m"; //code for the board´s row and col definers. Bright yellow.
    public static String colourReset = "\033[0m"; //code to reset previous color to original white.

    public static String colourNumber(int number) {
        return switch (number) {
            case 1 -> colour1 + 1 + colourReset; //blue 1
            case 2 -> colour2 + 2 + colourReset; //green 2
            case 3 -> colour3 + 3 + colourReset; //dark red 3
            case 4 -> colour4 + 4 + colourReset; //purple 4
            case 5 -> colour5 + 5 + colourReset; //maroon 5
            case 6 -> colour6 + 6 + colourReset; //turquoise 6
            case 7 -> colour7 + 7 + colourReset; //black 7
            case 8 -> colour8 + 8 + colourReset; //gray 8
            case 9 -> colourMine + '☢' + colourReset; //sharp red mine
            case 10 -> colourMine + colourPickedMine + '☢' + colourReset; //sharp red mine with red background
            case 11 -> colourBoard; // yellow for board row/col
            default -> String.valueOf(number); //
        };
    }
}