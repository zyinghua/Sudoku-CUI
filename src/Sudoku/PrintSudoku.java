package Sudoku;

import java.util.ArrayList;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID 26
 */

//This class is to print the sudoku table.
public class PrintSudoku {
     
    //The list parameter is initialized by the game data
    public void printSudoku(SudokuList list)
    {
        System.out.println("   ||  a  |  b  |  c  ||  d  |  e  |  f  ||  g  |  h  |  i  ||");
        
        for(int k = 0; k < 9; k++)
        {
            if(k == 0 || k == 3 || k == 6)
            {
                System.out.println(" ============================================================="); 
            }
            else
            {
                System.out.println(" -------------------------------------------------------------");
            }

            if(k == 0)
            {
                System.out.print(" A ");
            }
            else if(k == 1)
            {
                System.out.print(" B ");
            }
            else if(k == 2)
            {
                System.out.print(" C ");
            }
            else if(k == 3)
            {
                System.out.print(" D ");
            }
            else if(k == 4)
            {
                System.out.print(" E ");
            }
            else if(k == 5)
            {
                System.out.print(" F ");
            }
            else if(k == 6)
            {
                System.out.print(" G ");
            }
            else if(k == 7)
            {
                System.out.print(" H ");
            }
            else if(k == 8)
            {
                System.out.print(" I ");
            }

            for(int i = 0; i < 9; i++)
            {
                if(i != 8)
                {
                    if(i == 0 || i == 3 || i == 6)
                    {
                        //To distinguish if the number is from the original question
                        if(list.getList()[k][i].getIsModifiable() != true)
                        {
                            // "\033[52;47m] will set the background to #Grey
                            // \033[0m will devide the background based on the value position(# Text Reset)
                            //Otherwise without \033[0m, the background seems to be connected together
                            System.out.printf("|| \033[52;47m %s \033[0m ", list.getList()[k][i].getValue()); 
                        }
                        else 
                        {
                            if(list.getList()[k][i].getValue() == 0)
                            {
                                System.out.print("||     ");
                            }
                            else
                            {
                                //The number will be red if the status of (isIncorrect) is true
                                if(list.getList()[k][i].getIsIncorrect())
                                {
                                    System.out.printf("|| \033[37;41m %s \033[0m ", list.getList()[k][i].getValue()); 
                                }
                                //If the number is correct, it will display normally.
                                else
                                {
                                    System.out.printf("|| \033[0;90m %s \033[0m ", list.getList()[k][i].getValue()); 
                                }  
                            }
                        } 
                    }
                    else
                    {
                        if(list.getList()[k][i].getIsModifiable() != true)
                        {
                            // "\033[52;47m] will set the background to #Grey
                            // \033[0m will devide the background based on the value position(# Text Reset)
                            //Otherwise without \033[0m, the background will be connected together
                            System.out.printf("| \033[52;47m %s \033[0m ", list.getList()[k][i].getValue()); 
                        }
                        else 
                        {
                            if(list.getList()[k][i].getValue() == 0)
                            {
                                System.out.print("|     ");
                            }
                            else
                            {
                                //The number will be red if the status of (isIncorrect) is true
                                if(list.getList()[k][i].getIsIncorrect())
                                {
                                    System.out.printf("| \033[37;41m %s \033[0m ", list.getList()[k][i].getValue()); 
                                }
                                //If the number is correct, it will display normally.
                                else
                                {
                                    System.out.printf("| \033[0;90m %s \033[0m ", list.getList()[k][i].getValue()); 
                                } 
                            }
                        } 
                    }
                }
                else
                {
                    if(list.getList()[k][i].getIsModifiable() != true)
                    {
                        System.out.printf("| \033[52;47m %s \033[0m ||\n", list.getList()[k][i].getValue()); 
                    }
                    else
                    {
                        if(list.getList()[k][i].getValue() == 0)
                        {
                            System.out.println("|     ||");
                        }
                        else
                        {
                            if(list.getList()[k][i].getIsIncorrect())
                            {
                                System.out.printf("| \033[37;41m %s \033[0m ||\n", list.getList()[k][i].getValue()); 
                            }
                            else
                            {
                                System.out.printf("| \033[0;90m %s \033[0m ||\n", list.getList()[k][i].getValue());    
                            }
                             
                        }
                    }
                } 
            }
        }
        
        System.out.println(" =============================================================");
    }

/*   
    //Test method
    public static void main(String[] args)
    {
        FileIO io = new FileIO();
         
        ArrayList<SudokuList> list = new ArrayList<SudokuList>();
         
        list = io.readEasyGameData();
         
        PrintSudoku ps = new PrintSudoku();
         
        ps.printSudoku(list.get(0)); 
    }
*/  
}
