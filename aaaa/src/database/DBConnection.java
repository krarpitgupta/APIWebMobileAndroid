package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	Connection conn = null;
	Statement stmt=null;
	ResultSet rs=null;
	public DBConnection() throws SQLException {
         connection();
	}

	public void connection() throws SQLException {
		
		try {

			Class.forName(DBDrivers.JDBCDriver);
			conn = DriverManager.getConnection(DBDrivers.ConnectionUrl,
					DBDrivers.DbUser, DBDrivers.DbPass);
		        stmt = conn.createStatement();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	public String fetchSingleValueFromDB(String query)
	{
		String value="";
		try
		{
			  rs = stmt.executeQuery(query);
			  rs.next();
			  value=rs.getString(1);
		}
		catch(Exception ee)
		{
			
		}
		return value;
	}

	public static void main(String args[]) throws SQLException {
		DBConnection dbc = new DBConnection();
        System.out.println(dbc.fetchSingleValueFromDB("select Nav from dbo.MF_HistoricalNav where schemeID=104 and NAVdate='2005-01-03'"));
     //dbc.fetchSingleValueFromDB("select * from abad.studentinfo");
	}
}
