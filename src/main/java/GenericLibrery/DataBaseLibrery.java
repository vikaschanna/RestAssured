package GenericLibrery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseLibrery {
	
	Driver dRef;
	Connection con;
	
	/**
	 * this method is used to connect to mySql db
	 * @author Vikas S
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		dRef = new Driver();
		DriverManager.registerDriver(dRef);
		con = DriverManager.getConnection(IConstantsLibrery.dbURL, IConstantsLibrery.dbUN, IConstantsLibrery.dbPwd);
	}
	
	/**
	 * This method is used for execute query and get the data from the executed query
	 * @author Vikas S
	 * @param query
	 * @param ColumnNo
	 * @param ExpData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query , int ColumnNo , String ExpData) throws Throwable {
			ResultSet result = con.createStatement().executeQuery(query);
			boolean flag = false;
			while(result.next()) {
				String data = result.getString(ColumnNo);
				if(data.equalsIgnoreCase(ExpData)) {
					flag = true;
					break;
				}	
			}
			if(flag) {
				System.out.println("-- Data is Verified");
				return ExpData;
			}
			else {
				System.out.println("-- Data is not Present");
				return "";
			}
			
	}
	
	
	/**
	 * this method will close the db connection
	 * @author Vikas S
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
			con.close();
	}
	
}
