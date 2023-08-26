package models;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 90743496186474186L;
	
	private String firstName;
	private String lastName;
	private String username;
	private String dateOfBirth;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String username, String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
}
