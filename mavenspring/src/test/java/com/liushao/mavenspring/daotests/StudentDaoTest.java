package com.liushao.mavenspring.daotests;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.liushao.mavenspring.BaseTest;
import com.liushao.mavenspring.common.Student;
import com.liushao.mavenspring.dao.StudentDao;
public class StudentDaoTest extends BaseTest{
	private static final Log LOGGER = LogFactory.getLog(StudentDaoTest.class);
	@Autowired
	StudentDao studentDao;
	
	@Before
	public void before(){
		
	}
	
	@Test
	public void testGetStudenById(){
		try {
			Student student = studentDao.getStudentById(121250087l);
			LOGGER.info(JSON.toJSONString(student));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveStudent(){
		Student student = new Student();
		student.setName("fuye");
		int result = studentDao.saveStudent(student);
		Assert.assertEquals(result, 1);
	}

}
