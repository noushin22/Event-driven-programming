/**
 * The purpose of the DateList class is to create a list of dates stored in nodes.
 * This class uses three instance variables: 
 * a pointer to the first node, a pointer to the last node, and length, to 
 * indicate the number of item in the list. 
 * One no-argument constructor to initialize a DateList object with first and last nodes pointing 
 * to a dummy node, and length is zero.
 * An append method to add a new date to the list and an insert method 
 * to sort and then add a date new date to the list.
 * A get method to get the length of a DateList object and an toString method to
 * organize the list of dates in order of mm/dd/yyyy.
 * 
 * @author Noushin Iqra
 */
public abstract class DateList {

	// instance variables
	private DateNode first;
	private DateNode last;
	private int length; 
	
	// initialize a DateList object with first and last nodes pointing to a dummy node and length = 0
	public DateList() {
		first = new DateNode(null); // first node pointing to a dummy node "null"
		last = first; 
		length = 0;
	}// DateList constructor
	
	/** 
	 * Append a new Date212 data (date) element at the end of a DateList 
	 * @param date : the Date212 element to be added
	 */
	public void append(Date212 date) {
		DateNode x = new DateNode(date); // store the Date212 element inside a node
		last.next = x; // add the node to the end of the list
		last = x; // set the last node as x
		length++; // increment list size
	} // append method
	
	/** 
	 * Get the length of the list
	 * @return the number of elements in the list
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Insert a Date212 element in the sorted order to the list
	 * @param date
	 * 		the Date212 element to be inserted
	 */
	public void insert(Date212 date) {
		DateNode x = new DateNode(date);
		
		// two nodes pointing to first node and the next node
		DateNode a = first; 
		DateNode b = first.next;
		while(b!=null && x.data.compareTo(b.data)>0 ) {
			a = a.next;
			b = b.next;	
			} // if the data in current node is more than the data in node be, move a and b to point to the corresponding nodes 
		
		// set the new node x in between a and b
		a.next = x;
		x.next = b;
			if(b == null) { 
				last = x;
			} // if x goes at the end of the list set the last node as the x
		length++; // increment list size
		} // insert method

	/**
	 * Organize the date in mm/dd/yyyy form 
	 * @return 
	 * 		returns the list of the dates in a bulk 
	 */
	 public String toString() {
		DateNode p = first.next; // declare a node pointing to the node next to the first node
		// declare m and d strings to store month and day strings
		String m;
		String d;
		String returnString = ""; // declare an empty string
		while(p != null) {
			if(p.data.getMonth() < 10) {
				m = "0" + p.data.getMonth();
			} // get month from the Date212 data, if month is less than 10, place '0' before the month number
			else 
				m = "" + p.data.getMonth();
			if(p.data.getDay() < 10) {
				d = "0" + p.data.getDay();
			} // get day from the Date212 data, if day is less than 10, place '0' before the day number
			else 
				d = "" + p.data.getDay();
			
			returnString += (m + "/" + d + "/" + p.data.getYear()) +"\n"; // keep adding to string in mm/dd/yyyy form in a bulk
			p = p.next; // go to the next node
		} // keep adding strings until node is null
		return returnString;
	} // toString method
}// DateList
