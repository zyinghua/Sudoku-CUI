package Sudoku;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 * 
 * This class is to store the user profile(Initialize an user).
 */
public class UserInfo {
    private String name;
    private int score;
   
    //Constructor 1, with parameter name only, used to record new user
    public UserInfo(String name)
    {
        this.name = name;
        this.score = 0;
    }
    
    //Constructor 2, has 2 parameters taken.
    public UserInfo(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
    
    //Returning the name of the user
    public String getName()
    {
        return this.name;
    }
    
    //Returning how many puzzles the user solved
    public int getScore()
    {
        return this.score;
    }
    
    //Set puzzle solved
    public void setScore(int score)
    {
        this.score= score;
    }
    
    //If the user solves an easy level puzzle, add 2 to the user's score.
    //If the user solves a medium level puzzle, add 3 to the user's score.
    //If the user solves a hard level puzzle, add 4 to the user's score.
    public void addScore(Level level)
    {
        if(level == Level.EASY)
        {
            this.score +=2;
        }
        else if(level == Level.MEDIUM)
        {
            this.score += 3;
        }
        else if(level == Level.HARD)
        {
            this.score +=4;
        }
    }
}
