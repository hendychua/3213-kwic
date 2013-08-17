public class Output
{
    private Alphabetizer alphabetizer;
    
    public Output(Alphabetizer alphabetizer)
    {
        this.alphabetizer = alphabetizer;
    }
    
    public void print() {
        LineStorage ls = this.alphabetizer.getLines();
        
        if (ls != null) {
            for (int i=0; i<ls.length(); i++) {
                System.out.println(ls.getLineAtIndex(i));
            }
        }
    }
}
