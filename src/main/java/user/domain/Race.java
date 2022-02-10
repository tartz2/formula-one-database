package user.domain;
import java.sql.Date;

public class Race {

	
	private String location;
	private String date; 
	private String team;
	private String oldTeam;

	

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return Date.valueOf(date);
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String teamName) {
		this.team = teamName;
	}
	
	public String getOldTeam() {
		return oldTeam;
	}

	public void setOldTeam(String teamName) {
		this.oldTeam = teamName;
	}
	

}
