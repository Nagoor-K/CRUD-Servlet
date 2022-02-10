package crudServlet.entity;

import javax.persistence.*;

@Entity(name="courses")
@Table(name="courses")
public class Course {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="fees")
	private double fees;
	
	public Course() {}

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

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Course(String name, double fees) {
		this.name = name;
		this.fees = fees;
	}

	public Course(int id, String name, double fees) {
		this.id = id;
		this.name = name;
		this.fees = fees;
	}
	
	
}
