import javax.swing.*;
/**
 * This class creates a JFrame with given title and size from the user. 
 * There is one createFileMenu method that sets up MenuBar in the JFrame.
 *  
 * @author Noushin Iqra
 */
public class DateGUI extends JFrame {
	
	private static final long serialVersionUID = -8278689604886927704L;

	/**
	 * initialize a GUI window with given title and size including a MenuBar
	 * and MenuItems, when the 3-argument DateGUI constructor is called. 
	 * @param title
	 * 		title of the JFrame
	 * @param height
	 * 			height of the GUI window
	 * @param width
	 * 			width of the GUI window
	 */
	public DateGUI(String title, int height, int width) {  
		
		// create and setup the GUI window
		setTitle(title); 
		setSize(height,width);
		setLocation(500,150);
		createFileMenu(); // create a menu bar and menu items
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	} //DateGUI constructor
	
	/**
	 * create a menu called file with "Open" option to select an input file 
	 * and "Quit" option to terminate the GUI.
	 */
	private void createFileMenu() {
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this); // include the JFrame/GUI in the FileMenuHandler
		
		item = new JMenuItem("Open");
		item.addActionListener(fmh); 
		fileMenu.add(item);
		
		fileMenu.addSeparator();
		
		item = new JMenuItem("Quit"); 
		item.addActionListener(fmh);
		fileMenu.add(item);
		
		setJMenuBar(menuBar);
		menuBar.add(fileMenu); //add the JMenu "File" to the MenuBar in the JFrame
	}// createFileMenu
	
} // DateGUI
