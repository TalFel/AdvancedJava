//a class that represents a number - a part of the expression
public class AtomicExpression extends Expression{
    private double _num; //the number

    /**
     * constructor for Atomic expression
     * @param num - the number
     */
    public AtomicExpression(double num){
        _num = num;
    }

    /**
     * equals method for AtomicExpression
     * @param obj - the object to compare
     * @return true if both objects are AtomicExpression instances and their numbers are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AtomicExpression){
            return (((AtomicExpression)obj).toString()).equals(this.toString());
        }
        else if(obj instanceof AdditionExpression){
            return ((AdditionExpression)obj).equals(this);
        }
        return ((SubtractionExpression)obj).equals(this);
    }

    /**
     * implementation of calculate
     * @return the number of the AtomicExpression
     */
    @Override
    public double calculate(){
        return _num;
    }

    /**
     * implementation of toString
     * @return the number in a string
     */
    @Override
    public String toString() {
        return _num+"";
    }
}
