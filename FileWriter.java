
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWriter extends DataBase{
    FileWriter(String fileName){
        readingFiles(fileName);
    }
    private void readingFiles(String fileName){
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            Analyzer analyzer = new Analyzer();
            int temp = 0;
            while (scanner.hasNextLine()){
                String nextLine = deleteSpaces(scanner.nextLine());
                analyzer.matchStatementing(nextLine,temp++);
                fileLines.add(nextLine);
            }
            if(!endsIndex.contains(0))
                analyzer.analyzer(0,fileLines.size());
            else
                System.out.println("Error in code");
            UnusedAssignments unusedAssignments = new UnusedAssignments();

        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private String deleteSpaces(String line){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if(letter != ' '){
                output.append(letter);
            }
        }
        return output.toString();
    }
}
