package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.Driver;
import user.domain.Lap;
import user.domain.Race;
import user.domain.Team;
import user.domain.User;
import java.sql.Statement;

public class TeamDao {
	

	public void Register(Team team) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "INSERT INTO participating_teams (team_name, manufacturer, points) "
					+ "VALUES(" + "'" + team.getName() + "'" + ", " + "'" + team.getManu() + "'"
					+ ", " + "'" + team.getPoints() + "'" + ");";
			
			
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
	
	public void Edit(Team team) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "UPDATE participating_teams "
					+ "SET team_name = '" + team.getName() + "', "
					+ "manufacturer = '" + team.getManu() + "', "
					+ "points = '" + team.getPoints() + "' "
					+ "WHERE team_name = '" + team.getName() + "';";
			
			
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
			
			
			String sql = "select * from participating_teams";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Team user = new Team();
				user.setName(resultSet.getString("team_name"));
				user.setManu(resultSet.getString("manufacturer"));
	    		user.setPoints(Integer.parseInt(resultSet.getString("location")));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public void deleteTeams() {
		Statement statement;
		try {
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			statement = connect.createStatement();

			String sql = "delete from participating_teams;";
			statement.executeUpdate(sql);
//			sql = "drop table if exists driver";
//			statement.executeUpdate(sql);
//			sql = "drop table if exists participating_teams;";
//			statement.executeUpdate(sql);
//			
//			sql = "create table participating_teams("
//					+ "	team_name VARCHAR(30),"
//					+ "manufacturer VARCHAR(20),"
//					+ "points SMALLINT UNSIGNED,"
//					+ "primary key (team_name)"
//					+ ");";
//			statement.executeUpdate(sql);
//			
//			sql = "create table race ("
//					+ "id smallint unsigned auto_increment,"
//					+ "location VARCHAR(30),"
//					+ "date DATE,"
//					+ "team_name VARCHAR(30),"
//					+ "primary key (id),"
//					+ "foreign key (team_name) references participating_teams(team_name) "
//					+ "ON DELETE CASCADE"
//					+ ");";
//			statement.executeUpdate(sql);

			
			
		    
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
