import java.util.ArrayList;

public class ForbiddenWords
{
    private ArrayList<String> forbiddenWords;
    
    public ForbiddenWords()
    {
        this.forbiddenWords = new ArrayList<String>();
    }
    
    public void add(String word) {
        this.forbiddenWords.add(word);
    }
    
    public String getWordAtIndex(int i) {
        return this.forbiddenWords.get(i);
    }
    
    public int length() {
        return this.forbiddenWords.size();
    }
}
