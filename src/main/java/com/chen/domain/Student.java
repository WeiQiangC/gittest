package com.chen.domain;

public class Student {
	private Integer id;
	private String name;
	private Integer telephone;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student() {
		super();
	}

	public Student(Integer id, String name, Integer telephone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", telephone=" + telephone + ", email=" + email + "]";
	}
}
