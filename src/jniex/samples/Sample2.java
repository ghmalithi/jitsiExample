/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jniex.samples;

import org.jitsi.impl.neomedia.imgstreaming.ScreenCapture;
import org.jitsi.impl.neomedia.imgstreaming.WindowAttributes;

/**Not implemented yet
 *
 * @author malintha
 */
public class Sample2 
{
        
    public static void main(String[] args) 
    {
        
        WindowAttributes wattr=ScreenCapture.getWindowAttributes(0, 2230);
        System.out.println(wattr.getId() + " " + wattr.getWidth() + " " + wattr.getHeight());
        
    }
}
