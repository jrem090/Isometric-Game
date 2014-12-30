
/**
 * Interactable is an extension of the PhysicalObject Class
 * This is reserved for non character interactable objects
 * i.e. crates, bombs, chests, etc
 * 
 * @author (John Remmes) 
 * @version (0.1)
 */
public class Interactable extends PhysicalObject
{
    // instance variables - replace the example below with your own
    public int maxHP;
    public int currentHP;
    /**
     * Constructor for objects of class Character
     */
    public Interactable()
    {
        // initialise instance variables
    }

    /**
     *  Temporary method used to test isDead()
     */
    public void makeDestoryable()
    {
        currentHP = 10;
        maxHP = 10;
    }
    
    /**
     *  Returns stae of character. If dead or not
     *
     * @return     returns true if object/character is dead 
     */
    public boolean isDead()
    { 
        return currentHP<1;
    }
    
    
    /**
     *  Returns stae of character. If dead or not
     *
     * @param  action Action to be done on said Object/Character
     * @param  actor  Character doing action on this interac
     */
    public void recieveAction(Action action, Character actor)
    {
        for(int i = 0; i < action.type.length; i++)
        {
            if(action.type[i] == 1)
            {
                currentHP = currentHP + action.effectAmount[i];
                
                if(currentHP>maxHP){currentHP = maxHP; System.out.println("full health");}
                else if(isDead())System.out.println("dead");
                System.out.println("MAX HP " + maxHP + "  HP " + currentHP);
            }
        }
        
    }
}
