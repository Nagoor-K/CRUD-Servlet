package crudServlet.entity;

import java.util.Set;

import javax.persistence.*;

@Entity(name="students")
@Table(name="students")
public class Student {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="city")
	private String city;
	@OneToOne(targetEntity = Address.class)
	@JoinColumn(name="address")
	private Address address;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Course.class)
    @JoinColumn(name="student_id")
	private Set<Course> courses;
	
	public Student() { }
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Address getAddress() {
		return address;
	}
	
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student(String firstName, String lastName, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	public Student(int id, String firstName, String lastName, String city) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	public Student(String firstName, String lastName, String city, Address address,Set courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.address = address;
		this.courses = courses;
	}
	
}

