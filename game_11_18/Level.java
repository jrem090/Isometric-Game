import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * This class stores the data needed for a level
 * This includes a list of objects on the field, a grid of tiles, and a list of
 * characters in their turn order.
 * 
 * @author (John Remmes) 
 * @version (11/11)
 */
public class Level
{
    // instance variables //public until i do what I'm supposed to
    public Tile[][] grid;
    public ArrayList<moveTile> movement = new ArrayList<moveTile>();
    public ArrayList<moveTile> moveThrough = new ArrayList<moveTile>();
    public ArrayList<PhysicalObject> objects = new ArrayList<PhysicalObject>();
    public ArrayList<Character> turnList = new ArrayList<Character>();
    public Cursor cursor = new Cursor();

    /**
     * Constructor for objects of class Level
     * 
     * @param length dimension of board m x m
     */
    public Level(int length)
    {
        grid = new Tile[length][length];
        for(int i =0; i < length; i++)
        {
            for(int j = 0; j< length; j++)
            {
                grid[i][j] = new Tile();
            }
        }
    }

    /**
     * Constructor for objects of class Level
     * 
     * @param length dimension of board m x n
     * @param width 2nd dimension of board m x n
     */
    public Level(int length, int width)
    {
        grid = new Tile[length][width];
        for(int i =0; i < length; i++)
        {
            for(int j = 0; j< width; j++)
            {
                grid[i][j] = new Tile();
            }
        }
    }

    /**
     * Randomly instantiate a lvel with no PhysicalObjects
     * 
     */
    public void randomInit()
    {
        Random generator = new Random();
        int l = grid.length;
        int w = grid[1].length;

        Color grass = new Color(0,153,0);
        Color dirt = new Color(180,133,63);
        Color soil = new Color(101,78,62);
        for(int i =0; i < l; i++)
        {
            for(int j = 0; j< w; j++)
            {
                Color toAdd = dirt;
                if(generator.nextInt(2)==1){toAdd=grass;}
                grid[i][j] = new Tile(generator.nextInt(4)*8 -10, false, toAdd, soil);
            }
        }
    }

    public int getLength()
    {
        return grid.length;
    }

    public int getWidth()
    {
        return grid[1].length;
    }

    public int tileHeight(int x, int y)
    {
        return grid[x][y].height;
    }

    public Color getTop(int x, int y)
    {
        return grid[x][y].top;
    }

    public Color getBase(int x, int y)
    {
        return grid[x][y].base;
    }

    public boolean isOccupied(int x, int y)
    {
        return grid[x][y].isOccupied;
    }

    public void createGrassland(int numChars)
    {
        Random generator = new Random();
        int l = grid.length;
        int w = grid[1].length;

        Color grass = new Color(0,153,0);
        Color dirt = new Color(180,133,63);
        Color soil = new Color(101,78,62);
        for(int i =0; i < l; i++)
        {
            for(int j = 0; j< w; j++)
            {
                Color toAdd = dirt;
                if(generator.nextInt(2)==1){toAdd=grass;}
                grid[i][j] = new Tile(generator.nextInt(4)*8 -10, false, toAdd, soil);
            }
        }
        for(int i = 0; i< numChars; i++)
        {
            int x = generator.nextInt(l);
            int y = generator.nextInt(w);
            if(!addCharacter(x,y, new Character(i%2)))
            {
                i--;
            }
        }
        Collections.sort(turnList);
        cursor.set(turnList.get(0).getX(),turnList.get(0).getY());

        for(int i=0; i < turnList.size(); i++)
        {
            System.out.print(turnList.get(i).time + " ");
        }
        System.out.println("");
        //grid[4][6].isOccupied=true;
        //objects.add( new PhysicalObject());
        //objects.get(0).setGrid(4,6);
    }

    public boolean addCharacter(int i, int j, Character charToAdd)
    {
        if(grid[i][j].isOccupied)return false;
        charToAdd.setGrid(i,j);
        grid[i][j].isOccupied=true;
        turnList.add(charToAdd);
        objects.add(charToAdd);
        grid[i][j].object = charToAdd;
        return true;
    }

}
