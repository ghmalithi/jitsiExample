/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jniex;

import org.jitsi.impl.neomedia.imgstreaming.*;

/**
 *
 * @author malintha
 */
public class DesktopManager {
      
    /**
     * Grab desktop screen and creates a bitmap file.
     *
     * @param x x position to start capture
     * @param y y position to start capture
     * @param width capture width
     * @param height capture height
     * @param imagename output filename to store the image
     * @return true if grab success, false otherwise
     */
    public static boolean printRootScreenToImage(int x,int y,int width,int height,String imagename)
    {
        
        byte[] output=new byte[width*height*4];
        boolean b= ScreenCapture.grabScreen(0, x, y, width, height, output);
        
        if(b)
        {
            byte[] rgb = Utils.convertARGBtoRGB(output);
            return Utils.saveRGBByteArrayAsBMP(rgb, width, height, imagename); 
        }    
        else
        {
            return false;
        }
    }   

      
    /**
    * Grab specific window and creates a bitmap file.
    *
    * @param window id of window to capture
    * @param x x position to start capture
    * @param y y position to start capture
    * @param width capture width
    * @param height capture height
    * @param imagename output filename to store the image
    * @return true if grab success, false otherwise
    */
    public static boolean printWindowToImage(int window,int x,int y,int width,int height,String imagename)
    {
        
        byte[] output=new byte[width*height*4];
        boolean b= ScreenCapture.grabWindow(0,window, x, y, width, height, output);
        
        if(b)
        {
            byte[] rgb = Utils.convertARGBtoRGB(output);
            return Utils.saveRGBByteArrayAsBMP(rgb, width, height, imagename);           
        }
        else
        {
            return false;
        }
    }
    
}
