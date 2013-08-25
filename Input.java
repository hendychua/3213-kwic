import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input
{
	public final String INPUT_FILE = "input.txt";
    public Input() {
    }
    
    public LineStorage parseLines() {
         // returns the data structure LineStorage which contains lines entered by user
    	
    	LineStorage lines = null;
    	System.out.println("Enter the mode of input: ");
    	System.out.println("0. Read from " + INPUT_FILE);
    	System.out.println("1. Enter the input in the terminal window.");
    	
    	Scanner sc = new Scanner(System.in);
    	String line = sc.nextLine();
    	while(!line.equals("0") && !line.equals("1")) {
    		System.out.println("Please enter 0 or 1:");
    		line = sc.nextLine();
    	}
    	
    	if(line.equals("0")) {
    		lines = readInputFromFile();
    	} else if(line.equals("1")) {
    		lines = readInputFromTerminal();
    	}
    	return lines;
    }
    
    private LineStorage readInputFromFile() {
    	LineStorage lines = new LineStorage();
    	String line = new String();
    	System.out.println("reading from file");
    	File inputFile = new File(INPUT_FILE);
    	BufferedReader reader = null;
    	try {
			reader = new BufferedReader(new FileReader(inputFile));
			line = reader.readLine();
			while(line != null) {
				lines.addLine(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There was an error reading from the file: " + e.getMessage());
		}
		return lines;
	}

	private LineStorage readInputFromTerminal() {
		// TODO Auto-generated method stub
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
