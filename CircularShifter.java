public class CircularShifter
{
    private LineStorage lineStorage;
    private ForbiddenWords forbiddenWords;
    
    public CircularShifter(LineStorage lineStorage, ForbiddenWords forbiddenWords)
    {
        this.lineStorage = lineStorage;
        this.forbiddenWords = forbiddenWords;
    }
    
    public LineStorage getLines() {
        // returns a data structure LineStorage that have all the possible circular shifted lines
    	LineStorage permutedLines = new LineStorage();
    	for (int i = 0; i< lineStorage.length(); i++) {
    		String line = lineStorage.getLineAtIndex(i);
    		System.out.println(line);
    		String firstWord = line.split(" ")[0];
    		if(!this.forbiddenWords.isWordForbidden(firstWord)) {
    			permutedLines.addLine(line);
    		}
    	}
        return permutedLines;
    }
    
}
