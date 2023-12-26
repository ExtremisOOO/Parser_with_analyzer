import java.util.ArrayList;

public class UnusedAssignments extends DataBase {
    private ArrayList<Character> usedAssignments() {
        int temp = 0;
        ArrayList<Character> usedAssignments = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (isVariableUsed[i]) {
                usedAssignments.add((char)(i+97));
            }
        }
        return usedAssignments;
    }
    void writeUnusedAssignments(){
        ArrayList<Character> usedAssignments = usedAssignments();
        for (int i = 0; i < fileLines.size(); i++) {
            String command = fileLines.get(i);
            if(command.contains("=") && !(usedAssignments.contains(command.charAt(0)))){
                System.out.println(command);
            }
        }
    }
    UnusedAssignments(){
        writeUnusedAssignments();
    }
}

