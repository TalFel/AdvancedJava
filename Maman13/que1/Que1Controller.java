import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

//the UI of the application.
public class Que1Controller {
    private Game game;
    final int COLS = 13 ;
    final int ROWS = 2 ;
    final int GRIDL = 30;
    @FXML
    private Label lbl;
    @FXML
    private GridPane grid;
    @FXML
    private ImageView img;
    @FXML
    private Button yes;
    @FXML
    private Button no;
    @FXML
    private Label his;
    //when the game opens we create all the buttons and show the game.
    @FXML
    public void initialize(){
        game = new Game();
        for (int i = 0; i < COLS; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / COLS);
            grid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < ROWS; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / ROWS);
            grid.getRowConstraints().add(rowConst);
        }
        showBoard();
    }
    //when a button is pressed we check which letter is written on it and update the status of the game accordingly.
    @FXML
    public void handleButton(ActionEvent e){
        Button btn = (Button)e.getSource();
        if(!btn.getText().equals(" ")){
            game.guess((int)(btn.getText().charAt(0)) - game.ASCII_MARGIN);
            if(!game.contains(btn.getText().charAt(0))){
                his.setText(his.getText()+ " " + btn.getText().charAt(0));
            }
            btn.setText(" ");
            lbl.setText(game.getCurr());

            try {
                img.setImage(new Image(new FileInputStream("Pictures/p" + game.getGuesses()  + ".png")));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            if(game.checkWin()){
                lbl.setText("YOU WON (: DO YOU WANT TO PLAY A NEW GAME?\nThe word was - " + game.getWord() + ".\n ");
                reset();
            }
            if(game.checkLost()){
                lbl.setText("YOU LOST ): DO YOU WANT TO PLAY A NEW GAME?\nThe word was - " + game.getWord() + ".\n ");
                reset();
            }
        }
    }

    //restarts the game object and the application.
    @FXML
    public void PlayNewGame(ActionEvent e){
        game.restart();
        grid.setVisible(true);
        img.setVisible(true);
        his.setVisible(true);
        yes.setVisible(false);
        no.setVisible(false);
        for(int i = 0; i < game.getSize(); i++){
            grid.getChildren().clear();
        }
        showBoard();
    }

    //closes the application
    @FXML
    public void CloseApp(ActionEvent e){
        Platform.exit();
        System.exit(0);
    }
    //restarts the game
    public void reset(){
        //hide buttons and Image
        grid.setVisible(false);
        img.setVisible(false);
        his.setVisible(false);
        //show new buttons
        yes.setVisible(true);
        no.setVisible(true);
    }
    //shows the game state at the beginning of a new game. creates new button for each letter and links it to the handleButton function.
    public void showBoard(){
        lbl.setText(game.getCurr());
        his.setText("");
        try {
            img.setImage(new Image(new FileInputStream("Pictures/p0.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < game.getSize(); i++){
            Button btn = new Button((char) (i+game.ASCII_MARGIN) +"");
            btn.setPrefSize(GRIDL, GRIDL);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    handleButton(e);
                }
            });
            grid.add(btn, i%(game.NO_OF_LETTERS/2), i/(game.NO_OF_LETTERS/2));
        }
    }
}