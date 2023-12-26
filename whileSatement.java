public class whileSatement extends DataBase{
    private int operatorIndex = 0;
    public boolean isPositiveIsWhileOperator(String expression){
        if(analyzeSyntaxExpression(expression)){
            int number1,number2;
            CalculateExpression calculateExpression = new CalculateExpression();
            String[] functions = findOperatorIndex(expression);
            number1 = calculateExpression.clculator(functions[0]);
            number2 = calculateExpression.clculator(functions[1]);
            return calculateExpression.isExpressionPositiv(number1, number2, expression.charAt(operatorIndex));
        }else{
            isProgramWorking = false;
            return false;
        }
    }
    private String[] findOperatorIndex(String expression){
        String[] output = new String[2];
        for (int i = 6; i < expression.length(); i++) {
            if(expression.charAt(i) == '>' || expression.charAt(i) == '<'){
                operatorIndex = i;
            }
        }
        output[0] = expression.substring(6,operatorIndex);
        output[1] = expression.substring(operatorIndex+1,expression.length()-1);
        return output;
    }
    private boolean analyzeSyntaxExpression(String expression){
        if(!(expression.charAt(5)=='(' && expression.endsWith(")"))){
            return false;
        }else{
            for (int j = 6; j < expression.length()-1; j++) {
                char letter = expression.charAt(j);
                if(!(isDigit(letter) || isLetter(letter) || isOperator(letter)))
                    return false;
            }
        }

        return true;
    }

    private boolean isDigit(char digit){return Character.isDigit(digit);}
    private boolean isLetter(char letter){return letter >= 'a' && letter <= 'z';}
    private boolean isOperator(char operator){return avaibleOperatorsIfWhile.contains(operator);}
}
