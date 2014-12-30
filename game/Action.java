
/**
 * This is a class designed to represent an Action done by a character
 * 
 * @author (John Remmes) 
 * @version (0.1)
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
    /**
     * Constructor for objects of class Action
     */
    public Action()
    {}
    /**
     * Constructor for objects of class Action, using only id. used for testing basic actions
     */
    public Action(String id)
    {
        // initialise instance variables
        name=id;
        //type = 1;
        range=1;
    }
   
}
