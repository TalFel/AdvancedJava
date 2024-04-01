//an abstract class that represents an expression
public abstract class Expression {
    /**
     * an abstract implementation of calculate, it will be implemented in every inherited class.
     * @return
     */
    public abstract double calculate();

    /**
     * an abstract implementation of equals, it will be implemented in every inherited class.
     * @param obj - the object to compare
     * @return
     */
    @Override
    public abstract boolean equals(Object obj);
}
