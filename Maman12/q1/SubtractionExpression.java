public class SubtractionExpression extends CompoundExpression{
    /**
     * a constructor for SubtractionExpression
     * @param exp1 - the left expression
     * @param exp2 - the right expression
     */
    public SubtractionExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }
    /**
     * the implementation of toString method in SubtractionExpression
     * @return the expression to string
     */
    @Override
    public String toString() {
        String str = getExp1().toString() + " - ";
        if(getExp2() instanceof AtomicExpression){
            str += getExp2().toString();
        }
        else{
            str +=  "(" + getExp2().toString() + ")";
        }
        return  str;
    }
    /**
     * the implementation of equals method in SubtractionExpression
     * @param obj - the object to compare
     * @return true if the 2 Expression objects equals and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return calculate() == ((Expression)obj).calculate();
    }
    /**
     * the implementation of calculate method in SubtractionExpression
     * @return the Expression calculated
     */
    @Override
    public double calculate(){
        String str1 = getExp1().toString();
        String str2 = getExp2().toString();
        return Calc.calcExp(str1) - Calc.calcExp(str2);
    }
}