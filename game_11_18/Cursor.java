
/**
 * Write a description of class Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cursor
{
    // instance variables - replace the example below with your own
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void set( int i, int j)
    {
        x = i;
        y = j;
    }
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}
