package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
	// 添加操作
	    public void insert(Student s){
	      String sql = "INSERT INTO student (id, name) values (?,?)";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1,s.getID());
	        pstmt.setString(2,s.getName());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){  }
	      }
//更新操作
	    public void update(Student s){ 
	    	String sql = "update student set name = ? where id = ?";
		    PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    //针对数据库的具体操作
		    try{
		        conn = new DataBaseConnection();
		        
		        pstmt = conn.getConnection().prepareStatement(sql);
		        pstmt.setString(1,s.getName());
		        pstmt.setLong(2,s.getID());
		        //pstmt.setString(1,s.getID());
		  
		        pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		        }
		     catch(Exception e){  }
	    }

        public void delete(String iD){ 
        	String sql = "delete from student where id=? ";
		    PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    //针对数据库的具体操作
		    try{
		        conn = new DataBaseConnection();
		        
		        pstmt = conn.getConnection().prepareStatement(sql);
		        pstmt.setString(1,iD);
		  
		        pstmt.executeUpdate();
		        pstmt.close();
		        }
		     catch(Exception e){  }
        }
	    
	    public List findAll(){
	    	List<Student> list = new ArrayList<Student>();
	    	String sql = "select * from student";
		    PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    //针对数据库的具体操作
		    try{
		        conn = new DataBaseConnection();
		        
		        pstmt = conn.getConnection().prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        Student stu = null;
		        while(rs.next()) {
		        	stu = new Student();
		        	stu.setID(rs.getLong(1));
		        	stu.setName(rs.getString(2));
		        	list.add(stu);
		        }
		        rs.close();
		        pstmt.close();
		        }
		     catch(Exception e){  }
			return list;
	    }

        public Student findByID(long iD){  
        	String sql = "select * from student where id = ? ";
		    PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    Student stu = new Student();
		    //针对数据库的具体操作
		    try{
		        conn = new DataBaseConnection();
		        
		        pstmt = conn.getConnection().prepareStatement(sql);
		        pstmt.setLong(1,iD);
		        ResultSet rs = pstmt.executeQuery();
		        while(rs.next()) {
		        	stu.setID(rs.getLong(1));
		        	stu.setName(rs.getString(2));
		        }
		   
		        pstmt.close();
		        conn.close();
		        return stu;
		     }
		     catch(Exception e){  
		    	 return stu;
		     }
        }

 }
