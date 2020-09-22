package com.hp.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DataTypeDTO implements Serializable{
	
	/**  */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private Integer age;
	
	private Date birthday;
	
	private Boolean isDeleted;
	
	private BigDecimal amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DataTypeDTO [name=" + name + ", age=" + age + ", birthday=" + birthday + ", isDeleted=" + isDeleted
				+ ", amount=" + amount + "]";
	}
	
}
