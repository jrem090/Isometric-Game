import java.util.*;
/**
 * Write a description of class character here.
 * 
 * @author (John Remmes) 
 * @version (a version number or a date)
 */
public class Character extends Interactable implements Comparable<Character>
{
    // instance variables - replace the example below with your own
    private int range;
    public Item[] inventory;
    public Action[] moveList = {new Action("Dance"),new Action("Attack"), new Action("Heal"), new Action ("Fireball")};
    public int speed;
    public int time;
    public int maxHP;
    public int currentHP;
    public StatusEffect[] status;
    public Job activeJob;
    public Job passiveJob;
    public ArrayList<Job> jobList = new ArrayList<Job>();
    
    //may have to make an active movelist also
    /**
     * Constructor for objects of class character
     */
    public Character()
    {
        // initialise instance variables
        Random generator = new Random();
        range = 0;
        moveList[0].range=0;
        speed = (int)(generator.nextGaussian()*15+45);
        maxHP = (int)(generator.nextGaussian()*5+80);
        currentHP = maxHP;
        time = 100 - speed;
        team = 0;
        status = new StatusEffect[10];
        jobList = initializeJobs();
        //inventory[0]= new Item();
    }

    /**
     * Constructor for objects of class character
     */
    public Character(int side)
    {
        // initialise instance variables
        team = side;
        Random generator = new Random();
        range = 0;
        moveList[0].range=0;
        speed = (int)(generator.nextGaussian()*15+45);
        maxHP = (int)(generator.nextGaussian()*5+80);
        currentHP = maxHP;
        time = 100 - speed;
        //inventory[0]= new Item();
    }
    
    @Override
    public int compareTo(Character other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        Integer a = new Integer(this.time);
        Integer b = new Integer(other.time);
        int compare = a.compareTo(b);
        return compare;
    }

    public ArrayList<Job> initializeJobs()
    {
        ArrayList<Job> toReturn = new ArrayList<Job>();
        //Action[] actionList ={new Action("Attack"), }
        Job soldier = new Job();
        return toReturn;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return range + y;
    }
}
