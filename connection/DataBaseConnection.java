package connection;

import java.awt.Font;
import java.sql.*;

public class DataBaseConnection
{
	
	public Connection con;
	
	public DataBaseConnection()
	{
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=ѧ��";

		  String userName="sa";

		  String userPwd="zy20010213";

		  try

		  {
			  //�������ݿ�������
			   Class.forName(driverName);
			   con = DriverManager.getConnection(dbURL,userName,userPwd);//��ȡ���ݿ����Ӷ���
		        
			}

		  catch(Exception e)
		  {
			   e.printStackTrace();
		  }
	}

	public Connection  getConnection() {
		// TODO Auto-generated method stub
		return this.con;
	}
	public void close() throws SQLException{
	    this.con.close(); 
	}
	
}