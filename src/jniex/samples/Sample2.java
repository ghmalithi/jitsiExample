package jniex.samples;


import java.io.*;
import java.util.*;
import java.util.logging.*;
import jniex.*;
import org.jitsi.impl.neomedia.imgstreaming.*;

/**
 *
 * @author malintha
 */
public class Sample2 
{
   /**
     * main method
     * 
     * 
     * Sample main method to get a full screenshot of a specific window by its id.
     * The captured image will be saved as a bmp file in project root folder(output.bmp)
     * 
     */
    public void run() 
    {
        
        System.out.println("\n****** Running Sample 2 *********\n");

        Scanner s=new Scanner(System.in);
        
        System.out.println("List of names of windows\n");       
        System.out.println("Window Id\tTitle");
        System.out.println("--------------------------------------------");
        
        ScreenCapture.printAvailableWindowNames(0);
       
        try 
        {
            Thread.sleep(500);
        } catch (InterruptedException ex) 
        {            
        }
               
        System.out.println("--------------------------------------------");       
        System.out.print("\nPlease enter the Window ID you want to take the screen shot :");       
        String id=s.next();
        id = id.startsWith("0x") ? id.substring(2) : id;
        int windowid=Integer.parseInt(id,16);
                
        WindowAttributes wattr=ScreenCapture.getWindowAttributes(0, windowid);      
        int width=wattr.getWidth();
        int height=wattr.getHeight();
              
        if(DesktopCaptureManager.printWindowToImage(windowid,0,0,width,height,"output.bmp"))
        {
            System.out.println("Print screen success.");
            
            ImageViewer mainFrame;
            try {
                mainFrame = new ImageViewer("output.bmp");
                mainFrame.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Sample1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println("Print screen failed.");
        }               
    }   
}
