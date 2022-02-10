package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import java.sql.Statement;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class InitializeDao {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void initDB() {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			statement = connect.createStatement();
			
			String sql = "DROP TABLE IF EXISTS pd6.lap_record;";
			statement.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS pd6.drivers;";
			statement.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS pd6.race;";
			statement.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS pd6.participating_teams;";
			statement.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS pd6.tb_user;";
			statement.executeUpdate(sql);
			
			sql = "create table participating_teams("
					+ "	team_name VARCHAR(30),"
					+ "manufacturer VARCHAR(20),"
					+ "points SMALLINT UNSIGNED,"
					+ "primary key (team_name) "
					+ ");";
			statement.executeUpdate(sql);
			
			sql = "create table race ("
					+ "id smallint unsigned auto_increment,"
					+ "location VARCHAR(30),"
					+ "date DATE,"
					+ "team_name VARCHAR(30),"
					+ "primary key (id),"
					+ "foreign key (team_name) references participating_teams(team_name) "
					+ "ON DELETE CASCADE"
					+ ");";
			statement.executeUpdate(sql);
			
			sql = "create table drivers("
					+ "driver_name VARCHAR(20),"
					+ "origin_country VARCHAR(20),"
					+ "team_name VARCHAR(30),"
					+ "points SMALLINT UNSIGNED,"
					+ "primary key (driver_name),"
					+ "foreign key (team_name) references participating_teams(team_name) "
					+ "ON DELETE CASCADE"
					+ ");";
			statement.executeUpdate(sql);
			
			sql = "create table lap_record("
					+ "id SMALLINT unsigned auto_increment,"
					+ "driver_name VARCHAR(20),"
					+ "lap_time TIME,"
					+ "location VARCHAR(30),"
					+ "primary key (id),"
					+ "foreign key (driver_name) references drivers(driver_name)"
					+ "ON DELETE CASCADE"
					+ ");";
			statement.executeUpdate(sql);
			
			sql = "create table tb_user("
					+ "username VARCHAR(50),"
					+ "password VARCHAR(50),"
					+ "email VARCHAR(50),"
					+ "primary key (username)"
					+ ");";
			statement.executeUpdate(sql);
			
			String sqlStmnt = "INSERT INTO participating_teams "
					+ "VALUES('Red Bull Racing Honda', 'Honda', 286),"
					+ "('Mercedes', 'Mercedes', 242),"
					+ "('McLaren Mercedes', 'McLaren', 141);";
			statement.executeUpdate(sqlStmnt);
			
			sqlStmnt = "INSERT INTO race (location, date, team_name) "
					+ "VALUES('Bahrain', '2021-01-01', 'Mercedes'),"
					+ "('Emilia Romagna', '2021-02-01', 'Red Bull Racing Honda'),"
					+ "('Portugal', '2021-03-01', 'McLaren Mercedes');";
			statement.executeUpdate(sqlStmnt);
			sqlStmnt = "INSERT INTO drivers "
					+ "VALUES('Max Verstappen', 'Netherlands', 'Red Bull Racing Honda', 182),"
					+ "('Lewis Hamilton', 'United Kingdom', 'Mercedes', 150),"
					+ "('Lando Norris', 'United Kingdom', 'McLaren Mercedes', 104);";
			statement.executeUpdate(sqlStmnt);
			sqlStmnt = "INSERT INTO lap_record(driver_name, lap_time, location) "
					+ "VALUES('Max Verstappen', '00:03:40', 'Portugal'),"
					+ "('Lando Norris', '00:02:31', 'Bahrain'),"
					+ "('Lewis Hamilton', '00:03:01', 'Emilia Romagna');";
			statement.executeUpdate(sqlStmnt);
			sqlStmnt = "INSERT INTO tb_user "
					+ "VALUES('username1', 'password1', 'email1@uic.edu'),"
					+ "('username2', 'password2', 'email2@uic.edu'),"
					+ "('username3', 'password3', 'email3@uic.edu');";
			statement.executeUpdate(sqlStmnt);

			
			
		    
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
