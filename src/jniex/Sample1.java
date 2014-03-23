/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */

package jniex;

import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.imageio.*;
import org.jitsi.impl.neomedia.imgstreaming.*;

/**
 *
 * @author malintha
 */
public class Sample1 
{

    private static BufferedImage createRGBImage(byte[] bytes, int width, int height) 
    {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
    }
    

    
    public static boolean printRootScreenToImage(int x,int y,int width,int height,String imagename)
    {
        
        byte[] output=new byte[width*height*4];
        boolean b= ScreenCapture.grabScreen(0, x, y, width, height, output);
        
        if(b)
        {
            byte[] rgb = new byte[(output.length / 4) * 3];

            int index = rgb.length - 1;

            for (int i = output.length - 1; i >= 0; i -= 4) 
            {
              rgb[index--] = output[i];
              rgb[index--] = output[i - 1];
              rgb[index--] = output[i - 2];
            }

              OutputStream stream;

            try 
            {
                BufferedImage image =createRGBImage(rgb,width,height);            
                stream = new FileOutputStream(imagename);
                ImageIO.write(image, "BMP", stream);
                stream.close();
                return true;
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Sample1.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }
        else
        {
                return false;
        }
    }
    
    
    
     public static boolean printWindowToImage(int window,int x,int y,int width,int height,String imagename)
     {
        
        byte[] output=new byte[width*height*4];
        boolean b= ScreenCapture.grabWindow(0,window, x, y, width, height, output);
        
        
        
        if(b)
        {
            byte[] rgb = new byte[(output.length / 4) * 3];

            int index = rgb.length - 1;

            for (int i = output.length - 1; i >= 0; i -= 4) 
            {
              rgb[index--] = output[i];
              rgb[index--] = output[i - 1];
              rgb[index--] = output[i - 2];
            }

              OutputStream stream;

            try 
            {
                BufferedImage image =createRGBImage(rgb,width,height);            
                stream = new FileOutputStream(imagename);
                ImageIO.write(image, "BMP", stream);
                stream.close();
                return true;
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Sample1.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args) 
    {

        Scanner s=new Scanner(System.in);
        
        System.out.println("List of names of windows\n");
        
        System.out.println("Window Id\tTitle");
        System.out.println("--------------------------------------------");
        
        ScreenCapture.printAvailableWindowNames(0);

        System.out.println("--------------------------------------------");
        
        
        System.out.print("\nPlease enter the Window ID you want to take the screen shot :");       
        String id=s.next();
        
        System.out.print("Width :");
        int width=s.nextInt();
        System.out.print("Height :");
        int height=s.nextInt();
        
        
        id = id.startsWith("0x") ? id.substring(2) : id;
        
        
        
        if(printWindowToImage(Integer.parseInt(id,16),0,0,width,height,"output.bmp"))
        {
            System.out.println("Print screen success.");
        }else
        {
            System.out.println("Print screen failed.");
        }
        
        
        
    }
    
    
    
}