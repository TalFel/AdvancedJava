//a class with 1 function that calculates an expression.
public class Calc {
    /**
     * a function that calculates the expression
     * @param exp - the expression toString()
     * @return the calculated expression
     */
    public static double calcExp(String exp){
        int len = exp.length();
        String temp = "";
        double tot = 0;

        for(int i = len - 1; i >= 0; i--){
            if(exp.charAt(i) == '+'){
                tot+= Double.parseDouble(temp);
                temp = "";
            }
            else if (exp.charAt(i) == '-') {
                tot-= Double.parseDouble(temp);
                temp = "";
            }
            else if(exp.charAt(i) != ')' && exp.charAt(i) != '('){
                temp = exp.charAt(i) + temp;
            }
        }
        if(!temp.equals("")) tot+=Double.parseDouble(temp);

        return tot;
    }
}
