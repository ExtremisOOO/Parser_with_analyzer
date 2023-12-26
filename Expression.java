public class Expression extends DataBase{
    Expression(String expression){
        if(analyzeSyntaxExpression(expression)) {
            makeExpression(expression);
        }else{
            isProgramWorking = false;
        }
    }
    private void makeExpression(String expression){
        int index = expression.charAt(0)-97;
        CalculateExpression calculateExpression = new CalculateExpression();

        variablesNumbers[index] = calculateExpression.clculator(expression.substring(2));
        variables[index] = true;
        //System.out.println(expression+" "+variablesNumbers[index]);
    }
    private boolean analyzeSyntaxExpression(String expression){
        int length = expression.length();
        char letter = expression.charAt(1);
        if(!(isLetter(expression.charAt(0)) || letter!='=' || length==2))
            return false;
        else{
            for (int i = 2; i < length; i++) {
                letter = expression.charAt(i);
                if(!(isDigit(letter) || isLetter(letter) || isOperator(letter)))
                    return false;
            }
        }
        return true;
    }
    private boolean isDigit(char digit){return Character.isDigit(digit);}
    private boolean isLetter(char letter){return letter >= 'a' && letter <= 'z';}
    private boolean isOperator(char operator){return avaibleOperators.contains(operator);}
}
