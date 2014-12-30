import java.awt.*;
import javax.swing.*;

/**
 * Tile is a class that holds information for a specific tile in the level
 * 
 * @author (John Remmes) 
 * @version (0.1)
 */
public class Tile
{
    // instance variables -
    public int height;
    boolean isOccupied = false;
    Color top;
    Color base;
    public PhysicalObject object;
    
    //maybe have a thing class?
    /**
     * Constructor for objects of class Tile
     */
    public Tile()
    {
        // empty constructor
    }
    
    /**
     * Constructor for objects of class Tile
     */
    public Tile(int h,  boolean occupied, Color top1, Color base1)
    {
        // initialise instance variables
        height = h;
        isOccupied = occupied;
        top = top1;
        base = base1;
    }
}
