import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * a class that represent a line.
 * x1, y1 - the first point. x2, y2 - the second point. color - the color of the shape.
 *
 */
public class MyLine extends MyShape{
    /**
     * a constructor for a MyLine object.
     * @param x1 the X of the first point
     * @param y1 the Y of the first point
     * @param x2 the X of the second point/ the width of the shape
     * @param y2 the Y of the second point/ the height of the shape
     * @param color the color of the shape
     */
    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    /**
     * overriding equals method
     * @param obj - the object to compare
     * @return true if the length of the lines is the same and false else.
     */

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyLine){
            return ((MyLine)obj).length() == this.length();
        }
        return false;
    }

    /**
     * a method that returns the length of a line
     * @return the length of the line
     */
    public double length(){
        return Math.sqrt(Math.pow(getX2()- getX1(), 2) + Math.pow(getY2()- getY1(), 2));
    }

    /**
     * a method that draws the line
     * @param g the graphic context of the canvas
     */
    @Override
    public void draw(GraphicsContext g){
        g.strokeLine(getX1(), getY1(), getX2(), getY2());
    }
}
