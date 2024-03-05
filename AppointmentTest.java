package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import appointmentservice.Appointment;

class AppointmentTest {

	/*
	 * these tests are to make sure that the field does
	 * not become longer than they suppose to (10 characters for
	 * appointmentID, 50 characters for appointment description). 
	 * The 3rd test checks for the current date.
	 * The last 2 tests ensure that each field is not null.
	 */
	
	private Date Date(int i, int january, int j) {
		return null;
	}
	
	@Test
	@DisplayName("Appointment ID cannot have more than 10 characters")
	void testAppointmentIDWithMoreThanTenCharacters() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description");
		if (appointment.getAppointmentID().length() > 10) {
			fail("Appointment ID has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testAppointmentDescWithMoreThanFiftyCharacters() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "123456789 is nine characters long" 
				+ "123456789 is another nine characters long" 
				+ "123456789 is another nine characters long"
				+ "123456789 is another nine characters long");
		if (appointment.getAppointmentDesc().length() > 50) {
			fail("Appointment Description has more than 50 characters.");
		}
	}
	
	@Test
	@DisplayName("Appointment Date cannot be before current date")
	void testAppointmentDateBeforeCurrent() {
		Appointment appointment = new Appointment(Date(1022, Calendar.JANUARY, 1), "Description");
		if (appointment.getAppointmentDate().before(new Date())) {
			fail("Appointment Date is before current date.");
		}
	}

	@Test
	@DisplayName("Task Date shall not be null")
	void testAppointmentDateNotNull() {
		Appointment appointment = new Appointment(null, "Description");
		assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
	}
	
	@Test
	@DisplayName("Task Description shall not be null")
	void testAppointmentDescNotNull() {
		Appointment task = new Appointment(Date(2024, Calendar.JANUARY, 1), null);
		assertNotNull(task.getAppointmentDesc(), "Appointment Description was null.");
	}
}