import java.util.Random;

/**
 * Class Game is the logic behind the BullPgiaa game.
 * All the checking of guesses, creating the computer number and maintenance of the history happens here.
 */
public class Game {
    private String _compNo;//the computer generated number.
    private String _history;//a list that contains the history of guesses
    private int _guesses; //the number of guesses.
    private final int NOLENGTH = 4; // the length of the numbers.
    //creates a game object.
    public Game() {
        _compNo = rand();
        _guesses = 0;
        _history = "";
    }

    /**
     * returns the list of guesses(history of the game).
     * @return the list of guesses.
     */
    public String getHistory() {
        return _history;
    }

    /**
     * adds a guess to the history.
     * @param guess the guess to add.
     */
    public void addGuess(String guess){
        _history += guess + "\n";
    }

    /**
     * checks if a number is legal.
     * @param no the number to check
     * @return true if the number is legal or false otherwise.
     */
    public boolean isLegal(String no) {
        if (no.length() != NOLENGTH) return false;
        for(int i = 0; i < NOLENGTH; i++) {
            for(int j = i + 1; j < NOLENGTH; j++) {
                if(no.charAt(j) == no.charAt(i)) return false;
            }
        }
        return true;
    }

    /**
     * the function randomize a legal, computer number.
     * @return the computer number
     */
    public String rand() {
        Random rnd = new Random();
        String tempNum = String.format("%04d", rnd.nextInt(10000));
        while(!isLegal(tempNum)) {
            tempNum = String.format("%04d", rnd.nextInt(10000));
        }
        return tempNum;
    }

    /**
     * checks if the player won.
     * @param no the player guess.
     * @return true if the guess is correct and false otherwise.
     */
    public boolean isWin(String no) {
        return no.equals(_compNo);
    }

    /**
     * checks the player's guess and returns how many Bulls and Pgiot.
     * @param no the player's guess.
     * @return how many Bulls (res[0]) and Pgiot(res[1])
     */
    public int[] res(String no) {
        int[] tempRes = new int[]{0, 0};
        for(int i = 0; i < NOLENGTH; i++) {
            for(int j =0; j < NOLENGTH; j++) {
                if(no.charAt(i) == _compNo.charAt(j)) {
                    if(i == j) tempRes[0]++;
                    else tempRes[1]++;
                    break;
                }
            }
        }
        return tempRes;
    }
}