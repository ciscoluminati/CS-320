package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

//import appointmentservice.Appointment;
//import appointmentservice.AppointmentService;

class AppointmentServiceTest {

	
	//testing for a new service is created with 
	//default values for each field.
	//when appointment gets created, the tests are run based on that appointmentID,
	//in the order in which the tests are run depend on appointmentID.
	//Use the @Order to maintain this order.
	 
	
	private Date Date(int i, int january, int j) {
		return null;
	}
	
	@Test
	@DisplayName("Test to Update appointment date")
	@Order(1)
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.updateAppointmentDate(Date(3022, Calendar.FEBRUARY, 2), "7");
		service.displayAppointmentList();
		assertEquals(Date(3022, Calendar.FEBRUARY, 2), service.getAppointment("7").getAppointmentDate(), "Appointment date was not updated.");
	}

	@Test
	@DisplayName("Test to Update appointment description.")
	@Order(2)
	void testUpdateAppointmentDesc() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.updateAppointmentDesc("Updated Description", "9");
		service.displayAppointmentList();
		assertEquals("Updated Description", service.getAppointment("9").getAppointmentDesc(), "Appointment description was not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes appointments.")
	@Order(3)
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.deleteAppointment("11");
		
		ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>();// Making sure that the AppointmentList is now empty
		service.displayAppointmentList();
		assertEquals(service.appointmentList, appointmentListEmpty, "The appointment was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add an appointment.")
	@Order(4)
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.displayAppointmentList();
		assertNotNull(service.getAppointment("1"), "Appointment was not added correctly.");
	}
}