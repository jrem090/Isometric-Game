
/** 
 * Base Class for objects
 * provides framework for derived classes
 * pure PhysicalObjects are not interactable although they do occupy space on the level
 * i.e.trees,walls, etc
 * 
 * @author (John Remmes) 
 * @version (0.1)
 */
public class PhysicalObject
{
    // instance variables - 
    private int i; //equivalent of x coordinate
    private int j; //equivalent of y coordinate
    int team = -1;

    /**
     * Constructor for objects of class PhysicalObject
     */
        public PhysicalObject()
    {
        // initialise instance variables
        team = -1;
    }

    /**
     * Helper method used to set values
     * 
     * @param  x   set i field
     * @param  y   set j field
     */
    public void setGrid(int x, int y)
    {
        // put your code here
        i=x;
        j=y;
    }
    /**
     * Helper method used to return X value
     * 
     * @return value of i
     */
    public int getX()
    {
        return i;
    }
    /**
     * Helper method used to return Y value
     * 
     * @return value of j
     */
    public int getY()
    {
        return j;
    }
    /**
     * method responsible for handling actions targeting this PhysicalObject
     * 
     * @param action Action to be done onto PhysicalObject
     * @param actor Character that is doing action
     */
    public void recieveAction(Action action, Character actor)
    {
        //for pure PO treat as a background object and is not interactable
        System.out.println("I'm a tree you dolt");
    }
    public boolean isDead()
    {
        return false;
    }
}
