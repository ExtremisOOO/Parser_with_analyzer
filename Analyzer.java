import java.util.ArrayList;
public class Analyzer extends DataBase {

    Expression expressionClass;
    Ifstatement ifStatement = new Ifstatement();
    whileSatement whileSatement = new whileSatement();

    public void analyzer(int start,int end) {
        for (int i = start; i < end;i++) {
            String command = fileLines.get(i);
            if(!isProgramWorking){
                System.out.println("Error in code");
                break;
            }
            boolean expression = command.contains("=");
            boolean statementIf = command.startsWith("if");
            boolean statementWhile = command.startsWith("while");
            boolean isPositiveWhile = false;

            if (expression) {
                new Expression(command);
            } else if (statementIf) {
                if (!ifStatement.getIsPositiveIfStatement(command)) {
                    i = findEndofStatement(i);
                }
            } else if (statementWhile){
                isPositiveWhile = whileSatement.isPositiveIsWhileOperator(command);
                if(isPositiveWhile) {
                    analyzer(i+1,findEndofStatement(i));
                    i--;
                }else
                    i = findEndofStatement(i);
            }
        }
    }
    public void matchStatementing(String command, int temp){
        if(command.startsWith("if") || command.startsWith("while")){
            statementsIndex.add(temp);
            endsIndex.add(0);
        }
        if(command.startsWith("end")){
            for (int i = statementsIndex.size()-1; i >= 0 ; i--) {
                if(endsIndex.get(i)==0){
                    endsIndex.set(i,temp);
                    break;
                }
            }
        }
    }
    private int findEndofStatement(int lineIndex){
        for (int i = 0; i < statementsIndex.size(); i++) {
            if(lineIndex == statementsIndex.get(i)){
                return endsIndex.get(i);
            }
        }
        return 0;
    }
}
