package com.liushao.mavenspring.servicetests;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.liushao.mavenspring.BaseTest;
import com.liushao.mavenspring.common.Student;
import com.liushao.mavenspring.service.StudentService;

public class StudentServiceTest extends BaseTest{
	private static final Log LOGGER = LogFactory.getLog(StudentServiceTest.class);
	@Autowired
	private StudentService studentService;
	@Test
	public void testStudentService() {
		Student student = studentService.getStudentById(121250087l);
		LOGGER.info(JSON.toJSONString(student));
	}
	
	@Test
	public void testCourseSelection(){
		int result = studentService.courseSelection(121250087l, 102l);
	}

}
