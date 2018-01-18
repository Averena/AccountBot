package org.itstep.model;

public class Account {
	private String email;
	private String password;
	private String firstName;
	private String secondName;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public Account() {
		
	}
	public Account(String firstName, String secondName) {
		this.email = Randomizer.getEmail(firstName, secondName);
		this.password = Randomizer.getPassword(secondName);
		this.firstName = firstName;
		this.secondName = secondName;
	}
}
