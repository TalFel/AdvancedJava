import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * abstract class for a shape.
 * contains 4 int variables of the points and one Color object that represent the color of the shape.
 */
public abstract class MyShape implements Cloneable{
    private int _x1;
    private int _y1;
    private int _x2;
    private int _y2;
    private Color _color;

    /**
     * a constructor for a higher in hierarchy object.
     * @param x1 the X of the first point
     * @param y1 the Y of the first point
     * @param x2 the X of the second point/ the width of the shape
     * @param y2 the Y of the second point/ the height of the shape
     * @param color the color of the shape
     */
    public MyShape(int x1, int y1, int x2, int y2, Color color){
        _x1 = x1;
        _y1 = y1;
        _x2 = x2;
        _y2 = y2;
        _color = color;
    }

    /**
     * clone method for a higher in hierarchy object.
     * @return the copied object
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyShape obj = (MyShape) super.clone();
        obj.setX1(_x1);
        obj.setX2(_x2);
        obj.setY1(_y1);
        obj.setY2(_y2);
        obj.set_color(_color);
        return obj;
    }

    /**
     * abstract void draw that is implemented in every class that inherits MyShape
     * @param g the graphic context of the canvas
     */
    public abstract void draw(GraphicsContext g);

    /**
     * overriding abstract equals method. implemented in every class that inherits MyShape
     * @param obj - the object to compare
     * @return
     */
    @Override
    public abstract boolean equals(Object obj);
    /*
    getters for MyShape attributes
     */
    public int getX1(){
        return _x1;
    }
    public int getX2(){
        return _x2;
    }
    public int getY1(){
        return _y1;
    }
    public int getY2(){
        return _y2;
    }
    /*
    setters for MyShape attributes
    */
    public void setX1(int a){
        _x1 = a;
    }
    public void setX2(int a){
        _x2 = a;
    }
    public void setY1(int a){
        _y1 = a;
    }
    public void setY2(int a){
        _y2 = a;
    }
    public void set_color(Color color){
        _color = color;
    }


}
