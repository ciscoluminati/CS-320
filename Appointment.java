package appointmentservice;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
	private final String appointmentID;// Appointment ID is generated when constructor is called and set as a final variable
	private Date appointmentDate;
	private String appointmentDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
	// CONSTRUCTORS

	@SuppressWarnings("deprecation")
	public Appointment(Date appointmentDate, String appointmentDesc) {
		
		// Appointment ID		 
		// The idGenerator is static to prevent duplicates across all tasks.
		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
		
		//appointment date
		if (appointmentDate == null) {
			this.appointmentDate = new Date(2024, Calendar.JANUARY, 1);
		}
		else if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment before current date.");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
		
		//appointment description
		if (appointmentDesc == null || appointmentDesc.isEmpty()) {
			this.appointmentDesc = "NULL";
		}
		else if (appointmentDesc.length() > 50) {
			this.appointmentDesc = appointmentDesc.substring(0, 50);
		}
		else {
			this.appointmentDesc = appointmentDesc;
		}
	}
	
	// GETTERS
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	// SETTERS
	
	@SuppressWarnings("deprecation")
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null) {
			appointmentDate = new Date(2024, Calendar.JANUARY, 1);
		}
		else if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment before current date.");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
	}
	
	public void setAppointmentDesc(String appointmentDesc) {
		if (appointmentDesc == null || appointmentDesc.isEmpty()) {
			this.appointmentDesc = "NULL";
		}
		else if (appointmentDesc.length() > 50) {
			this.appointmentDesc = appointmentDesc.substring(0, 50);
		}
		else {
			this.appointmentDesc = appointmentDesc;
		}
	}
}