import java.util.Scanner;

public class Input
{
    public Input() {
    }
    
    public LineStorage parseLines() {
         // returns the data structure LineStorage which contains lines entered by user
    	LineStorage lines = new LineStorage();
    	System.out.println("Enter movie titles");
    	Scanner sc = new Scanner(System.in);
    	String line = sc.nextLine();
    	while(!line.equals("0")) {
    		lines.addLine(line); 
    		line = sc.nextLine();
    	}
        return lines;
    }
    
    public ForbiddenWords parseWords() {
        // returns the data structure ForbiddenWords which contains words to ignore entered by user
    	ForbiddenWords forbiddenWords = new ForbiddenWords();
    	System.out.println("Enter the forbidden words");
    	Scanner sc = new Scanner(System.in);
    	String word = sc.next();
    	while(!word.equals("0")) {
    		forbiddenWords.add(word); 
    		word = sc.next();
    	}
        return forbiddenWords;
    }
}
