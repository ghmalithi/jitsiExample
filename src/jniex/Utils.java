
package jniex;

import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.*;

/**
 *
 * @author malintha
 */
public class Utils {
    
    /**
     * Creates an RGB <tt>BufferedImage</tt> from raw bytes.
     *
     * @param bytes raw bytes
     * @param width capture width
     * @param height capture height
     * @return created <tt>BufferedImage</tt>
     * 
     * <p>
     * I referred this code from 
     * http://stackoverflow.com/questions/18079754/convert-and-display-image-from-byte-array
     * </p>
     */
    public static BufferedImage createRGBImage(byte[] bytes, int width, int height) 
    {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
    }
    
    /**
     * Converts an ARGB <tt>byte[]</tt> array into RGB byte array.
     *
     * @param argbbytearray raw bytes
     * @return created RGB <tt>byte[]</tt> array
     * 
     */ 
    public static byte[] convertARGBtoRGB(byte[] argbbytearray){
        byte[] rgb = new byte[(argbbytearray.length / 4) * 3];

        int index = rgb.length - 1;

        for (int i = argbbytearray.length - 1; i >= 0; i -= 4) 
        {
          rgb[index--] = argbbytearray[i];
          rgb[index--] = argbbytearray[i - 1];
          rgb[index--] = argbbytearray[i - 2];
        }
        return rgb;
    }
    
   /**
     * Saves an RGB <tt>byte[]</tt> array as a BMP file.
     *
     * @param input raw RGB byte array
     * @param width width of the image
     * @param height height of the image
     * @param filename name of the file to save the image
     * 
     * @return <tt>true</tt> if success.
     * 
     */
    public static boolean saveRGBByteArrayAsBMP(byte[] input,int width,int height,String filename)
    {
        OutputStream stream;
        
        try 
        {
            BufferedImage image =createRGBImage(input,width,height);            
            stream = new FileOutputStream(filename);
            ImageIO.write(image, "BMP", stream);
            stream.close();
            return true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
