import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
//the helper class of the game. deals with all the actions behind the game.
public class Game {
    public final int NO_OF_QUESTIONS = 15;//number of questions in the bank
    public final int NO_OF_ANSWERS = 4;//number of answers for each question
    public final int POINTS_CORRECT = 10;//points for correct answer
    public final int POINTS_INCORRECT = -5;//points for incorrect answer
    private int _score;//the current score
    private String currCorrect;//the correct answer for the current question
    private String[][] _questions;//the 2d array of questions.

    /**
     * a constructor for a Game object.
     */
    public Game(){
        currCorrect ="";
        _score = 0;
        _questions=new String[NO_OF_QUESTIONS][NO_OF_ANSWERS + 1];
    }

    /**
     * a function that fills the array with the questions from the file and starts all the variables.
     */
    public void newGame(){
        currCorrect ="";
        _score = 0;
        try {
            Scanner input = new Scanner(new File("Data.txt"));
            for(int i = 0; i < NO_OF_QUESTIONS; i++){
                for(int j = 0; j < NO_OF_ANSWERS + 1; j++){
                    _questions[i][j] = input.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, couldn't find that file");
        }
    }

    /**
     * @return a new question from the array.
     */
    public String[] newQuestion(){
        Random rnd = new Random();
        int ind = rnd.nextInt(NO_OF_QUESTIONS);
        while(_questions[ind][0].equals("")){
            ind = rnd.nextInt(NO_OF_QUESTIONS);
        }
        currCorrect = _questions[ind][1];
        return rand(ind);
    }

    /**
     * @param ind the index of the question and answers in the array.
     * @return the question with the answers in a random order.
     */
    public String[] rand(int ind){
        String[] question = new String[5];
        question[0] = _questions[ind][0];
        _questions[ind][0] = "";
        int i = 1;
        Random rnd = new Random();
        int r = rnd.nextInt(NO_OF_ANSWERS);
        while (i < NO_OF_ANSWERS+1){
            if(!_questions[ind][r+1].equals("")){
                question[i] = _questions[ind][r+1];
                _questions[ind][r+1] = "";
                i++;
            }
            r = rnd.nextInt(NO_OF_ANSWERS);
        }
        return question;
    }

    /**
     * @return true if there are more questions or else if there aren't.
     */
    public boolean areThereMoreQuestions(){
        for(int i = 0; i < NO_OF_QUESTIONS; i++){
            if(!_questions[i][0].equals("")) return true;
        }
        return false;
    }

    /**
     * @param guess the guess that the player have made.
     * @return true if the guess is the correct answer.
     */
    public boolean isCorrect(String guess){

        if(currCorrect.equals(guess)){
            _score+=POINTS_CORRECT;
            return true;
        }
        else{
            _score+=POINTS_INCORRECT;
            return false;
        }
    }

    /**
     * @return the correct answer.
     */
    public String correctAnswer(){
        return currCorrect;
    }

    /**
     * @return the current score.
     */
    public int getScore(){
        return _score;
    }

}
