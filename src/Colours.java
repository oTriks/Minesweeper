import java.util.HashMap;

public class Colours {
    public static String colour0 = "\033[38;5;234m"; //code for almost-invisible gray/black.
    public static String colour1 = "\033[0;34m"; //code for blue colour.
    public static String colour2 = "\033[0;32m"; //code for green colour.
    public static String colour3 = "\033[38;5;88m"; //code for dark red colour.
    public static String colour4 = "\033[0;35m"; //code for purple colour.
    public static String colour5 = "\033[38;5;125m"; //code for maroon colour.
    public static String colour6 = "\033[38;5;121m"; //code for turquoise colour.
    public static String colour7 = "\033[38;5;16m"; //code for black colour.
    public static String colour8 = "\033[0;37m"; //code for gray colour.
    public static String colourQuestionMark = "\033[38;5;95m"; //code for the question marks colour.
    public static String colourMine = "\033[38;5;196m"; //code for the mines' colour. Sharp red.
    public static String colourPickedMine = "\033[48;5;52m"; //code for the background colour of picked mine.
    public static String colourBoard = "\033[38;5;226m"; //code for the board´s row and col definers. Bright yellow.
    public static String colourReset = "\033[0m"; //code to reset previous color to original white.

    public static String colourNumber(int number) {
        return switch (number) {
            case 0 -> colour0 + 0 + colourReset; //almost-invisible-gray/black 0
            case 1 -> colour1 + 1 + colourReset; //blue 1
            case 2 -> colour2 + 2 + colourReset; //green 2
            case 3 -> colour3 + 3 + colourReset; //dark red 3
            case 4 -> colour4 + 4 + colourReset; //purple 4
            case 5 -> colour5 + 5 + colourReset; //maroon 5
            case 6 -> colour6 + 6 + colourReset; //turquoise 6
            case 7 -> colour7 + 7 + colourReset; //black 7
            case 8 -> colour8 + 8 + colourReset; //gray 8
            case 9 -> colourQuestionMark + '?' + colourReset; //white ?
            case 10 -> colourMine + '✸' + colourReset; //sharp red mine
            case 11 -> colourBoard; //yellow for board row/col
            default -> String.valueOf(number); //converts integers/numbers to strings.
        };
    }

    /* Converts the chars that are put on the board to the corresponding number as a string
       so that their colour can be printed out - because we can't convert colours from strings.
     */
    public static HashMap<Character, String> colourMap = new HashMap<>();
    static {
        colourMap.put('0', colourNumber(0));
        colourMap.put('1', colourNumber(1));
        colourMap.put('2', colourNumber(2));
        colourMap.put('3', colourNumber(3));
        colourMap.put('4', colourNumber(4));
        colourMap.put('5', colourNumber(5));
        colourMap.put('6', colourNumber(6));
        colourMap.put('7', colourNumber(7));
        colourMap.put('8', colourNumber(8));
        colourMap.put('?', colourNumber(9));
        colourMap.put('✸', colourNumber(10));
    }
}