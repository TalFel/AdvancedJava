import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * a class that represent an oval.
 * x1, y1 - the first point. x2, y2 - the width and height. color - the color of the shape. fill - if the shape is filled or hollow.
 */
public class MyOval extends MyBoundedShape{
    /**
     * a constructor for a MyLine object.
     * @param x1 the X of the first point
     * @param y1 the Y of the first point
     * @param x2 the width of the shape
     * @param y2 the height of the shape
     * @param color the color of the shape
     * @param fill the shape is filled or not
     */
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }

    /**
     * @param obj the obj to compare
     * @return true if both shapes are ovals and both their width and height are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyOval){
            return (getY2()==((MyOval)obj).getY2()) && (getX2()==((MyOval)obj).getX2());
        }
        return false;
    }

    /**
     * a method that draws the oval
     * @param g the graphic context of the canvas.
     */
    @Override
    public void draw(GraphicsContext g){
        if(getFill()) g.fillOval(getX1(), getY1(), getX2(), getY2());
        else g.strokeOval(getX1(), getY1(), getX2(), getY2());
    }
}
