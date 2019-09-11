/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.scanner;

/**
 *
 * @author shan4
 */
public class ReadFile {


   private scanner x;
    
    public void openfile() {
    try{
        FileReader fr = new FileReader ("TransactionDetails.txt");
        BufferedReader br = new BufferedReader (fr);
        
        String str;
        
        
    while ((str = br.readLine()) != null){
       //This will print out the Transaction Details Line by Line
           System.out.println(str+"\n");
           
           }
    br.close();
           }
    
    catch (Exception e){
        
           System.out.println("Error");
  
    }
  }
}
