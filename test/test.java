package test;

import bean.Student;
import dao.StudentDAO;
import daoIMP.StudentDAOIMP;
import java.util.ArrayList;
import java.util.List;

public class test {
	public void testinsert() {
		StudentDAO dao = new StudentDAOIMP();
		Student s = new Student();
		s.setID(4);
		s.setName("Á¹Æ¤");
		dao.insert(s);
	}
	public void testdelete() {
		StudentDAO dao = new StudentDAOIMP();
		dao.delete("1");
	}
	public void testupdate() {
		StudentDAO dao = new StudentDAOIMP();
		Student s3 = new Student();
		s3.setID(3);
		s3.setName("Ðì");
		dao.update(s3);
	}
	public void testfindbyid(int id) {
		StudentDAO dao = new StudentDAOIMP();
		Student s2=dao.findByID(id);
		System.out.println(s2.getID()+" "+s2.getName());
	}
	public void testfindall() {
		StudentDAO dao = new StudentDAOIMP();
		List<Student> stu = dao.findAll();
		for(Student student : stu) {
			System.out.println(student.getID()+" "+student.getName());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new test();
		t.testfindall();
		t.testfindbyid(2);
	}

}
