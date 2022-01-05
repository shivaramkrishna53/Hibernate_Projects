package HibernateProj12_HQL.HibernateProj12_HQL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
	
	@Id
	int eno;
	String ename;
	String edept;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}
	@Override
	public String toString() {
		return "Employees [eno=" + eno + ", ename=" + ename + ", edept=" + edept + "]";
	}
	
	

}
