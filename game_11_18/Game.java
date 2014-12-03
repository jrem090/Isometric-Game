import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * The class that holds both the frame and the canvas
 * This class is responsible for maintaining and painting the window and implements the keyListener that
 * forwards the events to an instance of the ActionManager class
 * 
 * @author (John Remmes) 
 * @version (11/11/14)
 */
@SuppressWarnings("serial")
public class Game extends JPanel {
    static Level toUse;
    static ActionManager action;
    /**
     * Constructor for objects of class Game
     * creates an instance of KeyListener
     */
    public Game() {
        KeyListener listener = new KeyListener() 
            {
                @Override
                public void keyTyped(KeyEvent e) {
                    //System.out.println("test");
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
                    //if up right left down move
                    //toUse.movement = new ArrayList<moveTile>();
                    KeyEvent event = e;
                    action.reaction(event);
                    //action.moveWithObject(event,toUse.objects.get(0));
                    repaint();
                }
            };
        addKeyListener(listener);
        setFocusable(true);
    } 

    /**
     *  Main class for game. may move to seperate class later 
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        Game gameExample = new Game();
        int numTiles = 15;
        toUse = new Level(numTiles);
        toUse.createGrassland(4);
        action = new ActionManager(toUse);
        frame.add(new Game());
        frame.setFocusable(false);
        frame.setSize(1900, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * paint method for class
     * 
     * @param  g Graphics
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        //paint bg
        graphics.setPaint(Color.gray);
        g.fillRect(0,0, getWidth(), getHeight());

        paintGrid(g, graphics,toUse);

        drawMenus(g, graphics,toUse);
    }

    /**
     * This method paints the grid using the Level class and it's contents. also uses information from local instance of ActionManager Class 
     * 
     * @param  g Graphics
     * @param  graphics Graphics2D
     * @param  toUse Level
     */
    public void paintGrid(Graphics g, Graphics2D graphics, Level toUse)
    {
        Random generator = new Random();
        int width = 48*2;
        int height = width/2;

        int numTile = toUse.getLength();
        //Level toUse = new Level(numTiles);
        //toUse.randomInit(); //used to create a random gameboard. obsolote now use createGrassland

        //paint grid
        double tempset = numTile;
        int offset = (int)(tempset / 2);
        int centerX = getWidth()/2;
        int centerY = getHeight()/2 - height* offset ;

        //int centerY = 50;
        int depth = 25;//length/depth of a tile. how large is the bottom
        int depth2 = 0; //height of a tile in space

        //Color base = new Color(55,48,82); //notused since tiles now have color as a param.
        //Color top = new Color(75,87,129);

        int[]xPoints = {centerX, centerX + width/2, centerX +width/2, centerX, centerX -width/2, centerX -width/2}; //xpoints for top
        int[]yPoints = {centerY, centerY+height/2, centerY + height/2 + depth, centerY + height/2 + height/2 +depth, centerY +height/2 + depth, centerY+height/2};

        //iterate through grid drawing levels
        for(int i =0; i< toUse.getLength(); i++)
        {
            for (int j = 0; j < toUse.getWidth(); j++)
            {
                //depth2 = generator.nextInt(4)*5 -10; //generates a random height
                int[] newX = new int[6];
                int[] newY = new int[6];
                for(int k =0; k<6; k++)
                {
                    newX[k] = xPoints[k] + i * width/2 - j * width/2;
                    newY[k] = yPoints[k] + i * height/2  + j * height/2 + toUse.tileHeight(i,j);
                }
                //draw side/base
                graphics.setColor(toUse.getBase(i,j));
                g.fillPolygon(newX, newY, 6);

                //draw top
                graphics.setPaint(toUse.getTop(i,j));
                int[]lastX = {newX[0], newX[1], newX[3], newX[5]};
                int[]lastY = {newY[0], newY[1], newY[3]-depth, newY[5]};
                g.fillPolygon(lastX ,lastY, 4);

                for(int l = 0; l<toUse.movement.size();l++)
                {
                    if(toUse.movement.get(l).same(i,j))
                    {
                        graphics.setPaint(Color.yellow);
                        if(action.state==21)graphics.setPaint(Color.orange);
                        g.fillPolygon(lastX ,lastY, 4);
                    }
                }

                //draws grid
                graphics.setPaint(Color.black);
                g.drawPolygon(newX, newY, 6);
                //g.drawLine(newX[5],newY[5],newX[3],newY[3]-depth);
                //g.drawLine(newX[1],newY[1],newX[3],newY[3]-depth);

                //draw things
                if(i==toUse.cursor.getX() && j ==toUse.cursor.getY())
                {
                    graphics.setPaint(Color.red);
                    int[]tempX={lastX[0],lastX[1]-1,lastX[2],lastX[3]+1};
                    int[]tempY={lastY[0]+1, lastY[1], lastY[2]-1, lastY[3]};
                    int[]temp2X={lastX[0],lastX[1]-2,lastX[2],lastX[3]+2};
                    int[]temp2Y={lastY[0]+2, lastY[1], lastY[2]-2, lastY[3]};
                    g.drawPolygon(lastX ,lastY, 4);
                    g.drawPolygon(tempX ,tempY, 4);
                    g.drawPolygon(temp2X ,temp2Y, 4);
                    //System.out.println("here");
                }
                else
                {
                    graphics.setPaint(Color.black);
                    g.drawLine(newX[5],newY[5],newX[3],newY[3]-depth);
                    g.drawLine(newX[1],newY[1],newX[3],newY[3]-depth);
                }
                if(toUse.isOccupied(i,j))
                {
                    //color shadow
                    Color gray = Color.darkGray;
                    Color next = new Color(gray.getRed() , gray.getGreen(), gray.getBlue(),100);
                    graphics.setPaint(next);
                    g.fillOval(newX[5]+width/4,newY[0]+height/4,width/2,height/2);//shadow maybe learn how to transparent draw

                    //draw ball
                    graphics.setPaint(Color.blue);

                    if(toUse.grid[i][j].object.team ==1)graphics.setPaint(new Color(207,80,66));
                    g.fillOval(newX[5],newY[5]-width, width,width);
                    graphics.setPaint(Color.black);
                    g.drawOval(newX[5],newY[5]-width, width,width);
                }
            }
        }

    }

    /**
     * This method paints the menus using the Level class and it's contents. It also uses cues from ActionManagerClass
     * 
     * @param  g Graphics
     * @param  graphics Graphics2D
     * @param  toUse Level
     */
    public void drawMenus(Graphics g, Graphics2D graphics, Level toUse)
    {
        if(action.state!=2 && action.state!=21){
            graphics.setPaint(Color.white);
            g.fillRect(0,0,406,206);
            graphics.setPaint(new Color(23,54,128));
            g.fillRect(3,3,400,200);

            int fontSize = 200/3;
            g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            graphics.setPaint(Color.white);
            if(!action.move)graphics.setPaint(Color.darkGray);
            g.drawString("1. Move",5,fontSize);
            graphics.setPaint(Color.white);
            if(!action.act)graphics.setPaint(Color.darkGray);
            g.drawString("2. Action",5,2*fontSize);
            graphics.setPaint(Color.white);
            g.drawString("3. End Turn",5,3*fontSize);
        }
        else //action menu
        {
            graphics.setPaint(Color.white);
            g.fillRect(0,0,406,206);
            graphics.setPaint(new Color(23,54,128));
            g.fillRect(3,3,400,200);
            //getActive character
            Character active = toUse.turnList.get(0);
            for(int i = 0; i < active.moveList.length; i++)
            {
                int fontSize = 20;
                if(active.moveList.length<3)fontSize= 200/3;
                else fontSize = 200/(active.moveList.length);
                g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                graphics.setPaint(Color.white);
                g.drawString((i+1)+". " + active.moveList[i].name,5,(i+1)*fontSize);
            }
        }
    }

}