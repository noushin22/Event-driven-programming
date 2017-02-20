/**
 * This class takes a String date and separates it in month, day, and year. This class contains three instance
 * variables: a pointer to day, a pointer to month, and a pointer to year. There is a 1-argument constructor that takes the date 
 * as a string and calls another 3-argument constructor in which it breaks the string into parts and parse them to integer
 * for the month, day, and year values. The 3-argument constructor checks the validity of the integers and stores them
 * in the month, day, year instance variables accordingly. There are 3 get methods for month, day, and year. A compareTo method 
 * to compare to Date212 object, and a toString method to place the date in mm/dd/yyyy form. 
 * 
 * @author Noushin Iqra
 */
public class Date212 {

	// instance variables 
	private int day;
	private int month;
	private int year;
	
	// take 3 integer values, check their validity and place them in the month, day, year variables accordingly
	public Date212(int y, int m, int d) {
		if(m>12||m<=0)
			throw new IllegalArgumentException("Not a valid month"); // if month is more than 12 or <= 0 throw a IllegalArgumentException
		if(d>31||d<=0)
			throw new IllegalArgumentException("Not a valid day");// if day is more than 31 or <= 0 throw a IllegalArgumentException
		if(y>2016)
			throw new IllegalArgumentException("Not a valid year");// if year is more than 2016 throw a IllegalArgumentException
		
		// if the integers are valid place them in the instance variables
		month = m;
		day = d;
		year = y;
	}// 3-argument Date212 constructor
	
	// take the date string and call the 3-argument constructor to parse them to integer for the month, day, and year values.
	public Date212(String date) {
	
		// break the string using substring and parse them to integer
		this(Integer.parseInt(date.substring(0,4)), 
				Integer.parseInt(date.substring(4,6)),
					Integer.parseInt(date.substring(6)));
		
	}// 1-argument Date212 constructor
	
	/**
	 * Get the month value
	 * @return
	 * 		the value of the month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Get the day value
	 * @return
	 * 		the value of the day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Get the value of the year 
	 * @return
	 * 		the value of the year
	 */
	public int getYear() {
		return year;
	} 

	/**
	 * Compare two Date212 objects, to see if one is bigger than the other.
	 * @param other
	 * 			: the Date212 object to compare to
	 * @return
	 * 		an integer value
	 */
	public int compareTo(Date212 other) {
		int time = year - other.year; // compare the years from both Date212 objects
		if(time==0) {
			time = month - other.month; // if the years are the same compare the months
			if(time==0) {
				time = day - other.day; // if months are the same compare the days
			}
		}
		return time; // return the value of the difference in time
	} // compareTo method
	
	/**
	 * Organize the date in mm/dd/yyyy form 
	 * @return 
	 * 		returns the date in mm/dd/yyyy form
	 */
	public String toString() {
		// declare m and d strings to store month and day strings
		String m;
		String d;
		String returnString = ""; // declare an empty string
			if(month < 10) {
				m = "0" + month;
			}// if month is less than 10, place '0' before the month number
			else 
				m = "" + month;
			if(day < 10) {
				d = "0" + day;
			}// if day is less than 10, place '0' before the day number
			else 
				d = "" + day;	
			returnString = (m + "/" + d + "/" + year + "\n"); // add date to the string in mm/dd/yyyy form
		return returnString;
	}// toString method
	
}
