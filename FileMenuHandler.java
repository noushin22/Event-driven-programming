import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.*;
/**
 * This class handles the Menu tasks based on the chosen menu item. The class contains one instance variable: a pointer to the JFrame.
 * There is a 1-argument constructor that takes a JFrame and assigns it to the instance variable. A actionPerformed method implementing from the ActionListener
 * class to assign different tasks to each menu item: if "Open" is chosen, it allows the user to choose a text file 
 * for listed dates, if "Quit" is chosen, it terminates the GUI window. An openDateFile method that allows to open a text file of dates or quit the GUI, and a
 * readDateFile method that reads the text file, the dates are read and sorted, then both the unsorted and sorted lists are printed in the GUI, while the invalid dates are
 * printed to the console.
 * 
 * @author Noushin Iqra
 *
 */
public class FileMenuHandler implements ActionListener{

	private DateGUI frame;		
	public FileMenuHandler(DateGUI jf) {
		frame = jf;
	}//FileMenuHandler constructor
	
		/**
		 * Open a text file or quit the GUI based on the instruction given by the user.
		 * 
		 */
		public void actionPerformed(ActionEvent event) {
			String menuName = event.getActionCommand(); //get the menu item chosen 
		
			if (menuName.equals("Open"))
				openDateFile(); 
			else if (menuName.equals("Quit"))
				System.exit(0); // terminate GUI
		
		} //actionPerformed
	
			/**
			 * Allow to open a file and then read the file for valid dates
			 * 
			 */
			private void openDateFile() {
				JFileChooser c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.FILES_ONLY);
				c.showOpenDialog(null);
				File f = c.getSelectedFile();
				readDateFile(f); 
			}
	
				/**
				 * Read the text file, sort the dates, and store both unsorted and sorted dates in DateLists class, print both
				 * lists in the GUI and the invalid dates to the console.
				 * @param chosenFile
				 * 			a File that was chosen by the user
				 */
				private void readDateFile(File chosenFile) {
					String fileName = chosenFile.getName();
					// open the file and read a line
					TextFileInput myFile = new TextFileInput(fileName);
					String line;
					
					Container myContentPane = frame.getContentPane();
					frame.setLayout(new GridLayout(1,2));
					JTextArea unsortedDate = new JTextArea();
					JTextArea sortedDate = new JTextArea();
		
					// add the TextAreas to the myContentPane Container
					myContentPane.add(unsortedDate); 
					myContentPane.add(sortedDate); 
		
					unsortedDate.setText("Unsorted: \n\n"); //set the title of the unsorted TextArea as "Unsorted"
					sortedDate.setText("Sorted: \n\n");//set the title of the sorted TextArea as "Sorted"
		
					line = myFile.readLine();
					
					// Declare an unsortedDateList and a TreeMap to store the unsorted and sorted dates
					UnsortedDateList unsorted = new UnsortedDateList();
					TreeMap <Date212,String> sortDate = new TreeMap<>(new Date212Comparator());

					StringTokenizer myTokens;
		
		while(line!=null) {
			// create a new StringTokenizer to pass the string with the delimeter (",")
			myTokens = new StringTokenizer(line,",");
				while(myTokens.hasMoreTokens()) {
					String stringHolder = myTokens.nextToken();//place myTokens in a string variable
					try{
						//Date212 a = new Date212(stringHolder); //place the valid date that was read from the "line" in a new Date212 object 
						unsorted.add(new Date212(stringHolder)); // add the new date at the end of the unsorted list
						sortDate.put(new Date212(stringHolder),stringHolder); // add the new date in the sorted list in a sorted order	
					}// check for any exceptions in dates
				
					//catch and print the invalid dates to the console
					catch (IllegalDate212Exception ide) {
						ide = new IllegalDate212Exception(stringHolder);
						System.out.println(stringHolder+"<-- Not a valid date.");
					}//IllegalDate212Exception
					catch (NumberFormatException nfe) {
						System.out.println(stringHolder+"<-- Not a valid date.");
					}//NumberFormatException
					catch (IndexOutOfBoundsException ioobe) {
						System.out.println(stringHolder+"<-- Index out of bound.");
					}//IndexOutOfBoundsException
					
					
				}// separate the strings that are in a single line and place the valid ones in both unsorted and sorted lists	
				
				line = myFile.readLine(); // go to a new line
		}//while loop: read inputs from the text file until line is null
		
		//add the UnsortedDateList to the TextAreas
		unsortedDate.append(unsorted.toString());
		
		Set<Entry<Date212, String>> set = sortDate.entrySet(); //get the collection of Date212/input pairs
        Iterator<Entry<Date212, String>> i = set.iterator();	
        Map.Entry<Date212,String> date;		//return pair of the input and its corresponding string
        
        	while (i.hasNext()) {
        		date = (Map.Entry<Date212,String>) i.next();
			    sortedDate.append(date.getKey().toString()); 
			} // while there is still entries left, get the Date212 object from the pair and 
        	  //add it to the sorted TextArea
				
					//display the window and fit all the contents in the JFrame
					frame.setVisible(true);
				}//readDateFile
				
}//FileMenuHandler
