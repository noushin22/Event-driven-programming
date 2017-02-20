import java.util.Comparator;
/**
 * This class compares two Date212 objects, and helps the TreeMap to sort out the Dates. The class also implements 
 * Comparator. There is a compare method to compare Date212 objects.
 * 
 * @author Noushin Iqra
 *
 */
public class Date212Comparator implements Comparator <Date212> {
	
	/**
	 * Compare two Date212 objects, to see if one is bigger than the other
	 * @param date1
	 * 			a Date212 object
	 * @param date2
	 * 			a Date212 object
	 * @return 
	 * 			an integer value
	 */
	public int compare(Date212 date1, Date212 date2) {
		return date1.compareTo(date2);
	}//compare
	
}//Date212Comparator
