import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * The ActionManager Class is responsible for handling the keyInputs (and possibly later mouse inputs)
 * and determining a proper response
 * 
 * @author (John Remmes) 
 * @version (V 1.0+)
 */
public class ActionManager
{
    // instance variables - replace the example below with your own
    Level toUse;
    int cursorState = 0;
    int state = 0;

    //is the action available
    boolean move =true; //is movement available
    boolean act = true; //is an action available
    int selectedAction = 0; //what action is selected
    int charRange = 4; //used for testing

    /**
     * Constructor for objects of class ActionManager
     */
    public ActionManager(Level use)
    {
        toUse=use;
        cursorState = 1;
    }

    public void reaction(KeyEvent e)
    {
        KeyEvent event = e;
        //System.out.println(KeyEvent.getKeyText(event.getKeyCode()));
        if(state == 1)//move was pressed and now deciding where to move
        {
            moveCursorMove(event);
        }
        else if(state ==2)//action pressed
        {
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace"))
            {
                state = 0;
            }
            else{
                String command = KeyEvent.getKeyText(event.getKeyCode());
                int selAction = Integer.parseInt(command);
                if((selAction-1)<toUse.turnList.get(0).moveList.length)
                {
                    //do Action
                    state = 21;
                    selectedAction=selAction-1;
                    getActionRange(toUse.turnList.get(0).moveList[selectedAction].range,toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY(), "" );
                    cursorState=3;
                    /*for(int k = 0; k<toUse.movement.size(); k++)
                    {
                    if(toUse.movement.get(k).same(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY()))toUse.movement.remove(k);
                    }*/

                }
                else{} //an action was not selected
            }
        }
        else if(state ==21)//specific action pressed
        {
            moveCursorAction(event);
            //toUse.cursor.set(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY());
        }
        else if(KeyEvent.getKeyText(event.getKeyCode()).equals("1"))//move pressed
        {
            if(state == 0 && move)
            {
                //System.out.println("does this");
                getMovement(charRange,toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY(), "" );
                toUse.cursor.set(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY());
                for(int k = 0; k<toUse.movement.size(); k++)
                {
                    if(toUse.movement.get(k).same(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY()))toUse.movement.remove(k);
                }
                cursorState=3;
                state=1;}
            else{}
        }
        else if(KeyEvent.getKeyText(event.getKeyCode()).equals("2"))//action pressed
        {
            //System.out.println("action");
            toUse.cursor.set(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY());
            if(state == 0 && act)
            {
                //System.out.println("action");
                state = 2;
                cursorState=3;
            }
        }
        else if(KeyEvent.getKeyText(event.getKeyCode()).equals("3"))//end turn 
        {
            //System.out.println("action");
            toUse.cursor.set(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY());
            if(state ==0 )
            {
                //System.out.println("wait and reset");
                for(int i=1; i < toUse.turnList.size(); i++)
                {
                    Character temp = toUse.turnList.get(i);
                    temp.time = temp.time - toUse.turnList.get(0).time;
                    toUse.turnList.set(i,temp);
                }
                Character done = toUse.turnList.get(0);
                done.time = 100-done.speed;
                Collections.sort(toUse.turnList);
                for(int i=0; i < toUse.turnList.size(); i++)
                {
                    System.out.print(toUse.turnList.get(i).time + " ");
                }
                System.out.println("");
                toUse.cursor.set(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY());
                move = true;
                act = true;
            }
        }
        else if(cursorState == 1)//this is gonna be inspect function if backspace return, otherwise movecursor
        {
            moveCursor(event);
        }
        /*else
        if(cursorState == 1)
        {
        //if(KeyEvent.getKeyText(event.getKeyCode()).equals("Up"))
        if(KeyEvent.getKeyText(event.getKeyCode()).equals("Q"))
        {
        System.out.println("2");
        cursorState = 2;
        }
        else moveWithObject(event, toUse.turnList.get(0));
        }
        else if (cursorState==2)
        {
        if(KeyEvent.getKeyText(event.getKeyCode()).equals("W"))
        {
        System.out.println("1");
        cursorState = 1;
        //set cursor to thing
        toUse.cursor.set(toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY());
        }
        else moveCursor(event);
        }
        else
        {
        moveCursorMove(event);
        }*/
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean moveWithObject(KeyEvent e, PhysicalObject thing)
    {
        // get x y of thing
        int oldX = thing.getX();
        int oldY = thing.getY();
        int newX=oldX;
        int newY=oldY;
        //check new x y then set
        //if up check if j-1 is >= 0 then set newJ = j-1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            if(oldX+1<toUse.getLength()){
                newX++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            if(oldX-1>=0){
                newX--;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            if(oldY-1>=0){
                newY--;
            }
            else{
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            if(oldY+1<toUse.getLength()){
                newY++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        }
        else{return false;}

        //set new x y
        thing.setGrid(newX,newY);

        // set new xy occupied
        toUse.grid[newX][newY].isOccupied=true;
        toUse.grid[newX][newY].object = thing;

        //set old xy unoccupied
        toUse.grid[oldX][oldY].isOccupied=false;
        toUse.grid[oldX][oldY].object = null;

        toUse.cursor.set(newX,newY);
        return true;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean moveCursor(KeyEvent e)
    {
        // get x y of thing
        int oldX = toUse.cursor.getX();
        int oldY = toUse.cursor.getY();
        int newX=oldX;
        int newY=oldY;
        //check new x y then set
        //if up check if j-1 is >= 0 then set newJ = j-1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            if(oldX+1<toUse.getLength()){
                newX++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            if(oldX-1>=0){
                newX--;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            if(oldY-1>=0){
                newY--;
            }
            else{
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            if(oldY+1<toUse.getLength()){
                newY++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        }
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace"))
        {
            cursorState=1;
            newX=toUse.turnList.get(0).getX();
            newY=toUse.turnList.get(0).getY();
            state = 0;
        }
        else{return false;}

        toUse.cursor.set(newX,newY);
        return true;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean moveCursorMove(KeyEvent e)
    {
        // get x y of thing
        int oldX = toUse.cursor.getX();
        int oldY = toUse.cursor.getY();
        int newX=oldX;
        int newY=oldY;
        //check new x y then set
        //if up check if j-1 is >= 0 then set newJ = j-1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            if(oldX+1<toUse.getLength()&& (inMovement(oldX+1, oldY) || inMoveThrough(oldX+1, oldY))){
                newX++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            if(oldX-1>=0 && (inMovement(oldX-1, oldY)|| inMoveThrough(oldX-1, oldY))){
                newX--;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            if(oldY-1>=0 && (inMovement(oldX, oldY-1)|| inMoveThrough(oldX, oldY-1))){
                newY--;
            }
            else{
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            if(oldY+1<toUse.getLength() && (inMovement(oldX, oldY+1)|| inMoveThrough(oldX, oldY+1))){
                newY++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        }
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace"))
        {
            cursorState=1;
            toUse.movement = new ArrayList<moveTile>();
            newX=toUse.turnList.get(0).getX();
            newY=toUse.turnList.get(0).getY();
            state = 0;
        }
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Enter"))
        {
            if(inMoveThrough(oldX,oldY))
            {

            }
            else
            {
                toUse.cursor.set(oldX,oldY);
                PhysicalObject thing = toUse.turnList.get(0);
                int toldX = thing.getX(); 
                int toldY = thing.getY();
                if(toldX == newX && toldY == newY)
                {}
                else{
                    thing.setGrid(newX,newY);

                    // set new xy occupied
                    toUse.grid[newX][newY].isOccupied=true;
                    toUse.grid[newX][newY].object = thing;

                    //set old xy unoccupied
                    toUse.grid[toldX][toldY].isOccupied=false;
                    toUse.grid[toldX][toldY].object = null;
                    toUse.movement = new ArrayList<moveTile>();
                    toUse.moveThrough = new ArrayList<moveTile>();
                    cursorState=1;
                    move = false;
                    state = 0;
                }
            }
        }
        else{return false;}

        toUse.cursor.set(newX,newY);
        return true;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean moveCursorAction(KeyEvent e)
    {
        //getMovement(toUse.turnList.get(0).moveList[selectedAction].range, toUse.turnList.get(0).getX(),toUse.turnList.get(0).getY(), "" );
        // get x y of thing
        int oldX = toUse.cursor.getX();
        int oldY = toUse.cursor.getY();
        int newX=oldX;
        int newY=oldY;

        //check new x y then set
        //if up check if j-1 is >= 0 then set newJ = j-1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            if(oldX+1<toUse.getLength()&& inMovement(oldX+1, oldY)){
                newX++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            if(oldX-1>=0 && inMovement(oldX-1, oldY)){             
                newX--;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            if(oldY-1>=0 && inMovement(oldX, oldY-1)){
                newY--;
            }
            else{
                System.out.println("edge");
                return false;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            if(oldY+1<toUse.getLength() && inMovement(oldX, oldY+1)){
                newY++;
            }
            else{
                //on edge
                System.out.println("edge");
                return false;
            }
        }
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace"))
        {
            cursorState=1;
            toUse.movement = new ArrayList<moveTile>();
            newX=toUse.turnList.get(0).getX();
            newY=toUse.turnList.get(0).getY();
            state = 0;
        }
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Enter"))
        {

            //System.out.println("did action");
            if(toUse.grid[oldX][oldY].isOccupied)System.out.println("ACTION");
            toUse.movement = new ArrayList<moveTile>();
            newX=toUse.turnList.get(0).getX();
            newY=toUse.turnList.get(0).getY();
            cursorState=1;
            act = false;
            state = 0;
        }
        else{return false;}

        toUse.cursor.set(newX,newY);
        return true;
    }

    public void getMovement(int range, int beginX, int beginY, String p)
    {
        int x = beginX;
        int y = beginY;
        int moveRange = range;
        String path = p;
        char lastMove = 'q';
        if(path.length()!=0) lastMove = path.charAt(path.length()-1);
        if(moveRange>=0)
        {
            //System.out.println("in loop");
            //if(toUse.grid[x][y].isOccupied){}
            if(lastMove != 'd')getMovement(range-1, beginX,   beginY-1, path+ "u");
            if(lastMove != 'r')getMovement(range-1, beginX-1, beginY,   path+ "l");
            if(lastMove != 'l')getMovement(range-1, beginX+1, beginY,   path+ "r");
            if(lastMove != 'u')getMovement(range-1, beginX,   beginY+1, path+ "d");

            if(x<0 || x>=toUse.getLength() ||y<0 || y>=toUse.getLength() ){}//do nothing
            else
            {
                if(toUse.grid[x][y].isOccupied)
                {
                    if(toUse.grid[x][y].object.team == toUse.turnList.get(0).team)
                    {
                        boolean contains = false;
                        for(int k = 0; k<toUse.moveThrough.size(); k++)
                        {   
                            if(toUse.moveThrough.get(k).same(x,y))contains=true;
                        }

                        if(contains==false)
                        {
                            toUse.moveThrough.add(new moveTile(x,y,path));
                        }

                    }
                }
                else
                {
                    boolean contains = false;
                    for(int k = 0; k<toUse.movement.size(); k++)
                    {
                        if(toUse.movement.get(k).same(x,y))contains=true;
                    }

                    if(contains==false)
                    {
                        toUse.movement.add(new moveTile(x,y,path));
                    }
                }
            }
        }
    }

    public void getActionRange(int range, int beginX, int beginY, String p)
    {
        int x = beginX;
        int y = beginY;
        int moveRange = range;
        String path = p;
        char lastMove = 'q';
        if(path.length()!=0) lastMove = path.charAt(path.length()-1);
        if(moveRange>=0)
        {
            //System.out.println("in loop");
            //if(toUse.grid[x][y].isOccupied){}
            if(lastMove != 'd')getActionRange(range-1, beginX,   beginY-1, path+ "u");
            if(lastMove != 'r')getActionRange(range-1, beginX-1, beginY,   path+ "l");
            if(lastMove != 'l')getActionRange(range-1, beginX+1, beginY,   path+ "r");
            if(lastMove != 'u')getActionRange(range-1, beginX,   beginY+1, path+ "d");

            if(x<0 || x>=toUse.getLength() ||y<0 || y>=toUse.getLength()){}//do nothing
            else
            {
                if(toUse.grid[x][y].isOccupied)
                {

                }

                boolean contains = false;
                for(int k = 0; k<toUse.movement.size(); k++)
                {
                    if(toUse.movement.get(k).same(x,y))contains=true;
                }
                if(contains==false)
                {
                    toUse.movement.add(new moveTile(x,y,path));
                }

            }
        }
    }

    public boolean inMovement(int x, int y)
    {
        boolean contains = false;
        for(int k = 0; k<toUse.movement.size(); k++)
        {
            if(toUse.movement.get(k).same(x,y))contains=true;
            else{}
        }
        return contains;
    }

    public boolean inMoveThrough(int x, int y)
    {
        boolean contains = false;
        for(int k = 0; k<toUse.moveThrough.size(); k++)
        {
            if(toUse.moveThrough.get(k).same(x,y))contains=true;
            else{}
        }
        return contains;
    }
}
