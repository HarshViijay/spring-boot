package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.enitites.Student;

public class StudentDaoimpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
// insert query
        
        String query = "insert into student(id, name, city) values(?,?,?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		// TODO Auto-generated method stub
		return r;
	}
	
	public int change(Student student) {
		//updating data
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		// TODO Auto-generated method stub
		return r;
	}
	
	public int delete(int studentId) {
		//delete operation
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		// TODO Auto-generated method stub
		return r;
	}
	
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		
		//select single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperimpl();		
		Student student = this.jdbcTemplate.queryForObject(query,  rowMapper, studentId);
		
		return student;
	}
	
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		// Selecting multiple students
		
		String query = "select * from student";
		List<Student> students =  this.jdbcTemplate.query(query, new RowMapperimpl());
		return students;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	




	

	
}
