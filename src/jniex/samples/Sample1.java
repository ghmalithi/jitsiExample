
package jniex.samples;

import java.io.*;
import jniex.*;
import java.util.*;
import java.util.logging.*;
import org.jitsi.impl.neomedia.imgstreaming.*;

/**
 *
 * @author malintha
 */
public class Sample1 
{
  
    /**
     * main method
     * 
     * 
    * Sample main method to get a screenshot of a specific window by its id
    * specifing width and height. The captured image will be saved as a bmp file
    * in project root folder(output.bmp)
    */
    public void run() 
    {

        System.out.println("\n****** Running Sample 1 *********\n");
        
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
        
        System.out.print("Width :");
        int width=s.nextInt();
        System.out.print("Height :");
        int height=s.nextInt();
        
        
        id = id.startsWith("0x") ? id.substring(2) : id;
              
        if(DesktopCaptureManager.printWindowToImage(Integer.parseInt(id,16),0,0,width,height,"output.bmp"))
        {
            System.out.println("Print screen success.");
            
            ImageViewer mainFrame;
            try {
                mainFrame = new ImageViewer("output.bmp");
                mainFrame.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Sample1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        }else
        {
            System.out.println("Print screen failed.");
        }               
    }   
}