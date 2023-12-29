package com.work.model;


import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admn_data")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private String userName;
	
	private String emailId;
	
	private String password;
	
	private String phone;
	
	private String address;
	
	private int otp;
	
	private String role;

	private int salary;

	private int age;

	private int annualSalary;

	private String DoB;

	private String department;


	public Admin(int id, String userName, String emailId, String password, String phone, String address, int otp,
			String role, int salary, String department, int annualSalary, String DoB) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.otp = otp;
		this.role = role;
		this.salary = salary;
		this.department = department;
		this.annualSalary = annualSalary;
		this.DoB = DoB;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}



	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int calculateAge(LocalDate DoB) {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(DoB, currentDate);
		return period.getYears();
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", otp=" + otp + ", role=" + role + ", salary=" + salary
				+ ", age=" + age + ", annualSalary=" + annualSalary + ", DoB=" + DoB + ", department=" + department
				+ "]";
	}



	

	
	
	
	
	

}
