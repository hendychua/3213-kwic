public class MainControl
{
    public static void main(String args[]) {
        
        Input in1 = new Input();
        LineStorage originalLines = in1.parseLines();
        ForbiddenWords forbiddenWords = in1.parseWords();
        
        CircularShifter circularShifter = new CircularShifter(originalLines, forbiddenWords);
        
        Alphabetizer alpha = new Alphabetizer(circularShifter.getLines());
            
        Output out1 = new Output(alpha);
        out1.print();
        
        //System.out.println("Completed");
    
    }
}
