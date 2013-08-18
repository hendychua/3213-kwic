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
            //System.out.println(line);
            //String firstWord = line.split(" ")[0];
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
                    String newLine = firstHalf + secondHalf.trim();
                    permutedLines.addLine(newLine);
                }
            }
            //if(!this.forbiddenWords.isWordForbidden(firstWord)) {
            //    permutedLines.addLine(line);
            //}
        }
        return permutedLines;
    }
    
}
