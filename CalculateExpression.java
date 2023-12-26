import java.util.*;

public class CalculateExpression extends DataBase{

    private int sum = 0;

    public int clculator(String function){
        int n=function.length();
        ArrayList<StringBuilder> functionOfStrings = convertFunctionToArrOfString(function,n);
        if(n==0){
            return 0;
        } else if (functionOfStrings.size()==1) {
            return convertFunctionIfIsNotNumber(functionOfStrings.get(0));
        }
        if(functionOfStrings.size()>1){
            ArrayList<String> arrayOfOperator = new ArrayList<>(List.of("*", "/","+","-",""));

            do{
                for (String operator : arrayOfOperator) {
                    StringBuilder stringOperator = new StringBuilder(operator);

                    for (int i = 1; i < functionOfStrings.size()-1; i+=2) {
                        if (functionOfStrings.get(i).compareTo(stringOperator) == 0) {
                            int number1 = convertFunctionIfIsNotNumber(functionOfStrings.get(i-1));
                            int number2 = convertFunctionIfIsNotNumber(functionOfStrings.get(i+1));

                            functionOfStrings.set(i,new StringBuilder(sumOperatorString(number1,number2,operator)));
                            functionOfStrings.remove(i+1);
                            functionOfStrings.remove(i-1);
                        }
                    }
                }
            }while (functionOfStrings.size()!=1);
        }
        return Integer.parseInt(String.valueOf(functionOfStrings.get(0)));
    }
    private int convertFunctionIfIsNotNumber(StringBuilder stringBuilder){
        char sign = stringBuilder.charAt(0);
        if(Character.isLetter(sign)){
            if(checkIfIndexIsActive(sign) && stringBuilder.length()==1){
                isVariableUsed[(int)(sign-97)] = true;
                return Integer.parseInt(String.valueOf(variablesNumbers[(int)(sign-97)]));
            }else{
                isProgramWorking = false;
            }
        }else{
            try {
                return Integer.parseInt(String.valueOf(stringBuilder));
            }catch (NumberFormatException e){
                isProgramWorking = false;
            }
        }
        return 0;
    }
    private ArrayList<StringBuilder> convertFunctionToArrOfString(String function,int n){
        ArrayList<StringBuilder> output = new ArrayList<>();
        int temp;
        for (temp = 0;temp < n;) {
            StringBuilder digit = new StringBuilder();
            char sign;
            boolean isOperator;
            do{
                sign = function.charAt(temp++);
                isOperator = avaibleOperators.contains(sign);
                digit.append(sign);
            }while(!isOperator && temp<n);
            if(!isOperator) {
                output.add(digit);
            }else {
                output.add(new StringBuilder(digit.substring(0, digit.length() - 1)));
                output.add(new StringBuilder(Character.toString(sign)));
            }
        }
        return output;
    }
    private String  sumOperatorString(int number1,int number2,String operator){
        return String.valueOf (sumOperators(number1, number2, operator));
    }
    private int sumOperators(int number1,int number2,String operator){
        return switch (operator) {
            case "+" -> number1 + number2;
            case "*" -> number1 * number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / number2;
            default -> 0;
        };
    }
    public boolean isExpressionPositiv(int number,int number2,char operator){
        return switch (operator) {
            case '>' -> number > number2;
            case '<' -> number < number2;
            default -> false;
        };
    }
    public int getSum(){
        return sum;
    }
}
