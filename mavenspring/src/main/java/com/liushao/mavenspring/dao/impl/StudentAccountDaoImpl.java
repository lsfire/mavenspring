package com.liushao.mavenspring.dao.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.liushao.mavenspring.dao.StudentAccountDao;

@Repository
public class StudentAccountDaoImpl implements StudentAccountDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int minusStudentAccount(Long stuId, BigDecimal minus){
		return jdbcTemplate.update("update stu_account set account=account-? where stuId=?",new Object[]{minus,stuId});
	}

}
