package application;

public class Double_Node {
	
	
	
	private Martyr_Location data ;
	private Double_Node Next; // pointer to the next node in the list 
	private Double_Node privous; // pointer to the previous node in the list 
	
	Linked_List singleList = new Linked_List();  // create Object from Linked list in The double linked list Node
	
	// a default constructor with no parameter
	public Double_Node() {
		super();
	}
 
 // a constructor with a parameter 
	public Double_Node(Martyr_Location data) {
		super();
		this.data = data;
	}

	// setter and getter for All variable in Double linked list Node

	public Martyr_Location getData() {
		return data;
	}


	public void setData(Martyr_Location data) {
		this.data = data;
	}
 

	
	public Linked_List getSingleList() {
		return singleList;
	}


	public void setSingleList(Linked_List singleList) {
		this.singleList = singleList;
	}


	public Double_Node getNext() {
		return Next;
	}


	public void setNext(Double_Node next) {
		Next = next;
	}


	public Double_Node getPrivous() {
		return privous;
	}


	public void setPrivous(Double_Node privous) {
		this.privous = privous;
	}


	
}
