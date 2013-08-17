import java.util.HashSet;

public class ForbiddenWords
{
    private HashSet<String> forbiddenWords;
    
    public ForbiddenWords()
    {
        this.forbiddenWords = new HashSet<String>();
    }
    
    public void add(String word) {
        this.forbiddenWords.add(word);
    }
    
    public int length() {
        return this.forbiddenWords.size();
    }
    
    public boolean isWordForbidden(String word) {
    	return this.forbiddenWords.contains(word);
    }
}
