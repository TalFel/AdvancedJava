import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/*the class that deals with all the action behind the game:
reading the word, generating random words and dealing with the guess.*/
public class Game {
    public final int NO_OF_LETTERS = 26;//no of letters in the abc
    public final int ASCII_MARGIN = 97;//the ascii margin between 0 and the start of the abc in ascii
    public final int NO_OF_WORDS = 25;//number of words in the bank(Words.txt)
    public final int MAX_GUESSES = 6;//maximum number of wrong guesses
    private String _word;//the current word
    private String[] _bank;//bank of words from the file
    private boolean[] _buttons;//array that holds the state of the buttons. if a button was pressed then the value of his place will be false, else it will be true.

    /**
     * a constructor for Game object.
     */
    public Game(){
        _buttons = new boolean[NO_OF_LETTERS];
        for(int i = 0; i < NO_OF_LETTERS; i++){
            _buttons[i] = true;
        }

        _bank = new String[NO_OF_WORDS];
        try {
            Scanner in = new Scanner(new File("Words.txt"));
            int i = 0;
            while(in.hasNext()){
                _bank[i] = in.nextLine();
                i++;
            }
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("Error, could not read the file");
        }
        Random rnd = new Random();
        int ind = rnd.nextInt(NO_OF_WORDS+1);
        _word = _bank[ind];
        _bank[ind] = "";
    }

    /**
     * @return the current word
     */
    public String getWord(){
        return _word;
    }

    /**
     * a function that calculates the number of remaining words in the bank
     * @return the number of remaining words in the bank
     */
    public int getSize(){
        int count = 0;
        for(int i = 0; i < NO_OF_LETTERS; i++){
            if(_buttons[i]) count++;
        }
        return count;
    }

    /**
     * @return the current state of the word (with _ where the letter is missing)
     */
    public String getCurr(){
        String temp = _word;
        for(int i = 0; i < _word.length(); i++){
            if(temp.charAt(i) != '_'){
                if(_buttons[temp.charAt(i) - ASCII_MARGIN]){
                    temp = temp.replace(temp.charAt(i), '_');
                }
            }
        }
        return temp;
    }

    /**
     * when a guess is made we need to update the button state.
     * @param i the letter to guess minus the ascii margin.
     */
    public void guess(int i){
        _buttons[i] = false;
    }

    /**
     * @param ch the letter to check.
     * @return true if the word contains ch and else otherwise.
     */
    public boolean contains(char ch){
        return _word.indexOf(ch) != -1;
    }

    /**
     * @return true if the player has guess all of the correct letters.
     */
    public boolean checkWin(){
        for(int i = 0; i < _word.length(); i++){
            if(getCurr().charAt(i) == '_') return false;
        }
        return true;
    }

    /**
     * @return true if the player lost.
     */
    public boolean checkLost(){
        return getGuesses()>MAX_GUESSES - 1;
    }

    /**
     * @return the number of guesses that the player have made.
     */
    public int getGuesses(){
        int count = 0;
        for(int i = 0; i < NO_OF_LETTERS; i++){
            if(_buttons[i] == false && _word.indexOf((char)(i+ASCII_MARGIN))==-1) count++;
        }
        return count;
    }

    /**
     * generates a new word and restarts the buttons.
     */
    public void restart(){
        //new word
        Random rnd = new Random();
        int i = rnd.nextInt(NO_OF_WORDS);
        while(_bank[i].equals("")){
            i = rnd.nextInt(NO_OF_WORDS);
        }
        _word = _bank[i];
        //reset buttons
        for(i = 0; i < NO_OF_LETTERS; i++){
            _buttons[i] = true;
        }

    }
}