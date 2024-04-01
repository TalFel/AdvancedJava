//a class that represents an addition expression
public class AdditionExpression extends CompoundExpression{
    /**
     * a constructor for AdditionExpression
     * @param exp1 - the left expression
     * @param exp2 - the right expression
     */
    public AdditionExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    /**
     * the implementation of toString method in AdditionExpression
     * @return the expression to string
     */
    @Override
    public String toString() {
        return getExp1().toString() + " + " + getExp2().toString();
    }

    /**
     * the implementation of equals method in AdditionExpression
     * @param obj - the object to compare
     * @return true if the 2 Expression objects equals and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return calculate() == ((Expression)obj).calculate();
    }

    /**
     * the implementation of calculate method in AdditionExpression
     * @return the Expression calculated
     */
    @Override
    public double calculate(){
        String str1 = getExp1().toString();
        String str2 = getExp2().toString();
        return Calc.calcExp(str1) + Calc.calcExp(str2);
    }
}
