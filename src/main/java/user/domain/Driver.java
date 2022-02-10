package user.domain;

public class Driver {

	private String name;
	private String country; 
	private String team;
	private int points;

	
	public String getName() {
		return name;
	}

	public void setName(String username) {
		this.name = username;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String countryName) {
		this.country = countryName;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String teamName) {
		this.team = teamName;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setPoints(int pointValue) {
		this.points = pointValue;
	}

}
