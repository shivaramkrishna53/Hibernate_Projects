package com.jpa.demo.JpaDemoProj;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Laptops")
public class Laptops {
	
	@Id
	int lid;
	String lname;
	int lprice;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getLprice() {
		return lprice;
	}
	public void setLprice(int lprice) {
		this.lprice = lprice;
	}
	@Override
	public String toString() {
		return "Laptops [lid=" + lid + ", lname=" + lname + ", lprice=" + lprice + "]";
	}
	
	

}
