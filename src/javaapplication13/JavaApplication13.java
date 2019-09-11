
package javaapplication13;


import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import static java.lang.System.out;
import java.text.DateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author sean4
 */
public class JavaApplication13 {
    

    

public static void main (String[] args) throws IOException{
   // The Do Loop will do everything inside its brackets if the user Selects "y"
   // The users input will be assigned to the String answer
    String answer;
    do {
        System.out.println("The Current Logged Fuel Transactions are as follow: \n"
                + "\n Date, Litres of Fuel, Price Per Litre\n");
        
    
        // Calling the ReadFile Method to print the TransactionDetails.txt file to the console
        ReadFile r = new ReadFile ();
        r.openfile();
     
   
        // The Array of Fuel Transactions with a Max of 100 Entries
        String[] FuelTransaction = new String [100];
    
        // The Scanner will ask the the user for their input via keyboard
        Scanner scanner = new Scanner (System.in);
        //This code asks the user to input the transaction details for the car
        System.out.println("Enter the Date of the Fuel Transaction in dd/mm/yyyy Format:  ");
        String Date = scanner.nextLine();
        System.out.println("The Date you Entered is: " + Date);
       
        System.out.println("Enter the Number of Litres of Fuel Purchased: ");
        String litres = scanner.nextLine();
        System.out.println("You Purchased " + litres + " Litres of Fuel");
       
        System.out.println("Enter the Cost per Litre of Fuel:  £");
        String cost = scanner.nextLine();
        System.out.println("The Cost per Litre of Fuel was: £" + cost);
       
       
       
       
        // Once all details have been entered this message will appear
        System.out.println ("Records Updated Successfully, Would you like to Log another Fuel Transaction? " +
               " If so, Please Enter y");
        answer = scanner.nextLine();
       
     
       
      
       
       
        
        String filepath = ("TransactionDetails.txt");
       
       
        WriteTransaction(Date,litres,cost,filepath);
    }
    while (answer.equals("y"));
    }

   //This method returns the Date entered by the user to yyyymmdd format to facilitate date checking
public static void dateconverter (String Date) throws ParseException  {
    
      SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      Date theDate = df.parse(Date);
      SimpleDateFormat formater = new SimpleDateFormat ("yyyymmdd");
      String formatedDateAsString = formater.format(theDate);
    
   
      }
 

   // This method will write the details entered by the user to the TransactionDetails.txt File.
public static void WriteTransaction (String Date, String litres, String cost, String filepath) throws IOException
    
    {
    try
    {
        FileWriter fw = new FileWriter(filepath,true);
        BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter pw = new PrintWriter (bw);
        pw.println(Date+","+litres+","+cost);
        // This line will append the data given by the user to the TransactionDetails.txt file
        pw.flush();
        pw.close();
    
    
        JOptionPane.showMessageDialog(null, "Records Updated Sucessfully");
        // showing user transaction details have been added successfully
    }
    catch (Exception E)
    {
    
        JOptionPane.showMessageDialog(null, "Records Unable to Be Updated");
        // If try codeblock wasnt successful this message will appear
    }
  }
        
     
     
    }
