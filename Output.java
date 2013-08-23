import java.util.Scanner;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Output
{
    private Alphabetizer alphabetizer;
    private final String RESULTS_FILE = "results.txt";
    
    public Output(Alphabetizer alphabetizer)
    {
        this.alphabetizer = alphabetizer;
    }
    
    public void print() {
        LineStorage ls = this.alphabetizer.getLines();
        
        if (ls != null) {
            System.out.println("Choose how you want to view the results:");
            System.out.println("0. Print results on terminal.");
            System.out.println("1. Write results to " + this.RESULTS_FILE + ".");
            System.out.print("Enter the index to indicate your choice: ");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            
            while (!line.equals("0") && !line.equals("1")) {
                System.out.print("Please enter 0 or 1: ");
                line = sc.nextLine();
            }
            
            if (line.equals("0")) {
                this.printToTerminal(ls);
            } else if (line.equals("1")) {
                this.writeToFile(ls);
            }
        }
    }
    
    private void printToTerminal(LineStorage ls) {
        System.out.println("**** Results ****");
        for (int i=0; i<ls.length(); i++) {
            System.out.println(ls.getLineAtIndex(i));
        }
        System.out.println("**** End of Results ****");
    }
    
    private void writeToFile(LineStorage ls) {
        System.out.println("**** Writing to file " + this.RESULTS_FILE + ". ****");
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                                            new FileOutputStream(this.RESULTS_FILE), "utf-8"));
            for (int i=0; i<ls.length(); i++) {
                writer.write(ls.getLineAtIndex(i) + "\n");
            }
        } catch (IOException ex){
            System.out.println("There was an error writing to the file: " + ex.getMessage());
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
        System.out.println("**** Finished writing to file " + this.RESULTS_FILE + ". ****");
    }
}
