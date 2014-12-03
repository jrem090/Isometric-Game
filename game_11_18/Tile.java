import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile
{
    // instance variables - replace the example below with your own
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
