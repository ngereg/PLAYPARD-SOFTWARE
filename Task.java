import java.util.Date;

public class Task {

	private int id;
	private String name;
	private String description;
	private Date dueDate; // int year(current-1900); int month(current-1); int date
	private int priority; // 0 is normal, 1 is emergency
	private int progress; // -1 is finish, 0 is doing, 1 is to do
	
	
	public Task (int id, String name, String description, Date dueDate, int priority, int progress) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.progress = progress;
	}
	
	//Getter Methods
	public int getID() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getProgress() {
		return progress;
	}
	
	//Setter Methods
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	public String toString() {
	    int dueDateYear = dueDate.getYear()+1900;
	    int dueDateMonth = dueDate.getMonth()+1;
		String date = dueDateMonth + "/" + dueDate.getDate() + "/" + dueDateYear;
		return id + ";" + name + ";" + description + ";" 
				+ date + ";" + priority + ";" + progress;
	}
}
