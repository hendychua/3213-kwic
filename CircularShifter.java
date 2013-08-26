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
            line = cleanup(line);
            String[] tokens = line.split(" ");
            for (int j=0; j<tokens.length; j++) {
                String currentWord = tokens[j];
                if(!this.forbiddenWords.isWordForbidden(currentWord)) {
                    String firstHalf = "";
                    String secondHalf = "";
                    for (int k=j; k<tokens.length; k++) {
                        firstHalf += tokens[k] + " ";
                    }
                    if (j != 0) {
                        for (int k=0; k<j; k++) {
                            secondHalf += tokens[k] + " ";
                        }
                    }
                    String newLine = firstHalf + secondHalf;
                    permutedLines.addLine(newLine);
                }
            }
        }
        return permutedLines;
    }

    // does cleanup actions on the string like removing multiple spaces, 
    // leading and trailing spaces, etc.
	private String cleanup(String line) {
		line = line.replaceAll(" +", " ");
		return line.trim();
	}
    
}
