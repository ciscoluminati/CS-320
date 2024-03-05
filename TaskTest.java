package taskservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import taskservice.Task;

public class TaskTest {
	/*
	 * these tests are to make sure that the 
	 * field do not become longer than they suppose to (10 characters for the taskID,
	 *  50 characters for the description). 
	 */
	
	@Test
	@DisplayName("Task ID cannot have more than 10 characters")
	void testTaskIDWithMoreThanTenCharacters() {
		Task task = new Task("OllyOllyOxenFree", "Name", "Description");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Task Name cannot have more than 20 characters")
	void testTaskNameWithMoreThanTwentyCharacters() {
		Task task = new Task("taskId","OllyOllyOxenFreeOllyOllyOxenFree", "Description");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}

	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testTaskDescWithMoreThanFiftyCharacters() {
		Task task = new Task("taskId", "Name", "123456789 is nine characters long" 
				+ "123456789 is another nine characters long" 
				+ "123456789 is another nine characters long"
				+ "123456789 is another nine characters long");
		if (task.getTaskDesc().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}

	@Test
	@DisplayName("TaskID shall not be null")
	void testTaskIDNotNull() {
		Task task = new Task(null, "Name", "Description");
		assertNotNull(task.getTaskID(), "TaskID was  null");
	}
	
	@Test
	@DisplayName("Task Name shall not be null")
	void testTaskNameNotNull() {
		Task task = new Task("TaskID", null, "Description");
		assertNotNull(task.getTaskName(), "Task Name was null.");
	}
	
	@Test
	@DisplayName("Task Description shall not be null")
	void testTaskDescNotNull() {
		Task task = new Task("TaskID", "Name", null);
		assertNotNull(task.getTaskDesc(), "Task Description was null.");
	}
}