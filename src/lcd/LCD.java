/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcd;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class LCD {
    /**     numberMatrix->is used for Modeling numbers in matrix format.
            The numbers inside of the matriz, represent a model to draw the numbers in LCD format.
            We have two patterns: Horizontal{0,1} and Vertical{-1,0,1};    **/
    
   int[][] numberMatrix ={{1,-1,0,-1,1},
                         {0,1,0,1,0},
                         {1,1,1,2,1},
                         {1,1,1,1,1},
                         {0,-1,1,1,0},
                         {1,2,1,1,1},
                         {1,2,1,-1,1},
                         {1,1,0,1,0},
                         {1,-1,1,-1,1},
                         {1,-1,1,1,1}};
   
   //Method to sort the input of the user
   public String[] sortInput (String userInput){
       //Create a second string eliminating the first position because is an empty space
       String String2 = userInput.substring(1,userInput.length());
       //Separate the string in every ',' and save each part in a list
       String[] ListofString = String2.replace(" ", ",").split(",");
       return ListofString;
       
   }
   //Method to create the numberMatrix but
   public int[][] sortNumberMatrix(String digits){
       //Create a temporal matrix-> Later we used it to save the List of numbers 
       int tempInt[][] = new int[digits.length()][5];
            //transform all the digits of the string to matrix digits 
            for (int i=0; i < digits.length(); i++){
             //Get each character of the string and change the type to INT
             int charInt = Character.getNumericValue(digits.charAt(i));
             //Add vector that represent a number into the matrix
             tempInt[i] = this.numberMatrix[charInt];                       
        }  
        return tempInt;
   }
   
   //Method to draw the horizontal pattern
   public void drawHorizontal(int typeValue, int size){
       //The next 2 lines, can repeat an String like (" " or "-") size times.
       String repeatString1 = new String(new char[size]).replace("\0", " ");
       String repeatString2 = new String(new char[size]).replace("\0", "-");
       //Verify the patterns: Horizontal{0,1};
       switch(typeValue) {                    
                    case 0 :
                        System.out.print(" " + repeatString1 + " "); 
                        System.out.print("   ");
                        break;  
                    case 1 :
                        System.out.print(" " + repeatString2 + " ");
                        System.out.print("   ");
                        break;           
                    default : 
                }
   }
   //Method to draw the vertical pattern
   public void drawVertical(int typeValue, int size){
       //The next 2 lines, can repeat an String (" " or "-") size times.
       String repeatString1 = new String(new char[size]).replace("\0", " ");
       //Verify the patterns: Vertical{-1,0,1};
       switch(typeValue) {
                        case 1 :                            
                            System.out.print(" " + repeatString1 + "|");
                            System.out.print("   ");
                            break; 
                        case -1 :
                            System.out.print("|" + repeatString1 + "|");
                            System.out.print("   ");
                            break; 
                        case 2 :
                            System.out.print("|" + repeatString1 + " ");
                            System.out.print("   ");
                            break; 
                        default : 
                        }
       
   }
   
   public void printLcdFormat(int[][] matrix, int size){
       //The size of vector allways is 5;
        for (int i = 0; i < 5 ; i++){
            //Verify is Vertical(i%2!=0) or Horizontal(i%2==0)
            if (i%2!=0){     
                //repeat size times, used to print the vertical lines
                for (int k = 0; k<size ; k++){                  
                    for( int j = 0; j < matrix.length; j++ ){
                        // depend of the size draw a vertical pattern
                        drawVertical(matrix[j][i], size);                
                        }
                    System.out.print("\n");
                    }
                }
            else{         
                for( int j = 0; j < matrix.length; j++ ){
                    //depend of the size draw a horizontal pattern                          
                    drawHorizontal(matrix[j][i], size);         
                    }
                System.out.print("\n");
                }
        }
   }
}

