package com.liushao.mavenspring.service;

import com.liushao.mavenspring.common.CourseSelection;
import com.liushao.mavenspring.common.Student;

public interface StudentService {
	
	public Student getStudentById(Long stuId);
	
	public int courseSelection(Long stuId,Long courseId);

}
