import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {
    public static boolean isProgramWorking = true;
    protected static boolean[] isVariableUsed = new boolean[26];
    protected static ArrayList<Integer> statementsIndex = new ArrayList<>();
    protected static  ArrayList<Integer> endsIndex = new ArrayList<>();
    static protected ArrayList<String> fileLines = new ArrayList<>();
    static protected boolean[] variables = new boolean[26];
    static protected int[] variablesNumbers = new int[26];
    ArrayList<Character> avaibleOperators = new ArrayList(Arrays.asList('+','-','/','*','(',')'));
    ArrayList<Character> avaibleOperatorsIfWhile = new ArrayList(Arrays.asList('+','-','/','*','>','<','(',')'));
    public boolean checkIfIndexIsActive(char letter){
        return variables[letter-97];
    }
}
