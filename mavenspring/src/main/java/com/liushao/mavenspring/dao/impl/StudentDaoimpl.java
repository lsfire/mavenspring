package com.liushao.mavenspring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.liushao.mavenspring.common.Student;
import com.liushao.mavenspring.dao.StudentDao;
@Repository
public class StudentDaoimpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Student> stuRowMapper;
	
	public StudentDaoimpl() {
		stuRowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getLong("id"));
				student.setName(rs.getString("name"));
				return student;
			}
		};
	}

	@Override
	public Student getStudentById(Long stuId) {
		return jdbcTemplate.queryForObject("select id,name from student where id = ?", new Object[]{121250087l},stuRowMapper);
	}

	@Override
	public int saveStudent(Student student) {
		return jdbcTemplate.update("insert into student(name) values(?)", student.getName());
	}

}
