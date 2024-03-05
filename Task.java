package taskservice;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private String taskID;
	private String taskName;
	private String taskDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
	
	//Task ID is truncated to a maximum of 10 characters,
	//the task name to 20 characters, and description to 50
	//characters.
	  
	// CONSTRUCTORS 
	public Task(String taskName, String taskDesc, String taskId) {		
		// TASKID	
		this.taskID = String.valueOf(idGenerator.getAndIncrement());
		
		//task name
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		}
		else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		}
		else {
			this.taskName = taskName;
		}
		//task description
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		}
		else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		}
		else {
			this.taskDesc = taskDesc;
		}
	}
	
	// GETTERS
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
	// SETTERS
	//task name
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		}
		else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		}
		else {
			this.taskName = taskName;
		}
	}
	//task description
	public void setTaskDesc(String taskDesc) {
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		}
		else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		}
		else {
			this.taskDesc = taskDesc;
		}
	}
}