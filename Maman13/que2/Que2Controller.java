import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
//the UI of the game.
public class Que2Controller {
    Game game;
    @FXML
    private Label score;
    @FXML
    private Label question;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @FXML
    private RadioButton r4;
    @FXML
    private Button OK;
    @FXML
    private Button stop;
    @FXML
    private Button quit;
    //when the application initializes.
    @FXML
    public void initialize(){
        game = new Game();
        newGame(null);
    }
    //generates a new game.
    @FXML
    public void newGame(ActionEvent actionEvent){
        game.newGame();
        showGame();
        newQuestion();
    }
    //quit game button was pressed. closes the application.
    @FXML
    public void quitGame(ActionEvent actionEvent){
        Platform.exit();
        System.exit(0);
    }
    //a guess was made (a button was pressed)
    @FXML
    public void onGuess(ActionEvent event){
        RadioButton rb = (RadioButton)event.getTarget();
        if(game.isCorrect(rb.getText())){
            correct();
        }
        else{
            incorrect();
        }
        rb.setSelected(false);
    }
    //ok was pressed when we show the guess
    @FXML
    public void OKPressed(ActionEvent event){
        showGame();
        newQuestion();
    }
    //a correct guess was made
    public void correct(){
        hideGame();
        question.setText("Correct!");
        question.setVisible(true);
        OK.setVisible(true);
    }
    //an incorrect guess was made
    public void incorrect(){
        hideGame();
        question.setText("Incorrect ): the answer was: " + game.correctAnswer());
        question.setVisible(true);
        OK.setVisible(true);
    }
    //shows a new question or ends the game in case there a no more questions
    public void newQuestion(){
        if(game.areThereMoreQuestions()){
            String[] que = game.newQuestion();
            score.setText(game.getScore()+"");
            question.setText(que[0]);
            r1.setText(que[1]);
            r2.setText(que[2]);
            r3.setText(que[3]);
            r4.setText(que[4]);
        }
        else{
            endGame();
            score.setVisible(true);
            score.setText("There are no more questions.");
        }
    }
    //shows the end of the game scene.
    public void endGame(){
        hideGame();
        stop.setVisible(false);
        question.setVisible(true);
        question.setText("you scored: " + game.getScore() + " out of " + game.NO_OF_QUESTIONS*game.POINTS_CORRECT);
    }
    //hides the game
    public void hideGame(){
        score.setVisible(false);
        r1.setVisible(false);
        r2.setVisible(false);
        r3.setVisible(false);
        r4.setVisible(false);
        question.setVisible(false);
    }
    //shows the game
    public void showGame(){
        score.setVisible(true);
        r1.setVisible(true);
        r2.setVisible(true);
        r3.setVisible(true);
        r4.setVisible(true);
        stop.setVisible(true);
        question.setVisible(true);
        OK.setVisible(false);
    }
}