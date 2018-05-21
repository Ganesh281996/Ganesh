package com.bridgelabz.model;

public class User
{
	private String name;
	private String gender;
	private String dateOfBirth;
	private String email;
	private String phone;
	private String address;
	private String password;
	
	public User(String name, String gender, String dateOfBirth, String email, String phone, String address,String password)
	{
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}
	
	public User() 
	{

	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "User [name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", password=" + password + "]";
	}
}