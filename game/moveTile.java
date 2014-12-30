import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Holds information regarding movement
 * may want to consider making this an inner class
 * 
 * @author (John Remmes) 
 * @version (0.1)
 */
public class moveTile
    {
        int i;
        int j;
        Color color;
        String tilePath;
        public moveTile(int x, int y, String path)
        {
            i=x;
            j=y;
            tilePath = path;
        }
        public boolean same(int x, int y)
        {
            if(x==i && y==j)return true;
            return false;
        }
    }
