import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class moveTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
