package contactservice;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private static AtomicLong idGenerator = new AtomicLong();

		
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {

		this.contactID = String.valueOf(idGenerator.getAndIncrement());
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setAddress(address);
		
		//CONSTRUCTOR
		
		// FIRSTNAME
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";
		}		
		
		// If first name is longer than 10 characters,
				//the first 10 characters will be added
		else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		}
		
		else {
			this.firstName = firstName;
		}

		// LAST NAME
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		}
		
		else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		}
		
		else {
			this.lastName = lastName;
		}
		
		// PHONE NUMBER
		if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() != 10) {
			this.phoneNumber = "5555555555";
		}
		
		else {
			this.phoneNumber = phoneNumber;
		}
		
		// ADDRESS
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		}
		
		else if (address.length() > 30) {
			this.address = address.substring(0, 30);
		}
		
		else {
			this.address = address;
		}
	}

	// GETTERS
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	// SETTERS
	//each else if is a condition that allow to accept
	//a portion of the entry
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";
		}

		// If first name is longer than 10 characters,
		//the first 10 characters will be added
		else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		}
		
		else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		}
		
		else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		}
		
		else {
			this.lastName = lastName;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() != 10) {
			this.phoneNumber = "5555555555";
		}
		
		else {
			this.phoneNumber = phoneNumber;
		}
	}

	public void setAddress(String address) {
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		}
	
		else if (address.length() > 30) {
			this.address = address.substring(0, 30);
		}
		
		else {
			this.address = address;
		}
	}
}