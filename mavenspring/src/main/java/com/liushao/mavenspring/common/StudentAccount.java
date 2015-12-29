package com.liushao.mavenspring.common;

import java.math.BigDecimal;

public class StudentAccount {

	private Long id;
	
	private Long stuId;
	
	private BigDecimal account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStu_id() {
		return stuId;
	}

	public void setStu_id(Long stu_id) {
		this.stuId = stu_id;
	}

	public BigDecimal getAccount() {
		return account;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}
	
	

}
