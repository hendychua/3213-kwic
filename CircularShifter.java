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
        return null;
    }
    
    // Implement other necessary methods
    // Remember to shift the lines circularly, skipping those forbiddenWords
}
