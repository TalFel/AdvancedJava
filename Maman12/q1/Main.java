import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
//the main program
public class Main {
    static final int OPERATORS_BOUND = 7; //the maximum number of operators in the expression
    static final int NO_MAX_VALUE = 25; //the maximum atomic number
    static final int NO_OF_EXPRESSIONS = 50; //the number of expressions generated

    /**
     * the main method - creates 50 expression, prints all of them and checks if other expressions are equal.
     * @param args
     */
    public static void main(String[] args) {
        //the arraylist of expressions
        ArrayList<Expression> expressions = new ArrayList<>();
        //initializing the arraylist.
        for(int i = 0; i < NO_OF_EXPRESSIONS; i++){
            expressions.add(createExpression());
        }
        //printing the expressions, other expressions that equals this expression and what they are equal to.
        for(int i = 0; i < NO_OF_EXPRESSIONS; i++){
            System.out.print((expressions.get(i)).toString());
            for(int j = i; j < NO_OF_EXPRESSIONS; j++){
                if(i!=j && (expressions.get(i)).calculate() == (expressions.get(j)).calculate()){
                    System.out.print(" = " + (expressions.get(j)).toString());
                }
            }
            System.out.println( " = " + (expressions.get(i)).calculate());
            System.out.println("");
        }
    }

    /**
     * a function that creates an expression that is constructed with atomic expressions.
     * @return the generated expression
     */
    public static Expression createExpression(){
        Random rnd = new Random();
        Expression exp = new AtomicExpression(rnd.nextInt(NO_MAX_VALUE + 1));
        //number of operators
        int noOfOperators = rnd.nextInt(OPERATORS_BOUND + 1);

        for(int i = 0; i < noOfOperators; i++){
            AtomicExpression at = new AtomicExpression(rnd.nextInt(NO_MAX_VALUE + 1));
            if(rnd.nextInt(2) == 0) exp = new AdditionExpression(exp, at);
            else exp = new SubtractionExpression(exp, at);
        }
        return exp;
    }
}