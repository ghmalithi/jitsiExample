

package jniex;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author malintha
 */
public class ImageViewer extends JFrame
{
	private	JScrollPane scrollPane;

	public ImageViewer(String filename) throws IOException
	{
		setTitle( "Viewing Image" );
		setSize( 800, 600 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

                Image image = ImageIO.read(new File(filename));
		JLabel label = new JLabel(new ImageIcon(image) );

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add( label );
		topPanel.add( scrollPane, BorderLayout.CENTER );
	}

}
