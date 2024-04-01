//this class represents an expression with 2 or more numbers
public abstract class CompoundExpression extends Expression {
    private Expression _exp1; //the left expression
    private Expression _exp2; //the right expression

    /**
     * a constructor for higher in hierarchy objects
     *
     * @param exp1 the left expression
     * @param exp2 the right expression
     */
    public CompoundExpression(Expression exp1, Expression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    /*
    getters
     */
    public Expression getExp1() {
        return _exp1;
    }

    public Expression getExp2() {
        return _exp2;
    }

    /**
     * abstract implementation of calculate
     *
     * @return
     */
    @Override
    public abstract double calculate();

    /**
     * abstract implementation of toString
     *
     * @return
     */
    @Override
    public abstract String toString();

    /**
     * abstract implementation of equals
     *
     * @param obj - the object to compare
     * @return
     */

    @Override
    public abstract boolean equals(Object obj);
}
