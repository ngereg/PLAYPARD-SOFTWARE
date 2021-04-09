
public class Task {

	private int id;
	private String name;
	private String description;
	private String date;
	private int priority;
	private int progress;
	
	
	public Task (int id, String name, String description, String date, int priority, int progress) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
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
	
	public String getDate() {
		return date;
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
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	
}
