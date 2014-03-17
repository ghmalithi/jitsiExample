/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jniex;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jitsi.impl.neomedia.imgstreaming.ScreenCapture;

/**
 *
 * @author malintha
 */
public class JitsiScreenCaptureExample {

    
    private static BufferedImage createRGBImage(byte[] bytes, int width, int height) {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
    }
    

    
    public static boolean printRootScreenToImage(int x,int y,int width,int height,String imagename){
        
        byte[] output=new byte[width*height*4];
        boolean b= ScreenCapture.grabScreen(0, x, y, width, height, output);
        
        if(b){
        byte[] rgb = new byte[(output.length / 4) * 3];

        int index = rgb.length - 1;

        for (int i = output.length - 1; i >= 0; i -= 4) {
          rgb[index--] = output[i];
          rgb[index--] = output[i - 1];
          rgb[index--] = output[i - 2];
        }
        
          OutputStream stream;
        
        try {
            BufferedImage image =createRGBImage(rgb,width,height);            
            stream = new FileOutputStream(imagename);
            ImageIO.write(image, "BMP", stream);
            stream.close();
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(JitsiScreenCaptureExample.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        }else{
            return false;
        }
    }
    
    
    public static void main(String[] args) {

        
        if(printRootScreenToImage(100,50,300,300,"abc.bmp")){
            System.out.println("Print screen success.");
        }else{
            System.out.println("Print screen failed.");
        }
        
        System.out.println("\nList of names of windows :");
        
        ScreenCapture.printAvailableWindowNames(0);
        
        
        
    }
    
    
    
}
