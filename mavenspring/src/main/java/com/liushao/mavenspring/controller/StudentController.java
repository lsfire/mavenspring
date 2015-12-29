package com.liushao.mavenspring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.liushao.mavenspring.common.Student;
import com.liushao.mavenspring.service.StudentService;

@Controller
@RequestMapping("web/student")
public class StudentController {
	private static final Log LOGGER = LogFactory.getLog(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public @ResponseBody Student getStudent(@RequestParam("student_id") Long stuId){
		
		Student stu = studentService.getStudentById(stuId);
		return stu;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody String addStudent(@RequestParam("student_id") Long id,@RequestParam("student_name") String name){
		LOGGER.info("studentID=" + id + " studentName=" + name);
		return "success";
	} 

}
