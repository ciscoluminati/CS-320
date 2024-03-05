package contactservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

//import contactservice.Contact;
//import contactservice.ContactService;

import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

	//test service that check if you can update the list of contact. 
	
	@Test
	@DisplayName("Test to Update First Name.")
	@Order(1)
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact("OllyOllyOxenFree","Dr.", "Cross", "5555551111", "123 Lollypop Lane");
		service.updateFirstName("Sven", "9");
		service.displayContactList();
		assertEquals("Sven", service.getContact("9").getFirstName(), "First name was not updated.");
	}

	@Test
	@DisplayName("Test to Update Last Name.")
	@Order(2)
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact("OllyOllyOxenFree", "Dr.", "Cross", "5555551111", "123 Lollypop Lane");
		service.updateLastName("Shirley", "11");
		service.displayContactList();
		assertEquals("Shirley", service.getContact("11").getLastName(), "Last name was not updated.");
	}

	@Test
	@DisplayName("Test to update phone number.")
	@Order(3)
	void testUpdatePhoneNumber() {
		ContactService service = new ContactService();
		service.addContact("OllyOllyOxenFree", "Dr.", "Cross", "5555551111", "123 Lollypop Lane");
		service.updateNumber("5555550000", "17");
		assertEquals("5555550000", service.getContact("17").getNumber(), "Phone number was not updated.");
	}

	@Test
	@DisplayName("Test to update address.")
	@Order(4)
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact("OllyOllyOxenFree", "Dr.", "Cross", "5555551111", "123 Lollypop Lane");
		service.updateAddress("555 Nowhere Ave", "15");
		service.displayContactList();
		assertEquals("555 Nowhere Ave", service.getContact("15").getAddress(), "Address was not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes contacts.")
	@Order(5)
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact("OllyOllyOxenFree", "Dr.", "Cross", "5555551111", "123 Lollypop Lane");
		service.deleteContact("17");
		// Ensure that the contactList is now empty by creating a new empty contactList to compare it with
		ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
		service.displayContactList();
		assertEquals(service.contactList, contactListEmpty, "The contact was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add a contact.")
	@Order(6)
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("OllyOllyOxenFree", "Dr.", "Cross", "5555551111", "123 Lollypop Lane");
		service.displayContactList();
		assertNotNull(service.getContact("0"), "Contact was not added correctly.");
	}

}