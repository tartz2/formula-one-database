package user.domain;
import java.sql.Time;

public class Lap {

	private String name; 
	private String location;
	private String time;


	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Time getTime() {
		return Time.valueOf(time);
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
