package com.liushao.mavenspring.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liushao.mavenspring.common.CourseSelection;
import com.liushao.mavenspring.common.Student;
import com.liushao.mavenspring.dao.CourseSelectionDao;
import com.liushao.mavenspring.dao.StudentAccountDao;
import com.liushao.mavenspring.dao.StudentDao;
import com.liushao.mavenspring.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentAccountDao saDao;
	@Autowired
	private CourseSelectionDao csDao;
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Student getStudentById(Long stuId) {
		
		return studentDao.getStudentById(stuId);
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int courseSelection(Long stuId, Long courseId) {
		CourseSelection selection = new CourseSelection();
		selection.setStuId(stuId);
		selection.setCourse_id(courseId);
		int i = csDao.saveCourseSelection(selection);
		
		int j = saDao.minusStudentAccount(stuId, new BigDecimal(40.0));
		return (i > 0) && (j >0) ? 1 : 0;
	}

}
