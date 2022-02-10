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
import user.domain.User;
import java.sql.Statement;

public class LapDao {
	

	public void Register(Lap lap) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "INSERT INTO lap_record (driver_name, lap_time, location) "
					+ "VALUES(" + "'" + lap.getName() + "'" + ", " + "'" + lap.getTime() + "'"
					+ ", " + "'" + lap.getLocation() + "'" + ");";
			
			
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
	
	public void Edit(Lap lap) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			String sqlCom = "UPDATE lap_record "
					+ "SET lap_time = '" + lap.getTime() + "' "
					+ "WHERE driver_name = '" + lap.getName() + "' and "
					+ "location = '" + lap.getLocation() + "';";
			
			
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
			
			
			String sql = "select * from lap_record";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Lap user = new Lap();
				user.setName(resultSet.getString("driver_name"));
				user.setTime(resultSet.getString("lap_time"));
	    		user.setLocation(resultSet.getString("location"));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public void deleteLaps() {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pd6?"
				              + "user=root&password=root");
			statement = connect.createStatement();
			String sqlCom = "delete from lap_record;";
			statement.executeUpdate(sqlCom);
//			String sqlCom = "drop table if exists lap_record;";
//			statement.executeUpdate(sqlCom);
//			
//			sqlCom = "create table lap_record("
//					+ "id SMALLINT unsigned auto_increment,"
//					+ "driver_name VARCHAR(20),"
//					+ "lap_time TIME,"
//					+ "location VARCHAR(30),"
//					+ "primary key (id),"
//					+ "foreign key (driver_name) references drivers(driver_name) "
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
