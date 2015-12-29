package com.liushao.mavenspring.dao;


import com.liushao.mavenspring.common.Student;
public interface StudentDao {
	
	public Student getStudentById(Long stuId);
	
	public int saveStudent(Student student);

}
