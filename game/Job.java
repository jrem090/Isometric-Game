import java.util.*;
/**
 * This class holds data for a characers job/class
 * 
 * @author (John Remmes) 
 * @version (0.1)
 */
public class Job
{
    // instance variables
    public Action[] moveList = new Action[10];
    public int[] moveState = new int[10];
    public int[] levelLimits = new int[10];
    public int jobLevel = 1;
    public int jobXP=0;
    public String name;
    //public ArrayList<Equipment> equippable //lists equipment able to be worn
    
    /**
     * Constructor for objects of class Job
     */
    public Job(String Name, Action[] act, int[] move, int[] levelLim)
    {
        // initialise instance variables
        name = Name;
        moveList = act;
        moveState = move;
        levelLimits = levelLim;
    }
    /**
     * Empty Constructor for objects of class Job
     */
    public Job()
    {}
    
}
