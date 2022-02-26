package Sudoku;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID 26
 * 
 * This class is being used when Help function is called
 */
public class Help {
    public void printHelp(CurrentStatus cs)
    {
        //Contents being printed while in NAME_PROMPT mode
        if(cs == CurrentStatus.NAME_PROMPT)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("You have been asked to input your name;)");
            System.out.println("You can input anything you want as your name except 'Help'.");
            System.out.println("If the name is already existed, you will be asked if you want to continue the game with the name.");
            System.out.println("--------------------------------------------------------------");
        }
        //Contents being printed while in CHOOSING_LEVEL mode
        else if(cs == CurrentStatus.LEVEL_SELECT)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("You have been asked to choose the level of the game you want to play.");
            System.out.println("There are only three options you can choose:| EASY | MEDIUM | HARD |.");
            System.out.println("To select the level of the game you want to play, simply input the level into the console.");
            System.out.println("Good Luck!");
            System.out.println("--------------------------------------------------------------");
        }
        //Contents being printed while in IN_GAME mode
        else if(cs == CurrentStatus.IN_GAME)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("There are 7 options you may choose to input: ");
            System.out.println("[FILL]: Fill in the blank space with input.");
            System.out.println("        Once you have input [FILL] command, you will be asked to select which grid you want to fill in.");
            System.out.println("        Simply type the column ID and row ID into the console; eg: Aa.");
            System.out.println("        And then you will be asked to input the number you want to fill into the grid.");
            System.out.println("        You may use [FILL] to change the number in the table directly based on the entered grid ID");
            System.out.println("[REMOVE]: Remove the value you filled into the selected grid.");
            System.out.println("          Once you have input [REMOVE] command, You will be asked which number of the grid you want to remove.");
            System.out.println("          Simply type the column ID and row ID into the console; eg: Aa.");
            System.out.println("          The number in the grid you have selected will be removed.");
            System.out.println("[CLEAR]: Clear all the filled grid.");
            System.out.println("         Once you have input [CLEAR] command, all the numbers you have entered will be removed.");
            System.out.println("         You will be asked to ensure if you want to clear the values you entered in the puzzle.");
            System.out.println("         If you select 'yes', then all the numbers you entered will be clear.");
            System.out.println("         Otherwise if you enter 'no', you will go back to the previous step.");
            System.out.println("[QUIT]: You will quit the game.");
            System.out.println("        Once you have input [QUIT] command, you will be asked to ensure if you want to quit the game.");
            System.out.println("        If you select 'yes', it will discard the game and terminate the program.");
            System.out.println("        Otherwise if you enter 'no', you will go back to the game.");
            System.out.println("[CHANGE]: Change game level or just the puzzle with the same level based on your input.");
            System.out.println("          You will be asked to select if you want to change game level or either just the puzzle");
            System.out.println("          Once you enter this command, you cannot go back to your previous game.");
            System.out.println("[CHECK]: Check how you are doing so far.");
            System.out.println("         If the number you entered is wrong, the wrong grid will turn red.");
            System.out.println("         Else if the number you entered is correct, nothing will change.");
            System.out.println("[RANKING]: Showing user current ranking.");
            System.out.println("           It is ranked based on the puzzles completed by the users.");
            System.out.println("           If the user completes an easy level puzzle, it will add 2 credits to the user's score.");
            System.out.println("           If the user completes a medium level puzzle, it will add 3 credits to the user's score.");
            System.out.println("           If the user completes a hard level puzzle, it will add 4 credits to the user's score.");
            System.out.println("--------------------------------------------------------------");
        }
        //Contents being printed while in QUITING mode
        else if(cs == CurrentStatus.QUITING)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("If you select 'yes', you will be considered as you want to quit the game.");
            System.out.println("And it will discard the game and terminate the program.");
            System.out.println("If you select 'no', you will go back and continue the game.");
            System.out.println("--------------------------------------------------------------");
        }
    }
}
