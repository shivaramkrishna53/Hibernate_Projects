package com.telusko.HibernateProj2_savingofStudents;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student_table_info_table")
public class Student {

	@Id
	@Column(name="stuid")
	private int id;
	
	@Embedded
	private FullName Studentname;
    
	@Column(name = "stuage")
	private int age;
	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public FullName getStudentname() {
		return Studentname;
	}
	public void setStudentname(FullName studentname) {
		Studentname = studentname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Studentname=" + Studentname + ", age=" + age + "]";
	}
	
	

}
