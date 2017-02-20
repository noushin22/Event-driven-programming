/**
 * This class creates a node, similar to array index, to to store in the Date212 data. This class
 * contains two instance variables: a pointer to the Date212 data in the node and a pointer to
 * the next node. A one-argument constructor to take Date212 element and store it in the node
 * and set the next node as null.
 * 
 * @author Noushin Iqra
 */
public class DateNode {

	// instance variables
	protected Date212 data;
	protected DateNode next;
	
	// create a node to store in Date212 data and set the next node as null
	public DateNode(Date212 d) {
		this.data = d;	
		this.next = null;
	} // DateNode constructor
	
}// DateNode
