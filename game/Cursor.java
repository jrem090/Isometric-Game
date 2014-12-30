
/**
 * Method to hold cursor information
 * 
 * @author (John Remmes) 
 * @version (0.1)
 */
public class Cursor
{
    // instance variables 
    private int x;
    private int y;
    /**
     * Constructor for objects of class Cursor
     */
    public Cursor()
    {
        // initialise instance variables
        x = 0;
        y = 0;
    }
    
    /**
     * Constructor for objects of class Cursor
     */
    public Cursor(int i, int j)
    {
        // initialise instance variables
        x = i;
        y = j;
    }
    
    /**
     * Helper method that sets values of cursor
     * 
     * @param  i set x value
     * @param  j set y value
     */
    public void set( int i, int j)
    {
        x = i;
        y = j;
    }
    
    /**
     * Helper method that returns X value
     * @return x-coordinate of cursor
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Helper method that returns Y value
     * @return y-coordinate of cursor
     */
    public int getY()
    {
        return y;
    }
}
