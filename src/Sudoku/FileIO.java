package Sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Yinghua Zhou 17981371 
 * Group ID: 26
 * 
 * This is a class which handles the file I/O of the game data.
 */

public class FileIO {
    
    //This method is used to read the game data from the easyGameData.txt, which only stores easy level game data
    //This method returns an arrayList with the data transfered from the file
    public ArrayList<SudokuList> readEasyGameData(){
        BufferedReader br = null;
        ArrayList<SudokuList> easySudokuList = new ArrayList<>();
        
        try{
            br = new BufferedReader(new FileReader("easyGameData.txt"));
            
            //The total number of question will be stored in the first line of the file
            int totalQuestions = Integer.parseInt(br.readLine());
            
            for(int k = 0; k < totalQuestions; k++)
            {
                //Initialize a SudokuList class instance variable
                SudokuList aSudokuList = new SudokuList(Level.EASY);
                
                //Loop 81 times to scan entire sudoku table data
                for(int i = 0; i < aSudokuList.getNumOfColumn(); i++)
                {
                    for(int j = 0; j < aSudokuList.getNumOfRow(); j++)
                    {   
                        //In the file, the data is splitted by a space
                        String str[] = br.readLine().split(" ");
                        //In the file, The third number in each line is the value, if the value is 0, it means it needs user to input
                        if(str[2].equals("0"))
                        {
                            //In each line, the first number is the column id, the second number is the row id,
                            //and the third number is the value, if its 0, the modifiable will be set to true.
                            aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                    Integer.parseInt(str[2].trim()), true);
                        }
                        else
                        {
                            //Else the modifiable is set to false, as the numbers of the orginal question can not be modified.
                            aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                    Integer.parseInt(str[2].trim()), false);
                        }
                    }
                }
                
                //Once the loop finishes, the data of a sudoku table will be stored in the sudokuList instance variable
                //Add the instance variable into the arraylist.
                easySudokuList.add(aSudokuList);
            }                           
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }catch(IOException | NumberFormatException ex)
        {
            System.err.println(ex);
        }finally{
            try{
              if(br!=null)
              {
                  br.close();
              }
            }catch(IOException ex)
            {
                System.err.println(ex);
            }
        }

        return easySudokuList;
    }
    
    //This method is used to write game data into the easyGameData.txt, which only stores easy level game data
    //Passing an arraylist into this method, and transfer the data in the arraylist to the file based on the code below
    public void writeToEasyGameData(ArrayList<SudokuList> easySudokuList){
        PrintWriter pw = null;
        
        try{
            pw = new PrintWriter("easyGameData.txt");
            
            int totalQuestions = easySudokuList.size();
            pw.println(totalQuestions);
            
            for(int k = 0; k < totalQuestions; k++)
            {
                for(int i = 0; i < easySudokuList.get(k).getNumOfColumn(); i++)
                {
                    for(int j = 0; j < easySudokuList.get(k).getNumOfRow(); j++)
                    {
                        pw.println(i+" "+j+" "+easySudokuList.get(k).getList()[i][k].getValue());
                    }
                }
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }finally{
            if(pw!=null)
            {
                pw.close();
            }
        }
    }
    
    //This method is used to get the arrayList that storing the correct answers of the easy sudoku games
    //Returning an ArrayList that stores the correct answers of the easy level puzzles
    public ArrayList<SudokuList> readEasyGameAnswers(){
        BufferedReader br = null;
        ArrayList<SudokuList> easyAnswerList = new ArrayList<>();
        
        try{
            br = new BufferedReader(new FileReader("easyGameAnswers.txt"));
            
            int totalQuestions = Integer.parseInt(br.readLine());
            
            for(int k = 0; k < totalQuestions; k++)
            {
                SudokuList aSudokuList = new SudokuList(Level.EASY);
                
                for(int i = 0; i < aSudokuList.getNumOfColumn(); i++)
                {
                    for(int j = 0; j < aSudokuList.getNumOfRow(); j++)
                    {                        
                        String str[] = br.readLine().split(" ");

                        aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                Integer.parseInt(str[2].trim()), false);
                    }
                }
                
                easyAnswerList.add(aSudokuList);
            }                           
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }catch(IOException | NumberFormatException ex)
        {
            System.err.println(ex);
        }finally{
            try{
              if(br!=null)
              {
                  br.close();
              }
            }catch(IOException ex)
            {
                System.err.println(ex);
            }
        }

        return easyAnswerList;
    }
    
    //This method is used to read the game data from the mediumGameData.txt, which only stores medium level game data
    //This method returns an arrayList with the data transfered from the file
    public ArrayList<SudokuList> readMediumGameData(){
        BufferedReader br = null;
        ArrayList<SudokuList> mediumSudokuList = new ArrayList<>();
        
        try{
            br = new BufferedReader(new FileReader("mediumGameData.txt"));
            
            int totalQuestions = Integer.parseInt(br.readLine());
            
            for(int k = 0; k < totalQuestions; k++)
            {
                SudokuList aSudokuList = new SudokuList(Level.MEDIUM);
                
                for(int i = 0; i < aSudokuList.getNumOfColumn(); i++)
                {
                    for(int j = 0; j < aSudokuList.getNumOfRow(); j++)
                    {                        
                        String str[] = br.readLine().split(" ");
                        if(str[2].equals("0"))
                        {
                            aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                    Integer.parseInt(str[2].trim()), true);
                        }
                        else
                        {
                            aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                    Integer.parseInt(str[2].trim()), false);
                        }
                    }
                }
                
                mediumSudokuList.add(aSudokuList);
            }                           
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }catch(IOException | NumberFormatException ex)
        {
            System.err.println(ex);
        }finally{
            try{
              if(br!=null)
              {
                  br.close();
              }
            }catch(IOException ex)
            {
                System.err.println(ex);
            }
        }

        return mediumSudokuList;
    }
    
    //This method is used to write game data into the mediumGameData.txt, which only stores medium level game data
    //Passing an arraylist into this method, and transfer the data in the arraylist to the file based on the code below
    public void writeToMidiumGameData(ArrayList<SudokuList> mediumSudokuList){
        PrintWriter pw = null;
        
        try{
            pw = new PrintWriter("mediumGameData.txt");
            
            int totalQuestions = mediumSudokuList.size();
            pw.println(totalQuestions);
            
            for(int k = 0; k < totalQuestions; k++)
            {
                for(int i = 0; i < mediumSudokuList.get(k).getNumOfColumn(); i++)
                {
                    for(int j = 0; j < mediumSudokuList.get(k).getNumOfRow(); j++)
                    {
                        pw.println(i+" "+j+" "+mediumSudokuList.get(k).getList()[i][k].getValue());
                    }
                }
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }finally{
            if(pw!=null)
            {
                pw.close();
            }
        }
    }
    
    //This method is used to get the arrayList that storing the correct answers of the medium level sudoku games
    //Returning an ArrayList that stores the correct answers of the medium level puzzles
    public ArrayList<SudokuList> readMediumGameAnswers(){
        BufferedReader br = null;
        ArrayList<SudokuList> mediumAnswerList = new ArrayList<>();
        
        try{
            br = new BufferedReader(new FileReader("mediumGameAnswers.txt"));
            
            int totalQuestions = Integer.parseInt(br.readLine());
            
            for(int k = 0; k < totalQuestions; k++)
            {
                SudokuList aSudokuList = new SudokuList(Level.MEDIUM);
                
                for(int i = 0; i < aSudokuList.getNumOfColumn(); i++)
                {
                    for(int j = 0; j < aSudokuList.getNumOfRow(); j++)
                    {                        
                        String str[] = br.readLine().split(" ");

                        aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                Integer.parseInt(str[2].trim()), false);
                    }
                }
                
                mediumAnswerList.add(aSudokuList);
            }                           
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }catch(IOException | NumberFormatException ex)
        {
            System.err.println(ex);
        }finally{
            try{
              if(br!=null)
              {
                  br.close();
              }
            }catch(IOException ex)
            {
                System.err.println(ex);
            }
        }

        return mediumAnswerList;
    }    
    
    //This method is used to read the game data from the hardGameData.txt, which only stores hard level game data
    //This method returns an arrayList with the data transfered from the file
    public ArrayList<SudokuList> readHardGameData(){
        BufferedReader br = null;
        ArrayList<SudokuList> hardSudokuList = new ArrayList<>();
        
        try{
            br = new BufferedReader(new FileReader("hardGameData.txt"));
            
            int totalQuestions = Integer.parseInt(br.readLine());
            
            for(int k = 0; k < totalQuestions; k++)
            {
                SudokuList aSudokuList = new SudokuList(Level.HARD);
                
                for(int i = 0; i < aSudokuList.getNumOfColumn(); i++)
                {
                    for(int j = 0; j < aSudokuList.getNumOfRow(); j++)
                    {                        
                        String str[] = br.readLine().split(" ");
                        if(str[2].equals("0"))
                        {
                            aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                    Integer.parseInt(str[2].trim()), true);
                        }
                        else
                        {
                            aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                    Integer.parseInt(str[2].trim()), false);
                        }
                    }
                }
                
                hardSudokuList.add(aSudokuList);
            }                           
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }catch(IOException | NumberFormatException ex)
        {
            System.err.println(ex);
        }finally{
            try{
              if(br!=null)
              {
                  br.close();
              }
            }catch(IOException ex)
            {
                System.err.println(ex);
            }
        }

        return hardSudokuList;
    }
    
    //This method is used to write game data into the hardGameData.txt, which only stores hard level game data
    //Passing an arraylist into this method, and transfer the data in the arraylist to the file based on the code below
    public void writeToHardGameData(ArrayList<SudokuList> hardSudokuList){
        PrintWriter pw = null;
        
        try{
            pw = new PrintWriter("hardGameData.txt");
            
            int totalQuestions = hardSudokuList.size();
            pw.println(totalQuestions);
            
            for(int k = 0; k < totalQuestions; k++)
            {
                for(int i = 0; i < hardSudokuList.get(k).getNumOfColumn(); i++)
                {
                    for(int j = 0; j < hardSudokuList.get(k).getNumOfRow(); j++)
                    {
                        pw.println(i+" "+j+" "+hardSudokuList.get(k).getList()[i][k].getValue());
                    }
                }
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }finally{
            if(pw!=null)
            {
                pw.close();
            }
        }
    }
 
    //This method is used to get the arrayList that storing the correct answers of the hard sudoku games
    //Returning an ArrayList that stores the correct answers of the hard level puzzles
    public ArrayList<SudokuList> readHardGameAnswers(){
        BufferedReader br = null;
        ArrayList<SudokuList> hardAnswerList = new ArrayList<>();
        
        try{
            br = new BufferedReader(new FileReader("hardGameAnswers.txt"));
            
            int totalQuestions = Integer.parseInt(br.readLine());
            
            for(int k = 0; k < totalQuestions; k++)
            {
                SudokuList aSudokuList = new SudokuList(Level.HARD);
                
                for(int i = 0; i < aSudokuList.getNumOfColumn(); i++)
                {
                    for(int j = 0; j < aSudokuList.getNumOfRow(); j++)
                    {                        
                        String str[] = br.readLine().split(" ");

                        aSudokuList.modifyValue(Integer.parseInt(str[0].trim()),Integer.parseInt(str[1].trim()),
                                Integer.parseInt(str[2].trim()), false);
                    }
                }
                
                hardAnswerList.add(aSudokuList);
            }                           
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }catch(IOException | NumberFormatException ex)
        {
            System.err.println(ex);
        }finally{
            try{
              if(br!=null)
              {
                  br.close();
              }
            }catch(IOException ex)
            {
                System.err.println(ex);
            }
        }

        return hardAnswerList;
    }    
    
    //This method is used to read user information from users.txt
    //Returning an arrayList which stores pieces info of the users
    public ArrayList<UserInfo> readUserInfo(){
        ArrayList<UserInfo> userArrayList = new ArrayList<>();
        ArrayList<UserInfo> sortedUserArrayList = new ArrayList<>();
        BufferedReader br = null;
        
        try{
            br = new BufferedReader(new FileReader("users.txt"));
            String line = null;
            
            while((line=br.readLine())!=null)
            {
                String str[] = line.split(" ");
                userArrayList.add(new UserInfo(str[0], Integer.parseInt(str[1].trim())));
            }
            
            UserInfo[] sortedUsers = new UserInfo[userArrayList.size()];
            for(int n = 0; n < userArrayList.size(); n++)
            {
                sortedUsers[n] = userArrayList.get(n);
            }
           
            //Bubble Sort
            //Sort the users based on their number of puzzles solved
            //Thus, when the file is read, it will be sorted and stored in the arrayList.
            boolean sorted = false;
            UserInfo tempUser = null;    
            while(!sorted)
            {
                sorted = true;
                for(int i = 0; i < sortedUsers.length - 1; i++)
                {
                    if(sortedUsers[i].getScore() > sortedUsers[i+1].getScore())
                    {
                        tempUser = sortedUsers[i];
                        sortedUsers[i] = sortedUsers[i+1];
                        sortedUsers[i+1] = tempUser;
                        sorted = false;
                    }
                }
            }
            
            //Assign the data into the sorted arrayList, from most to less.
            for(int k = sortedUsers.length - 1; k >= 0; k--)
            {
                sortedUserArrayList.add(sortedUsers[k]);
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find the file!");
        }
        catch(IOException ex){
            System.err.println(ex);
        }finally{
            if(br!=null){
                try{
                    br.close();
                }catch(IOException ex){
                    System.err.println(ex);
                    }
            }
        }
        
        return sortedUserArrayList;
    }
    
    //This method is used to write data into the users.txt
    //Store the entire data of the users in an arraylist, and then transfer them into the file
    public void writeToUserInfoFile(ArrayList<UserInfo> users){
        PrintWriter pw = null;
        
        try{
            pw = new PrintWriter("users.txt");

            for(int k = 0; k < users.size(); k++)
            {
                pw.println(users.get(k).getName()+" "+users.get(k).getScore());
            }

        }catch(FileNotFoundException ex){
            System.err.println("Cannot find the file!");
        }finally{
            if(pw!=null){
                pw.close();
            }
        }
    }
}
