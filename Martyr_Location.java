package application;

public class Martyr_Location implements Comparable <Martyr_Location>{
	
	private String location;  // private variable for location name 
	

	public Martyr_Location() { // Default constructor 
		super();
	}


	public Martyr_Location(String location) { // constructor with parameter
		super();
		this.location = location;
	}

 // setter and getter for location name 
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

 // compare between a location 
	@Override
	public int compareTo(Martyr_Location o) {
		return (this.getLocation().compareTo(o.getLocation()));
		
	}

	// to string to print location  information 
	@Override
	
	public String toString() {
		return  location  ;
	}

}
