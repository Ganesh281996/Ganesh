package com.bridgelabz.utility;

public class Patient 
{
	private int patientId;
	private String patientName;
	private long mobileNumber;
	
	public Patient(int patientId, String patientName, long mobileNumber) 
	{
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNumber = mobileNumber;
	}

	public int getPatientId() 
	{
		return patientId;
	}

	public void setPatientId(int patientId) 
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

	public long getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}
	
}