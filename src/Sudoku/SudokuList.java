package Sudoku;

import java.util.ArrayList;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 * 
 * This class stores the entire data of a Sudoku table.
 */
public class SudokuList {
    //Use a 2D array to store the numbers in the sudoku table.
    private SingleSpace[][] spaceList;
    private Level level;
    
    //Constructor 1 of this class.
    //Initializing the 2D array.
    //Set the default level to EASY.
    public SudokuList()
    {
        this.spaceList = new SingleSpace[9][9];
        this.level = level.EASY;
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                spaceList[k][i] = new SingleSpace();
                spaceList[k][i].setModifiable(true);
            }
        }       
    }
    
    //Constructor 2 of this class
    //Initializing the 2D array
    //Use the level parameter to set the value of Level
    public SudokuList(Level level)
    {
        this.spaceList = new SingleSpace[9][9];
        this.level = level;
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                spaceList[k][i] = new SingleSpace();
                spaceList[k][i].setModifiable(true);
            }
        }        
    }
    
    //Used to modify the value in a chosen grid
    public void modifyValue(int column,int row, int value, boolean modifiable)
    {
        if(column < 9 && column >= 0 && row >= 0 && row < 9 && value >= 0 && value < 10)
        {
            spaceList[column][row].setValue(value);
            spaceList[column][row].setModifiable(modifiable);
        }
        //If the index parameter is out of bound, it should not be processed
        else if(column > 9 || row > 9)
        {
            System.out.println("Your index is out of bound!");
        }
        //If the value is not between 0 and 9, it is not eligible in a sudoku game, 0 is to clear the data
        else if(value < 0 || value > 9)
        {
            System.out.println("The value you entered is not eligible!");
        }
    }
    
    //Used to return the 2Darray
    public SingleSpace[][] getList()
    {
        return this.spaceList;
    }
    
    public int getNumOfColumn()
    {
        int numOfColumn = 0;
        
        for(int k = 0; k < this.spaceList.length; k++)
        {
            numOfColumn++;
        }
        
        return numOfColumn;
    }
    
    public int getNumOfRow()
    {
        int numOfRow = 0;
        int numOfColumn = 0;
        
        for(int k = 0; k < this.spaceList.length; k++)
        {
            numOfColumn++;
            
           for(int i = 0; i < this.spaceList[k].length; i++)
            {
                numOfRow++;
            } 
        }
        
        numOfRow = numOfRow/numOfColumn;
        
        return numOfRow;
    }
    
    //Used to set for list
    public void setList(SingleSpace[][] spaceList)
    {
        this.spaceList = spaceList;
    }
    
    //Clear all the modifiable numbers in the 2Darray
    //It is supposed to be used when the user wants to clear all the entered inputs in the sudoku game    
    public void clear()
    {
        for(int k = 0; k < this.spaceList.length; k++)
        {
            for(int i = 0; i < this.spaceList[k].length; i++)
            {
                if(spaceList[k][i].getIsModifiable() == true)
                {
                    spaceList[k][i].RemoveData();
                }
            }
        }
    }   
}
