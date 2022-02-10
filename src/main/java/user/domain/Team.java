package user.domain;
import java.sql.Date;

public class Team {

	
	private String name;
	private String oldName;
	private String manufacturer; 
	private int points;

	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getManu() {
		return manufacturer;
	}

	public void setManu(String manu) {
		this.manufacturer = manu;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints (int points) {
		this.points= points;
	}
	

}
