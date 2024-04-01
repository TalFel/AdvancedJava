import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * this class is responsible for the UI.
 */
public class Q2Controller {
    private Game game = new Game(10); //the Game object that runs the game.
    private final int size = 50; //size in pixels of each square.
    private GraphicsContext g; //the graphicsContext of the canvas.
    @FXML
    private Canvas canv;
    @FXML
    private Button Start;
    @FXML
    private Button nxt;
    @FXML
    private Label lbl;
    @FXML
    private VBox vb;
    @FXML
    /**
     * this func is activated whenever Next Gen button is pressed.
     * it clears the board and calls loadBoard() to load the updated board.
     * it also updates the label to show current gen number.
     */
    protected void nextGen() {
        g.clearRect(0, 0, size*10, size*10);
        game.nextGen();
        loadBoard();
        lbl.setText("   Gen number: " + game.getGen());
    }
    @FXML
    /**
     * this func starts the game.
     * it sets the start button to be hidden and shows the NextGen and GenNo label.
     * it creates a new GraphicsContext - g, and loads the board.
     */
    protected void StartGame() {
        Start.setVisible(false);
        nxt.setVisible(true);
        lbl.setVisible(true);
        g = canv.getGraphicsContext2D();
        loadBoard();
        lbl.setText("   Gen number: " + game.getGen());
    }

    /**
     * this func loads the matrix on the screen after every NextGen press.
     */
    public void loadBoard(){
        System.out.println(game.getGen());
        int[][] mat = game.getMatrix();
        for(int i = 0; i < game.getSize(); i++) {
            for(int j = 0; j < game.getSize(); j++) {
                if(mat[i][j] == 1) g.setFill(Color.BLACK);
                else g.setFill(Color.WHITE);
                g.fillRect(i*size, j*size, size, size);
            }
        }
    }
}