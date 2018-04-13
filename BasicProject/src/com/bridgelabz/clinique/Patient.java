/**
 * @purpose Pojo of Patient
 * @author Ganesh
 * @since 11 March 2018
 */
package com.bridgelabz.clinique;

public class Patient 
{
	private long patientId;
	private String patientName;
	private long phoneNumber;
	private long age;
	
	public Patient(long patientId, String patientName, long phoneNumber, long age) 
	{
		this.patientId = patientId;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
	public Patient()
	{
		
	}
	
	public long getPatientId() 
	{
		return patientId;
	}
	public void setPatientId(long patientId)
	{
		this.patientId = patientId;
	}
	public String getPatientName() 
	{
		return patientName;
	}
	public void setPatientName(String patientName) 
	{
		this.patientName = patientName;
	}
	public long getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	public long getAge() 
	{
		return age;
	}
	public void setAge(long age) 
	{
		this.age = age;
	}

	@Override
	public String toString() 
	{
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", phoneNumber=" + phoneNumber
				+ ", age=" + age + "]";
	}
}