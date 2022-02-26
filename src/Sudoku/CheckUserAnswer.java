package Sudoku;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID 26
 */

//This class is used to check if the number entered by the user is correct
public class CheckUserAnswer {
    
    //The status of (isIncorrect) in the SingleSpace Class will change only if the user excutes this method,
    //and the number entered by the user in the grid is different from the answer.
    public void checkAnswer(SudokuList userList, SudokuList answerList)
    {        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                if(userList.getList()[k][i].getValue() != 0)
                {
                    //Check if the user entered numbers are same as the correct answer
                    if(userList.getList()[k][i].getValue() != answerList.getList()[k][i].getValue())
                    {
                        userList.getList()[k][i].setIsIncorrect(true);
                    }
                } 
            }
        }
    }
}
