package com.liushao.mavenspring.dao;

import java.math.BigDecimal;

public interface StudentAccountDao {
	
	public int minusStudentAccount(Long stuId,BigDecimal minus);

}
