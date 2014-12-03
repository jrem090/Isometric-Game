
/** 
 * Base Class for objects 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysicalObject
{
    // instance variables - replace the example below with your own
    private int i;
    private int j;
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setGrid(int x, int y)
    {
        // put your code here
        i=x;
        j=y;
    }
    public int getX()
    {
        return i;
    }
    public int getY()
    {
        return j;
    }
    public void recieveAction(Action action, Character actor)
    {
        System.out.println("I'm a tree you dolt");
    }
    public boolean isDead()
    {
        return false;
    }
}
