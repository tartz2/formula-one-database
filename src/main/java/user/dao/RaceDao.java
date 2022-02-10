package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.Driver;
import user.domain.Race;
import user.domain.User;
import java.sql.Statement;

public class RaceDao {
	

	public void Register(Race race) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "INSERT INTO race (location, date, team_name) "
					+ "VALUES(" + "'" + race.getLocation() + "'" + ", " + "'" + race.getDate() + "'"
					+ ", " + "'" + race.getTeam() + "'" + ");";
			
			
			statement = connect.createStatement();

			statement.executeUpdate(sqlCom);

			
			
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Edit(Race race) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "UPDATE race "
					+ "SET team_name = '" + race.getTeam() + "' "
					+ "WHERE team_name = '" + race.getOldTeam() + "' and "
					+ "location = '" + race.getLocation() + "' and "
					+ "date = '" + race.getDate() + "';";
			
			
			statement = connect.createStatement();

			statement.executeUpdate(sqlCom);

			
			
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			
			
			String sql = "select * from race";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Race user = new Race();
				user.setLocation(resultSet.getString("location"));
	    		user.setDate(resultSet.getString("date"));
	    		user.setTeam(resultSet.getString("team_name"));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public void deleteRaces() {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			statement = connect.createStatement();
			String sqlCom = "delete from race";
			statement.executeUpdate(sqlCom);
			// String sqlCom = "drop table if exists race;";
//			statement.executeUpdate(sqlCom);
//			
//			sqlCom = "create table race ("
//					+ "id smallint unsigned auto_increment,"
//					+ "location VARCHAR(30),"
//					+ "date DATE,"
//					+ "team_name VARCHAR(30),"
//					+ "primary key (id),"
//					+ "foreign key (team_name) references participating_teams(team_name) "
//					+ "ON DELETE CASCADE"
//					+ ");";
//			statement.executeUpdate(sqlCom);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
