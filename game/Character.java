import java.util.*;
/**
 * This class is for a character on the level. 
 * 
 * @author (John Remmes) 
 * @version (a version number or a date)
 */
public class Character extends Interactable implements Comparable<Character>
{
    // instance variables 
    private int range; //movement
    public Item[] inventory;
    //public Action[] moveList = {new Action("Dance"),new Action("Attack"), new Action("Heal"), new Action ("Fireball")};
    public int speed;
    public int time;
    public StatusEffect[] status;
    public Job activeJob;
    public Job passiveJob;
    public ArrayList<Job> jobList = new ArrayList<Job>();
    public Item[] lootList;//for enemies
    
    //current stats at normal conditions
    public int strength;
    public int intelligence;
    public int dexterity;
    public int defense;
    public int charisma;
    public int magicResistance;
    
    //Current values after status effect
    public int Tstrength;
    public int Tintelligence;
    public int Tdexterity;
    public int Tdefense;
    public int Tcharisma;
    public int TmagicResistance;
    
    
    //may have to make an active movelist also
    /**
     * Constructor for objects of class character
     */
    public Character()
    {
        // initialise instance variables
        Random generator = new Random();
        range = 0;
        //moveList[0].range=0;
        speed = (int)(generator.nextGaussian()*15+45);
        maxHP = (int)(generator.nextGaussian()*5+80);
        currentHP = maxHP;
        time = 100 - speed;
        team = 0;
        status = new StatusEffect[10];
        jobList = initializeJobs();
        activeJob  = jobList.get(0);
        passiveJob = jobList.get(0);
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
        //moveList[0].range=0;
        speed = (int)(generator.nextGaussian()*15+45);
        maxHP = (int)(generator.nextGaussian()*5+80);
        currentHP = maxHP;
        time = 100 - speed;
        status = new StatusEffect[10];
        jobList = initializeJobs();
        activeJob  = jobList.get(0);
        passiveJob = jobList.get(0);
        //inventory[0]= new Item();
    }
    
    /**
     *  method used to determine order of characters based off of time for action  calendar
     *  
     *  @param other other Character to be compared
     *  @return resluts of comparison. if + greater, if - less, if 0 equal
     */
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
    
    /**
     * Temporary method used to create a job to test some functions of character in game
     */
    public ArrayList<Job> initializeJobs()
    {
        ArrayList<Job> toReturn = new ArrayList<Job>();
        Action[] actionList ={new Action("Attack",new int[]{1}, new int[]{-10},new int[]{0},1,0),
                              new Action("First Aid",new int[]{1},new int[]{5},new int[]{0},0,0),
                              new Action("Kill",new int[]{1},new int[]{-100},new int[]{0},1,0),
                              new Action("Arrow",new int[]{1},new int[]{-10},new int[]{0},7,0),
                              new Action("Dual Strike",new int[]{1,1},new int[]{-8,-8,},new int[]{0,0},1,0)}; //temporary only 2 for now
        
        int[]actionState = {0,0,0};
        int[]levelLim = {0, 25, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
        toReturn.add( new Job("Soldier",actionList, actionState, levelLim));
        return toReturn;
    }
    /**
     * incomplete method that will be used to update characters status and time
     */
    public void updateCharacter()
    {
        
        
        
    }
    
}
