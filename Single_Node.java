package application;

import java.util.Date;

public class Single_Node {
	
	private Martyr data;  // the date in node is martyr information 
	private Single_Node Next;  // pointer to the next node in the list 
	
	
	public Single_Node(Martyr data) { // Constructor  with a parameter
		super();
		this.data = data;
	}
	
	
 // setter and getter  for variable
	public Martyr getData() {
		return data;
	}

	public void setData(Martyr data) {
		this.data = data;
	}

	public Single_Node getNext() {
		return Next;
	}

	public void setNext(Single_Node next) {
		Next = next;
	}
	

}
