import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;
//the controller class of the fxml file.
public class Controller {
    final int BOUND = 200;
    private GraphicsContext g;
    @FXML
    private Canvas can;
    @FXML
    private Button startBtn;
    @FXML
    /**
     * the "main" program - draws the required shapes.
     */
    protected void OnStartBtnAction() throws CloneNotSupportedException {
        can.setWidth(BOUND*2);
        can.setHeight(BOUND*2);

        startBtn.setVisible(false);
        can.setVisible(true);
        g = can.getGraphicsContext2D();
        g.setStroke(Color.RED);
        //creating a new arraylist of shapes
        ArrayList<MyShape> a1 = new ArrayList<>();
        a1.add(new MyLine(rand(), rand(), rand(), rand(), Color.RED));
        a1.add(new MyLine(rand(), rand(), rand(), rand(), Color.RED));
        a1.add(new MyOval(rand(), rand(), rand(), rand(), Color.RED, true));
        a1.add(new MyOval(rand(), rand(), rand(), rand(), Color.RED, true));
        a1.add(new MyRectangle(rand(), rand(), rand(), rand(), Color.RED, true));
        a1.add(new MyRectangle(rand(), rand(), rand(), rand(), Color.RED, true));
        //copying the arraylist as required in the question
        ArrayList<MyShape> a2 = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            MyShape shape = (MyShape)(a1.get(i)).clone();
            shape.setX1(shape.getX1() + 10);
            shape.setY1(shape.getY1() + 10);
            if(shape instanceof MyBoundedShape) ((MyBoundedShape) shape).setFill(false);
            a2.add(shape);
        }
        //draws the first arraylist in red.
        g.setStroke(Color.RED);
        g.setFill(Color.RED);
        drawShapes(a1);
        //draws the first arraylist in green
        g.setStroke(Color.GREEN);
        g.setFill(Color.GREEN);
        drawShapes(a2);
    }

    /**
     * this function gets an arraylist and calls the draw method of every one of them.
     * @param a - the array list of shapes that need to be drawn
     */
    public void drawShapes(ArrayList<MyShape> a){
        for(int i = 0; i < 6; i++){
            (a.get(i)).draw(g);
        }
    }

    /**
     * returns a random number between 0 and 200.
     * @return a random number between 0 and 200.
     */
    public int rand(){
        Random rnd = new Random();
        return rnd.nextInt(BOUND+1);
    }
}