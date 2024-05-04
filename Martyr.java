package application;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Martyr implements Comparable <Martyr>{
	
	private String name ;
	private int age;
	private Date dateOfDeth  = new Date();
	private char Gender;
	
	
	
	public Martyr() { // Default constructor with no parameter 
		super();
	}

	public Martyr(String name ) { // constructor with just the name 
		this.name = name;
		
	}
	
	public Martyr(String name, int age, Date dateOfDeth, char gender) { // Constructor with all parameter
		super();
		this.name = name;
		this.age = age;
		this.dateOfDeth = dateOfDeth;
		this.Gender = gender;
	}

 // setter and getter for martyr information 
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getDateOfDeth() {
		
		    return dateOfDeth;
	}


	public void setDateOfDeth(Date dateOfDeth) {
		this.dateOfDeth = dateOfDeth;
	}


	public char getGender() {
		return Gender;
	}


	public void setGender(char gender) {
		Gender = gender;
	}
	
	 // to string method to print a martyr information 
	@Override
	public String toString() {
		return " " + name +" , " + age  +" , " +dateOfDeth+" , "+ Gender + "";
	}
 //  compareTo method that compare between martyr by date of death
	@Override
	public int compareTo(Martyr o) {
		return  (this.getDateOfDeth().compareTo(o.getDateOfDeth()));
			
	}


	
}
