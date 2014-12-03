
/**
 * Write a description of class Action here.
 * 
 * @author (John Remmes) 
 * @version (1.1)
 */
public class Action
{
    // instance variables - replace the example below with your own
    public String name ="";
    public int[] type; //1.target(damage/heal) 2.buff 3.debuff
    public int[] effectAmount;
    public int[] damageType;
    public int range; //distance action can reach
    public int aoeSize = 0; //if aoe change
   
    
    /**
     * Constructor for objects of class Action
     */
    public Action(String id, int[] typeAct, int[] effectAm, int[] damageT, int rangeAtk, int area)
    {
        // initialise instance variables
        name=id;
        type = typeAct;
        effectAmount = effectAm;
        damageType = damageT;
        range = rangeAtk;
        aoeSize = area;
    }

    public Action()
    {}
    /**
     * Constructor for objects of class Action
     */
    public Action(String id)
    {
        // initialise instance variables
        name=id;
        //type = 1;
        range=1;
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
        return 2;
    }
}
