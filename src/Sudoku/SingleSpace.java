package Sudoku;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID 26
 * 
 * This class stands for a single grid of the sudoku table
 */
public class SingleSpace {
        private int value;
        private boolean isModifiable;
        private boolean isIncorrect;
        
        //Constructor 1, set the default value to 0, which stands for "waiting for number to be assigned"
        public SingleSpace()
        {
            this.value = 0;
            this.isModifiable = true;
            this.isIncorrect = false;
        }
        
        //Constructor 2, set value with the value of the parameter
        public SingleSpace(int value)
        {
            this.value = value;
            this.isModifiable = true;
            this.isIncorrect = false;
        }

        public int getValue()
        {
            return this.value;
        }
        
        public void setValue(int value)
        {
            this.value = value;
        }
        
        //To get whether the number in the grid(space) is modifiable, 
        //it is to identify whether the number is from the original question.
        public boolean getIsModifiable()
        {
            return this.isModifiable;
        }
        
        public void setModifiable(boolean isModifiable)
        {
            this.isModifiable = isModifiable;
        }
        
        //Remove the number in the grid(space), set the value back to 0.
        public void RemoveData(){
            this.value = 0;
        }
        
        public boolean getIsIncorrect()
        {
            return this.isIncorrect;
        }
        
        public void setIsIncorrect(boolean isIncorrect)
        {
            this.isIncorrect = isIncorrect;
        }
}
