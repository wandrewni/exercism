/**
 * Created by anicholson on 5/12/17.
 */
public class Scrabble {
    private int score;

    public Scrabble(String scrabbleInput) {
        if (scrabbleInput == null || scrabbleInput.trim().equals(""))
            score = 0;
        else
            for (int i = 0; i < scrabbleInput.trim().length(); i++) {
                score += scoreLetter(scrabbleInput.toLowerCase().charAt(i));
            }
    }

    private int scoreLetter(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'l':
            case 'n':
            case 'r':
            case 's':
            case 't':
                return 1;
            case 'b':
            case 'c':
            case 'm':
            case 'p':
                return 3;
            case 'f':
            case 'h':
            case 'v':
            case 'w':
            case 'y':
                return 4;
            case 'k':
                return 5;
            case 'j':
            case 'x':
                return 8;
            case 'q':
            case 'z':
                return 10;
        }
        return 0;
    }

    public int getScore() {
        return score;
    }
}
