package jniex;

import java.io.*;
import java.util.*;
import jniex.samples.*;

/**
 *
 * @author malintha
 */
public class Main {
   public static void main(String args[]) throws IOException{
       
       Scanner sc=new Scanner(System.in);
       
       System.out.println("**** Single Window Capturing Examples for Jitsi ****\n");
       
       System.out.println("Currently available samples:\n");
       System.out.println("1 : Takes a screenshot of a specific window by its id specifing width and height.");
       System.out.println("2 : Takes a full screenshot of a specific window by its id.");
       System.out.println("");
       
       System.out.print("Please enter the sample number to run : ");
       
       int i=sc.nextInt();
       
       switch(i){
           case 1:
               new Sample1().run();
               break;
           case 2:
               new Sample2().run();
               break;
               
           default:
               System.out.println("ERROR : Sample number is not available.");
       }
       
   }
}
