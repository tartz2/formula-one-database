package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.Driver;
import user.domain.User;
import java.sql.Statement;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class RegisterDriver {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void Register(Driver driver) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "INSERT INTO drivers (driver_name, origin_country, team_name, points) "
					+ "VALUES(" + "'" + driver.getName() + "'" + ", " + "'" + driver.getCountry() + "'"
					+ ", " + "'" + driver.getTeam() + "'" + ", " + "'" + driver.getPoints() + "'" + ");";
			
			
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
	
	public void Edit(Driver driver) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "UPDATE drivers "
					+ "SET driver_name = '" + driver.getName() + "',  "
					+ "origin_country = '" + driver.getCountry() + "', "
					+ "team_name = '" + driver.getTeam() + "', "
					+ "points = '" + driver.getPoints() + "' "
					+ "WHERE driver_name = '" + driver.getName() + "';";
			
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
			
			
			String sql = "select * from drivers";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Driver user = new Driver();
				user.setName(resultSet.getString("driver_name"));
	    		user.setCountry(resultSet.getString("origin_country"));
	    		user.setTeam(resultSet.getString("team_name"));
	    		user.setPoints(Integer.parseInt(resultSet.getString("points")));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public void deleteDrivers() {
			Statement statement;
			try {
			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connect = DriverManager
				          .getConnection("jdbc:mysql://localhost:3306/pd6?"
					              + "user=root&password=root");
				statement = connect.createStatement();
				String sqlCom = "delete from drivers";
//				String sqlCom = "drop table if exists lap_record";
//				statement.executeUpdate(sqlCom);
//				sqlCom = "drop table if exists drivers;";
//				statement.executeUpdate(sqlCom);
//				
//				sqlCom = "create table drivers("
//						+ "driver_name VARCHAR(20),"
//						+ "team_name VARCHAR(20),"
//						+ "points SMALLINT UNSIGNED,"
//						+ "origin_country VARCHAR(20),"
//						+ "primary key (driver_name),"
//						+ "foreign key (team_name) references participating_teams(team_name) "
//						+ "ON DELETE CASCADE);";
//				statement.executeUpdate(sqlCom);
//				
//				sqlCom = "create table lap_record("
//						+ "id SMALLINT unsigned auto_increment,"
//						+ "driver_name VARCHAR(20),"
//						+ "lap_time TIME,"
//						+ "location VARCHAR(30),"
//						+ "primary key (id),"
//						+ "foreign key (driver_name) references drivers(driver_name) "
//						+ "ON DELETE CASCADE"
//						+ ");";
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
	
		
}
