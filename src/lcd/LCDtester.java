/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcd;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class LCDtester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
         
         
         
         
         String comando;
         String listaString = "";
         String CADENA_FINAL = "0,0";
         try (Scanner lector = new Scanner(System.in)) {
             
             do
                {   
                    System.out.print("Entrada:");
                    comando = lector.next();
                    
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                        //Geting the data from user
                        listaString = listaString + " " + comando;
                       
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL));
             //Create the object type LCD   
             LCD pantallaLCD = new LCD();   
             //Sorting the data of the user in a List
             String input[]=pantallaLCD.sortInput(listaString);
             
            //Creating the matrix of each entry with the respective size and printing the numbers             
            for(int i=0; i < (input.length)-1; i=i+2){
               pantallaLCD.printLcdFormat(pantallaLCD.sortNumberMatrix(input[i+1]),Integer.parseInt(input[i]));
               }
            }
         catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }  
         
        }
             
    }
    

