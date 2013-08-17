import java.util.ArrayList;

public class LineStorage
{
	private ArrayList<String> lines;
    public LineStorage()
    {
    	lines = new ArrayList<String>();
    }
    
    public String getLineAtIndex(int i) {
        // return the line at index i
        return lines.get(i);
    }
    
    public int length() {
        // return the number of lines in this storage
        return lines.size();
    }
    
    public void addLine(String line) {
        // adds line to the last element
    	lines.add(line);
    }
    
    public void addLineAtIndex(int i, String line) {
        // adds line to index i. shifts the element currently as the position i (if any) and subsequent
        // elements to right i.e. adds 1 to their indices
    	lines.add(i, line);
    }
    
    public String getFirstWordAtIndex(int i) {
    	String line = getLineAtIndex(i);
    	return line.split(" ")[0];
    }
}
