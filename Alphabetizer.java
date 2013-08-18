public class Alphabetizer
{
    private LineStorage lineStorage;
    
    public Alphabetizer(LineStorage original)
    {
        // sorts the original line storage and stores the result in its private copy
        
        this.lineStorage = new LineStorage();
        
        for (int i=0; i<original.length(); i++) {
                  
            String current = original.getLineAtIndex(i);
            
            if (this.lineStorage.length() != 0) {
            
                for (int j=0; j<lineStorage.length(); j++) {
                
                    String cmp = lineStorage.getLineAtIndex(j);
                    int compareResult = current.compareTo(cmp);
                    
                    if (compareResult < 0) {
                        this.lineStorage.addLineAtIndex(j, current);
                        break;
                    } else if (j == lineStorage.length()-1) { // last element
                        this.lineStorage.addLine(current);
                        break;
                    }
                }
            
            } else {
                this.lineStorage.addLine(current);
            }
        }
    }
    
    public LineStorage getLines() {
        return this.lineStorage;
    }
}
