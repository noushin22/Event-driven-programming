/**
 * This class extends the DateList class for a unsorted date list. The class contains a no-argument constructor to 
 * initialize the class. There is a add method that calls the append method from the DateList class add the dates at the end 
 * of the list while while reading from the input file. 
 * 
 * @author Noushin Iqra
 *
 */
public class UnsortedDateList extends DateList{
	
	public UnsortedDateList() {
		super();
	}// UnsortedDateList constructor
	
	/** 
	 * Add a new Date212 data (date) element at the end of a DateList 
	 * @param date : the Date212 element to be added
	 */
	public void add(Date212 date) {
		super.append(date);
	} // add method
	
}// UnsortedDateList 
