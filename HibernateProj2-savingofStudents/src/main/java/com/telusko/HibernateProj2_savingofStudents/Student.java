package com.telusko.HibernateProj2_savingofStudents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student_table_info")
public class Student {

	@Id
	@Column(name="stuid")
	private int id;
	
	@Column(name = "stuname")
	private String name;
    
	@Column(name = "stuage")
	private int age;
	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
