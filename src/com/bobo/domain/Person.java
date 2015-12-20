package com.bobo.domain;

public class Person {
	private String name;//һ�㲻����null
	private int id;
	private String gender;
	private String description;
	
	public Person(int id, String name, String gender, String description) {
		this.id= id;
		this.name = name;
		this.gender = gender;
		this.description = description;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Person [����=" + name + ", �Ա�=" + gender
				+ ", ����=" + description + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
