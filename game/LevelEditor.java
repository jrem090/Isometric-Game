import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Class being created to create a GUI Level Editor and write the level information into a file
 * may have parts reworked to use in a save state function
 * 
 * @author (John Remmes) 
 * @version (0.05)
 */
public class LevelEditor extends JPanel
{
    // instance variables - replace the example below with your own
    private static int size = 10;
    private static JFormattedTextField sizeOfField;
    private int x;
    /**
     * Constructor for objects of class LevelEditor
     */
    public LevelEditor()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     *  Main class for level editor 
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Level Editor");
        //Game gameExample = new Game();
        //int numTiles = 15;
        //frame.add(new Game());
        sizeOfField = new JFormattedTextField();
        sizeOfField.setValue(new Integer(size));
        sizeOfField.setColumns(2);
        //sizeOfField.addPropertyChangeListener("value", this);
        frame.add(sizeOfField);
        frame.setFocusable(false);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Writes a level to a file
     * 
     * @param  toWrite Level to be written
     * @param inProgress to be used if code is reworked for savestate or level starts midbattle
     */
    public void writeFile(Level toWrite, boolean inProgress)
    {
        try{
            PrintWriter writer = new PrintWriter("level.txt", "UTF-8");
            int length = toWrite.grid.length;
            int width = toWrite.grid[1].length;//in case we use m x n
            writer.println("size: " + length);
            for(int i = 0; i <length; i++)
            {
                String line = "";
                for(int j = 0; j <length; j++)
                {
                    //write tile to line
                }
                //print line to writer
            }
            //print PhysicalObject list
            //print inProgress (boolean)
            //if inProgress
            //print Character turnList with characetr info
            //print DeadList
            //print cursor location

            writer.close();
        }
        catch(Exception e)
        {

        }
    }
}
