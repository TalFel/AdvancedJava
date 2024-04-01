import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyBoundedShape extends MyShape{
    private boolean _fill; //true = the shape is filled, false = the shape is hollow

    /**
     * A constructor for a MyBoundedShape object.
     * @param x1 - the X parameter of the top left point
     * @param y1  - the Y parameter of the top left point
     * @param x2  - the width of the shape
     * @param y2 - the height of the shape
     * @param color - the color of the shape
     * @param fill - if the shape is filled or not
     */
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color);
        _fill = fill;
    }

    /**
     * Clones a MyBoundedShape object.
     * @return a copy of the object.
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyBoundedShape obj = (MyBoundedShape)super.clone();
        (obj).setFill(_fill);
        return obj;
    }

    /**
     *
     * @return if the shape is filled or hollow
     */
    public boolean getFill(){
        return _fill;
    }

    /**
     * sets the fill parameter
     * @param fill true - if the shape needs to be filled, false otherwise.
     */
    public void setFill(boolean fill){
        _fill = fill;
    }

    /**
     * abstract overriding method of draw.
     * @param g the graphic context of the canvas.
     */
    @Override
    public abstract void draw(GraphicsContext g);

    /**
     * abstract overriding method of equals.
     * @param obj the obj to compare
     * @return
     */
    @Override
    public abstract boolean equals(Object obj);
}
