

package org.jitsi.impl.neomedia.imgstreaming;

/**Class that holds attributes of a Window
 *
 * @author malintha
 */
public class WindowAttributes 
{
    
    private final int id;
    private String name;
    private int width;
    private int height;

    public WindowAttributes(int id) {
        this.id = id;
    }
    
    public WindowAttributes(int id,int width) {
        this.id = id;
        this.width = width;
    }
    
    public WindowAttributes(int id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public WindowAttributes(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    
        
}
