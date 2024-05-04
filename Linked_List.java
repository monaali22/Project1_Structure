package application;

import java.util.Date;

public class Linked_List {
	
    private Single_Node first;
    
    public int listLength = 0;

	public Linked_List() {
		super();
	}

	public Linked_List(Single_Node first) {
		super();
		this.first = first;
	}

	public Single_Node getFirst() {
		return first;
	}

	public void setFirst(Single_Node first) {
		this.first = first;
	}
    
    
    public void insertSort(Martyr data) {
    	
    	Single_Node newNode = new Single_Node(data); //Create a new node  
    	Single_Node current = first; // Node current will point to head 
    	Single_Node previous = null;
    	
    	while (current != null  && current.getData().compareTo(data) < 0) {
    		previous = current ;
    		current = current.getNext();
    		
    	}
    	
    	if (first == null) {    // case 1 add to empty link list
    		first = newNode;
    		
    	}
    	
    	else if (previous == null) {  // case 2 add to empty first element
    		newNode.setNext(first);
    		first = newNode;

    	}
    	else if (current == null) { //case 3 add the last
    		previous.setNext(newNode);

    	}
    	
    	else {     // case 4 insert between two node (current and previous )
    		newNode.setNext(current);
    		previous.setNext(newNode);
    		listLength++;

    	}
    	
    }
    
  public void delete (Martyr data) {
		Single_Node current = first; // Node current will point to head  
		Single_Node privous = null;
		
		if (first == null) { // case 1 Empty list (No element)
			return;
		}
		
		else {
			if (first.getData().getName().equals(data.getName()) == true) { // case 2 remove first
				first = first.getNext();

			}
			
			else {
			
				
				while (current != null && current.getData().getName().equals(data.getName()) == false) {
					privous = current; 
					current = current.getNext(); // move current to next node 
				}
				
				if (current != null) { // remove from between node 
					privous.setNext(current.getNext());

					
				}
				
				
			}
		}
	}
  
      public void update(Martyr data) {
    	  
  	          Single_Node current = first; // first node in single list 
  	          
  	          for ( ;  current != null ; current = current.getNext()) {
  	        	  if (current.getData().getName().equals(data.getName()) == true){
  	        		current.getData().setAge(data.getAge());
  	        		current.getData().setGender(data.getGender());
  	        		current.getData().setDateOfDeth(data.getDateOfDeth());
  	        	  }
  	        	  
  	        	  else if (current.getData().getName().equals(data.getName()) == false && current.getData().getAge()==data.getAge()
  	        			 && current.getData().getGender()== data.getGender()){
  	        		  current.getData().setName(data.getName());
  	        	  }
   {
  	        		  
  	        	  }
  	        	  
  	          }
  }
      
      
     
}
