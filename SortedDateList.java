/**
 * This class extends the DateList class for a sorted date list. The class contains a no-argument constructor to 
 * initialize the class. There is a add method that calls the insert method from the DateList class to sort out the dates 
 * while adding them to the list. 
 * 
 * @author Noushin Iqra
 *
 */
public class SortedDateList extends DateList{
	
	public SortedDateList() {
		super();
	}//SortedDateList constructor
	
	/**
	 * Add a Date212 element in a sorted order to the list
	 * @param date
	 * 		the Date212 element to be inserted
	 */
	public void add(Date212 date) {
		super.insert(date);
		} // add method
}// SortedDateList
