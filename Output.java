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
            System.out.println("**** Results are: ****");
            for (int i=0; i<ls.length(); i++) {
                System.out.println(ls.getLineAtIndex(i));
            }
            System.out.println("**** End of Results: ****");
        }
    }
}
