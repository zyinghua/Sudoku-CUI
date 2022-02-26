package Sudoku;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 * 
 * This class is to prompt the user for input and handle the user commands.
 */
public class GameProcess {
    private Level level;
    private boolean gameInProgress;
    private final Scanner scan;
    private final Random generator;
    private final FileIO fileIO;
    private ArrayList<UserInfo> userInfoList;
    private final Help help;
    private UserInfo currentUser;
    private boolean inGame;
    private final PrintSudoku ps;
    
    //Construtor, initializing the instance variables.
    public GameProcess()
    {
        this.gameInProgress = true;
        scan = new Scanner(System.in);
        this.generator = new Random();
        this.fileIO = new FileIO();
        this.userInfoList = new ArrayList<>();
        this.help = new Help();
        this.ps = new PrintSudoku();
    }
    
    //This method is used to execute the game.
    public void startGame()
    {
        this.PreExcution();
        this.play();
    }
    
    //This method handles the most executions.
    public void play()
    {
        while(gameInProgress)
        {
            //Initialize two SudokuList instance variables, one is used to store user answers
            //And the other one is to store the correct answers.
            SudokuList userList;
            SudokuList answerList;
            ArrayList<SudokuList> gameList = new ArrayList<>();
            ArrayList<SudokuList> gameAnswerList = new ArrayList<>();
            
            //Scan from different files based on the level value.
            switch(level)
            {
                case EASY:
                    gameList = this.fileIO.readEasyGameData();
                    gameAnswerList = this.fileIO.readEasyGameAnswers();
                    break;
                case MEDIUM:
                    gameList = this.fileIO.readMediumGameData();
                    gameAnswerList = this.fileIO.readMediumGameAnswers();
                    break;
                case HARD:
                    gameList = this.fileIO.readHardGameData();
                    gameAnswerList = this.fileIO.readHardGameAnswers();
                    break;
            }    
            
            //Randomly generate a sudoku puzzle from the file
            int totalNumOfT = gameList.size();
            int sudokuNum = generator.nextInt(totalNumOfT);            
            userList = gameList.get(sudokuNum);
            answerList = gameAnswerList.get(sudokuNum);
            
            inGame = true;
            String input = "";
            int number = 0;
            int column = 0;
            int row = 0;
            System.out.println("Your game has been created! Gook luck and have fun!");
            
            while(inGame)
            {
                this.ps.printSudoku(userList);
                
                try{
                    System.out.println(">> Input [HELP] to see more information ");
                    System.out.print(">> ");
                    input = scan.next();
                }catch(NumberFormatException e)
                {
                    System.err.println("Number Format Exception occur");
                }catch(InputMismatchException e)
                {
                    System.err.println(e);
                }
                
                if(input.equalsIgnoreCase("Fill"))
                {
                    boolean done = false;
                    
                    while(!done)
                    {
                        System.out.println("Which grid do you want to fill in ?");
                        System.out.print(">> ");
                        input= scan.next();
                        char columnChar = input.charAt(0);
                        char rowChar = input.charAt(1);

                        if((!(columnChar >= 'A'))||(!(columnChar <= 'I'))||(!(rowChar >= 'a'))||(!(rowChar <= 'i')))
                        {
                            System.out.println("Your input is not eligible, please try again~");
                        }
                        else
                        {
                            switch(columnChar)
                            {
                                case 'A':
                                    column = 0;
                                    break;
                                case 'B':
                                    column = 1;
                                    break;
                                case 'C':
                                    column = 2;
                                    break;
                                case 'D':
                                    column = 3;
                                    break;
                                case 'E':
                                    column = 4;
                                    break;
                                case 'F':
                                    column = 5;
                                    break;
                                case 'G':
                                    column = 6;
                                    break;
                                case 'H':
                                    column = 7;
                                    break;
                                case 'I':
                                    column = 8;
                                    break;
                            }

                            switch(rowChar)
                            {
                                case 'a':
                                    row = 0;
                                    break;
                                case 'b':
                                    row = 1;
                                    break;
                                case 'c':
                                    row = 2;
                                    break;
                                case 'd':
                                    row = 3;
                                    break;
                                case 'e':
                                    row = 4;
                                    break;
                                case 'f':
                                    row = 5;
                                    break;
                                case 'g':
                                    row = 6;
                                    break;
                                case 'h':
                                    row = 7;
                                    break;
                                case 'i':
                                    row = 8;
                                    break;
                            }
                            
                            done = true;
                        }
                    }

                    done = false;
                    while(!done)
                    {
                        try
                        {
                            System.out.println("Please input the number you want to fill into the grid: ");
                            System.out.print(">> ");
                            number = scan.nextInt();

                            if(number > 0 && number < 10)
                            {
                                userList = this.fill(column, row, number, userList);
                                //User changed the value in the grid, so it may not be incorrect.
                                //In another purpose, set the text colour back to black.
                                userList.getList()[column][row].setIsIncorrect(false);
                                
                                done = true;
                            }
                            else
                            {
                                System.out.println("The number you entered is not eligible in the sudoku game, please try again~");
                            }     
                        }catch(NumberFormatException e)
                        {
                            System.out.println("Number Format Exception occur! Command excution cancelled.");
                            done = true;
                        }catch(InputMismatchException e)
                        {
                            System.out.println("Your input does not match! Command excution cancelled.");
                            //Here I use scan.next() to prevent an unknown command being scanned in
                            scan.next();
                            done = true;
                        }    
                    }
                }
                else if(input.equalsIgnoreCase("Remove"))
                {
                    boolean done = false;
                    
                    while(!done)
                    {
                        System.out.println("Which grid of number do you want to remove ?");
                        System.out.print(">> ");
                        input= scan.next();
                        char columnChar = input.charAt(0);
                        char rowChar = input.charAt(1);

                        if((!(columnChar >= 'A'))||(!(columnChar <= 'I'))||(!(rowChar >= 'a'))||(!(rowChar <= 'i')))
                        {
                            System.out.println("Your input is not eligible, please try again~");
                        }
                        else
                        {
                            switch(columnChar)
                            {
                                case 'A':
                                    column = 0;
                                    break;
                                case 'B':
                                    column = 1;
                                    break;
                                case 'C':
                                    column = 2;
                                    break;
                                case 'D':
                                    column = 3;
                                    break;
                                case 'E':
                                    column = 4;
                                    break;
                                case 'F':
                                    column = 5;
                                    break;
                                case 'G':
                                    column = 6;
                                    break;
                                case 'H':
                                    column = 7;
                                    break;
                                case 'I':
                                    column = 8;
                                    break;
                            }

                            switch(rowChar)
                            {
                                case 'a':
                                    row = 0;
                                    break;
                                case 'b':
                                    row = 1;
                                    break;
                                case 'c':
                                    row = 2;
                                    break;
                                case 'd':
                                    row = 3;
                                    break;
                                case 'e':
                                    row = 4;
                                    break;
                                case 'f':
                                    row = 5;
                                    break;
                                case 'g':
                                    row = 6;
                                    break;
                                case 'h':
                                    row = 7;
                                    break;
                                case 'i':
                                    row = 8;
                                    break;
                            }
                            
                            done = true;
                        }
                    }
                    
                    done = false;
                    while(!done)
                    {
                        try
                        {
                            System.out.println("Are you sure you want to remove this number?(Yes/No) ");
                            System.out.print(">> ");
                            input = scan.next();

                            if(input.equalsIgnoreCase("yes"))
                            {
                                userList = this.removeNumber(column, row, number, userList);
                                userList.getList()[column][row].setIsIncorrect(false);
                                
                                done = true;
                            }
                            else if(input.equalsIgnoreCase("no"))
                            {
                                done = true;
                            }
                            else 
                            {
                                System.out.println("Your input is not accepted~ You can only input [Yes] or [No] in this section, please try again~");
                            }
                            
                        }catch(NumberFormatException e)
                        {
                            System.out.println("Number Format Exception occur! Command excution cancelled.");
                            done = true;
                        }catch(InputMismatchException e)
                        {
                            System.out.println("Your input does not match! Command excution cancelled.");
                            done = true;
                        }
                    }
                }
                else if(input.equalsIgnoreCase("Help"))
                {
                    this.help.printHelp(CurrentStatus.IN_GAME);
                }
                else if(input.equalsIgnoreCase("Clear"))
                {
                    System.out.println("Are you sure to clear the puzzle?(Yes/No) ");
                    System.out.println("[It will clear all the numbers you entered]");
                    
                    boolean done = false;
                    while(!done)
                    {
                        System.out.print(">> ");
                        input = scan.next();
                        
                        if(input.equalsIgnoreCase("Yes"))
                        {
                            for(int k = 0; k < userList.getList().length; k++)
                            {
                                for (SingleSpace grid : userList.getList()[k]) {
                                    if (grid.getIsModifiable() == true) {
                                        grid.RemoveData();
                                    }
                                }    
                            }
                            done = true;
                        }
                        else if(input.equalsIgnoreCase("No"))
                        {
                            done = true;
                        }
                        else 
                        {
                            System.out.println("Your input is not accepted~ You can only input [Yes] or [No] in this section, please try again~");
                        }
                    }     
                }
                else if(input.equalsIgnoreCase("Quit"))
                {
                    boolean done = false;

                    while(!done)
                    {
                        System.out.println("Are you sure to quit the game?(Yes/No) ");
                        System.out.print(">> ");
                        input = scan.next();
                        
                        if(input.equalsIgnoreCase("Yes"))
                        {
                            inGame = false;
                            gameInProgress = false;
                            done = true;
                        }
                        else if(input.equalsIgnoreCase("No"))
                        {
                            done = true;
                        }
                        else if(input.equalsIgnoreCase("Help"))
                        {
                            this.help.printHelp(CurrentStatus.QUITING);
                        }
                        else 
                        {
                            System.out.println("Your input is not accepted~ You can only input [Yes] or [No] in this section, or [Help] for more info;");
                            System.out.println("please try again~");
                        }
                    }
                }
                else if(input.equalsIgnoreCase("Ranking"))
                {
                    System.out.println("User current ranking: ");
                    
                    for(int k = 1; k < this.userInfoList.size()+1; k++)
                    {
                        System.out.println(k+". ["+this.userInfoList.get(k-1).getName()+"] - Score: "+this.userInfoList.get(k-1).getScore());
                    }
                }
                else if(input.equalsIgnoreCase("Check"))
                {
                    CheckUserAnswer check = new CheckUserAnswer();
                    check.checkAnswer(userList, answerList);
                }
                else if(input.equalsIgnoreCase("Change"))
                {
                    boolean done = false;
                    int choice;
                    System.out.println("Would you want to change current level or puzzle? ");
                    System.out.println("[Enter 1 to change level:Enter 2 to change puzzle:Enter 3 to cancel this command]");
                    
                    while(!done)
                    {
                        try{
                            System.out.print(">> ");
                            choice = scan.nextInt();

                            if(choice == 1)
                            {
                                inGame = false;
                                this.levelSelect();
                                
                                done = true;
                            }
                            else if(choice == 2)
                            {
                                inGame = false;
                                
                                boolean finish = false;
                                while(!finish)
                                {
                                    int changedSudokuNum = generator.nextInt(totalNumOfT); 
                                    if(changedSudokuNum != sudokuNum)
                                    {
                                        userList = gameList.get(changedSudokuNum);
                                        finish = true;
                                    }
                                }
                                
                                System.out.println("Your puzzle has been changed~ Good luck and have fun!");
                                done = true;
                            }
                            else if(choice == 3)
                            {
                                done = true;
                            }
                            else
                            {
                                System.out.println("Your input does not match! Please try again~");
                            }
                        }catch(InputMismatchException ex)
                        {
                            System.out.println("Your input does not match! Command excution cancelled.");
                            //Here, scan.next() to prevent an unknown command being scanned in
                            scan.next();
                            done = true;
                        }  
                    }
                }
                else
                {
                    System.out.println("Your input is not accepted! Please try again~");
                }
                
                int totalNumOfCorrectAnswer = this.getTotalNumOfCorrectAnswer(userList, answerList);
                
                //Once puzzle has been solved(All numbers from the userList are the same as the numbers in the answerList).
                if(totalNumOfCorrectAnswer == 81)
                {
                    System.out.println("Congratuations! You have solved this puzzle!");
                    for(int k = 0; k < userInfoList.size(); k++)
                    {
                        if(userInfoList.get(k).getName().equalsIgnoreCase(currentUser.getName()))
                        {
                            userInfoList.get(k).addScore(this.level);
                            this.fileIO.writeToUserInfoFile(userInfoList);
                        }
                    } 
                    
                    inGame = false;
                    System.out.println("Do you want to start another puzzle?(Yes/No) ");
                    
                    boolean done = false;
                    while(!done)
                    {
                        System.out.print(">> ");
                        input = scan.next();
                        
                        //If the user choose to start another puzzle, call play() again(Method Recursion).
                        if(input.equalsIgnoreCase("Yes"))
                        {
                            this.levelSelect();
                            this.play();
                            done = true;
                        }
                        //Else quit the game.
                        else if(input.equalsIgnoreCase("No"))
                        {
                            System.out.println("Enjoy your day! Hope to see you again~");
                            gameInProgress = false;
                            done = true;
                        }
                        else
                        {
                            System.out.println("Your input is not accepted! Please try again~");
                        }
                    }  
                } 
            }  
        }   
    }
    
    //This method is used to prompt user for name.
    public void namePrompt()
    {
        boolean done = false;
        String name = "";

        while(!done)
        {
            try{
                System.out.println("Please input your name: ");
                System.out.print(">> ");
                name = scan.next();
            }catch(InputMismatchException e)
            {
                System.out.println("Your input is not eligible, Please try again!");
            }
            
            if(name.equalsIgnoreCase("help"))
            {
                this.help.printHelp(CurrentStatus.NAME_PROMPT);
            }
            else
            {
                done = true;
            }
        }

        currentUser = new UserInfo(name);
        boolean registeredUser = false;
        
        //Scan if the name is already in the file
        for(int k = 0; k < this.userInfoList.size(); k++)
        {
            if(name.equalsIgnoreCase(this.userInfoList.get(k).getName()))
            {
                currentUser = this.userInfoList.get(k);
                registeredUser = true;
            }
        }
        
        //If the user has already registered.
        if(registeredUser)
        {
            System.out.println("Hi~ "+currentUser.getName()+"! Welcome back!");
            System.out.println("Your current score is: "+currentUser.getScore());
            
            //Ask the user if he/she wants to continue as the current name
            System.out.println("Do you want to continue as "+currentUser.getName()+"?(Yes/No) ");
            boolean finish = false;
            
            while(!finish)
            {
                System.out.print(">> ");
                String input = scan.next();
                
                if(input.equalsIgnoreCase("Yes"))
                {
                    finish = true;
                }
                //If no, prompt the user for name again.
                else if(input.equalsIgnoreCase("No"))
                {
                    finish = true;
                    this.namePrompt();
                }
                else
                {
                    System.out.println("Your input is not accepted! Please try again~");
                }
            }
            
        }
        else
        {
            System.out.println("Hi~ "+currentUser.getName()+"! Welcome to the game!");
            
            this.userInfoList.add(currentUser);
            this.fileIO.writeToUserInfoFile(userInfoList);
        }
    }
    
    //This method is to prompt the user to select a game level to process the game.
    public void levelSelect()
    {
        System.out.println("-----------------------------------");
        boolean done = false;
        
        while(!done)
        {
            System.out.println("Please select a game level to play~");
            System.out.println("| EASY | MEDIUM | HARD |");
            System.out.print(">> ");
            String input = scan.next();
            
            if(input.equalsIgnoreCase("easy"))
            {
                this.level = Level.EASY;
                done = true;
            }
            else if(input.equalsIgnoreCase("medium"))
            {
                this.level = Level.MEDIUM;
                done = true;
            }
            else if(input.equalsIgnoreCase("hard"))
            {
                this.level = Level.HARD;
                done = true;
            }
            else if(input.equalsIgnoreCase("help"))
            {
                help.printHelp(CurrentStatus.LEVEL_SELECT);
            }
            else
            {
                System.out.println("Your input is wrong, please try again~");
            }
        }
    }
    
    //This method is to fill a number into a selected grid.
    public SudokuList fill(int column, int row, int number, SudokuList userList)
    {
        if(userList.getList()[column][row].getIsModifiable() == true)
        {
            userList.getList()[column][row].setValue(number);
        }
        else
        {
            System.out.println("This grid is not modifiable!");
        }
        
        return userList;
    }
    
    //This method is to remove the number into a selected grid.
    public SudokuList removeNumber(int column, int row, int number, SudokuList userList)
    {
        if(userList.getList()[column][row].getIsModifiable() == true)
        {
            userList.getList()[column][row].RemoveData();
        }
        else
        {
            System.out.println("This grid is not modifiable!");
        }
        
        return userList;
    }
    
    public int getTotalNumOfCorrectAnswer(SudokuList userList, SudokuList answerList)
    {
        int totalNumOfCorrectAnswer = 0;
                
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                if(userList.getList()[k][i].getValue() == answerList.getList()[k][i].getValue())
                {
                    totalNumOfCorrectAnswer++;
                }
            }
        }
        
        return totalNumOfCorrectAnswer;
    }
   
    public void PreExcution()
    {
        this.userInfoList = this.fileIO.readUserInfo();
        System.out.println("Hello~ Player! Welcome to the sudoku game!");
        this.namePrompt();
        this.levelSelect();
    }
}
