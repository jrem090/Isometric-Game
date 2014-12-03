
/**
 * Write a description of class Action here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Action
{
    // instance variables - replace the example below with your own
    private int baseEffect = 10;
    public String name ="";
    public int type; //1.target(damage/heal) 2.AOE 3.buff 4.debuff
    public int range; //distance action can reach
    public int aoeSize = 0; //if aoe change
    
    
    /**
     * Constructor for objects of class Action
     */
    public Action(String id)
    {
        // initialise instance variables
        name=id;
        type = 1;
        range=1;
    }

    
    /**
     * Constructor for objects of class Action
     */
   /* public Action(String id)
    {
        // initialise instance variables
        name=id;
        type = 1;
        range=1;
    }*/
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return 2;
    }
}
