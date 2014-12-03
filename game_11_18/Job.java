
/**
 * Write a description of class Job here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Job
{
    // instance variables - replace the example below with your own
    public Action[] moveList = new Action[10];
    public int[] moveState = new int[10];
    public int[] levelLimits = new int[10];
    public int jobLevel = 1;
    public String name;
    
    /**
     * Constructor for objects of class Job
     */
    public Job(Action[] act, int[] move, int[] levelLim)
    {
        // initialise instance variables
        
    }
    public Job()
    {}
    public Job tamer(Action[] act, int[] move, int[] levelLim)
    {
        return new Job();
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
