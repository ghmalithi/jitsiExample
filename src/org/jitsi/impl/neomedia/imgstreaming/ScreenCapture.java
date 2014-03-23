/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.jitsi.impl.neomedia.imgstreaming;

//import org.jitsi.util.*;

/**
 * This class uses native code to capture desktop screen.
 *
 * It should work for Windows, Mac OS X and X11-based Unix such as Linux
 * and FreeBSD.
 *
 * @author Sebastien Vincent
 */
public class ScreenCapture
{
   // private static final Logger logger = Logger.getLogger(ScreenCapture.class);

    static
    {
        String lib = "jnscreencapture";

        try
        {
            System.loadLibrary(lib);
        }
        catch (Throwable t)
        {
            System.out.println("Failed to load native library " + lib + ": "
                        + t.getMessage());                  
            throw new RuntimeException(t);
        }
    }

    /**
     * Grab desktop screen and get raw bytes.
     *
     * @param display index of display
     * @param x x position to start capture
     * @param y y position to start capture
     * @param width capture width
     * @param height capture height
     * @param output output buffer to store screen bytes
     * @return true if grab success, false otherwise
     */
    public static native boolean grabScreen(
            int display,
            int x, int y, int width, int height,
            byte output[]);

    /**
     * Grab desktop screen and get raw bytes.
     *
     * @param display index of display
     * @param x x position to start capture
     * @param y y position to start capture
     * @param width capture width
     * @param height capture height
     * @param output native output buffer to store screen bytes
     * @param outputLength native output length
     * @return true if grab success, false otherwise
     */
    public static native boolean grabScreen(
            int display,
            int x, int y, int width, int height,
            long output, int outputLength);
    
    
    
    /**
     * Prints the window names containing in root screen.
     *
     * @param display index of display
     * @return true if printing list success, false otherwise
     */
    public static native boolean printAvailableWindowNames(
            int display);
    
    
    public static native boolean grabWindow(
            int display,int window,
            int x, int y, int width, int height,
            byte output[]);
    
}